package com.uttara.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        System.out.println("in no-arg constr of CS");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet() of CS");
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost() of CS");
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in process() of CS");
		//embed controlling logic here!
		
		/*
		 * if req is coming by user clicking Click to Register,
		 * forward to Register.jsp
		 * if req is coming for /openLoginView.do then forward to
		 * Login.jsp
		 */
		Model model = new Model();
		String uri = request.getRequestURI();
		System.out.println("uri = "+uri);
		RequestDispatcher rd = null;
		
		if(uri.contains("/openEditAccountView.do"))
		{
			//pre-processing usecase
			//ask model to fetch data of user
			//forward to EditAccount.jsp
			
			HttpSession session = request.getSession(false);
			if(session==null || session.getAttribute("user")==null)
			{
				request.setAttribute("errorMsg", "First login, then try to edit account!");
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			else
			{
				String email = (String) session.getAttribute("user");
				
				RegBean bean = model.getUserDetail(email);
				request.setAttribute("userDetail", bean);
				rd = request.getRequestDispatcher("EditAccount.jsp");
				rd.forward(request, response);
			}
			
		}
		if(uri.contains("/fetchUsers.do"))
		{
			List<RegBean> list = model.getUsers();
			
			//forward to DisplayUsers.jsp
			request.setAttribute("listUsers",list);
			rd = request.getRequestDispatcher("DisplayUsers.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/logout.do"))
		{
			//invalidate the session
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				session.removeAttribute("user");
				session.invalidate();
			}
			rd = request.getRequestDispatcher("Success.jsp");
			request.setAttribute("msg","You have logged out successfully! Who are you? Click <a href='HomePage.jsp'>Click to go back to HomePage</a>");
			rd.forward(request, response);
		}
		
		if(uri.contains("/openRegisterView.do"))
		{
			//forward to Register.jsp
			rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
			return;
		}
		if(uri.contains("/openLoginView.do"))
		{
			//forward to Login.jsp
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			return;
		}
		if(uri.contains("/register.do"))
		{
			//pull bean from request
			RegBean bean = (RegBean)request.getAttribute("reg");
			System.out.println("inside uri.contains(/register) bean = "+bean);
			// invoke Model method and pass the bean
			String result = model.register(bean);
			if(result.equals(Constants.SUCCESS))
			{
				//registration has succeeded!
				//forward to Success view
				request.setAttribute("msg", "Your registration has succeeded! Click <a href='HomePage.jsp'>Click to go back to HomePage</a>");
				rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
				return;
			}
			else
			{
				//registration has failed!
				//forward to Register.jsp
				
				request.setAttribute("errorMsg",result);
				rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
				return;
			}
		
			
		}
		if(uri.contains("/deleteTask.do"))
		{
			String sl = request.getParameter("sl_no");
			HttpSession session = request.getSession(false);
			String email = (String) session.getAttribute("user");
			String msg = model.deleteTask(email,Integer.parseInt(sl));
			if(msg.equals(Constants.SUCCESS))
			{
				request.setAttribute("msg", "Task has been deleted successfully!");
				rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMsg", msg);
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			
			}
			
			
		}
		if(uri.contains("/login.do"))
		{
			System.out.println("in uri.contains(/login.do)");
			//pull the bean
			LoginBean bean = (LoginBean) request.getAttribute("log");
			System.out.println("bean = "+bean);
			
			String result = model.authenticate(bean);
			if(result.equals(Constants.SUCCESS))
			{
				//login successful!
				//create a session! for the user and store data we need to remember!
				HttpSession session = request.getSession(true);
				session.setAttribute("user", bean.getEmail());
				
				List<TaskBean> tasks = model.getTasks(bean.getEmail());
				
				request.setAttribute("listTasks", tasks);
				rd = request.getRequestDispatcher("Menu.jsp");
				rd.forward(request, response);
				return;
			}
			else
			{
				//login failure!
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				return;
		
			}
		}
		
	}
	
}





