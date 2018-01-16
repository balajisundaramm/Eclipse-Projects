package com.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerServlet() {
        super();
       System.out.println("In no arg cons of controller");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get of Coltroller");
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In process of Coltroller");
		// Getting uri 
		String uri=request.getRequestURI();
		System.out.println("URI->"+uri);
		
		Model model= new Model();
		RequestDispatcher rd= null;
			
		// map the uri to respected jsp (BL)
		if(uri.contains("/openRegisterView.do")) {
			// forwarding the request to regiter.jsp 
			rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		
		if(uri.contains("/loginRegisterView.do")) {
			// forwarding the request to login.jsp
			rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/openEditAccountView.do")) {
			// forwarding the request to login.jsp
			HttpSession session = request.getSession(false);
			if(!(session==null)) {
			rd=request.getRequestDispatcher("EditAccount.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "First login, then try to edit account!");
				rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		}
		
		if(uri.contains("/register.do")) {
			System.out.println("in process-->controller '/register.do' if block");
			/*
			 * 1.Get the Bean from request scope
			 * 2. invoke model Register(Bean)
			 * 3. check whether the request succeeds
			 * 4. if succeeds--> forward to success.jsp
			 * 5. else forward to Register.jsp
			 */
			
			RegBean bean=(RegBean)request.getAttribute("reg");
			System.out.println("bean-->"+bean);
			

			
			String result=model.register(bean);
			if(result.equals("SUCCESS")) {
				// Registration succeeded
				// forward to success.jsp
				request.setAttribute("message", "Your registeration process succeeded! "
						+ "Click <a href='HomePage.html'>Click to go back to HomePage</a> "
						+ "Click <a href='Login.jsp'>Click here to login</a>");
				rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else {
				// Registration failed
				request.setAttribute("errorMsg", result);
				rd=request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
				
			}
				
		}
		
		if(uri.contains("/login.do")) {
			System.out.println("/ login.do in controller");
			/*
			 * 1.Get the Bean from request scope
			 * 2. invoke model Login(Bean)
			 * 3. check whether the request succeeds
			 * 4. if succeeds--> forward to menu.jsp
			 * 5. else forward to Login.jsp
			 */
			
			LoginBean bean=(LoginBean)request.getAttribute("reg");
			System.out.println("bean-->"+bean);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", bean.getEmail());
			
				String result=model.login(bean);
				if(result.equals("SUCCESS")) {
					// login succeeded
					// forward to menu.jsp
					request.setAttribute("message", "Login succeeded");
					rd=request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
				}
				else {
					// Login failed
					request.setAttribute("errorMsg", result);
					rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
		}
		
		if(uri.contains("/editAcc.do")) {
			System.out.println("in process-->controller '/editAcc.do' if block");
			/*
			 * 1.Get the Bean from request scope
			 * 2. invoke model Register(Bean)
			 * 3. check whether the request succeeds
			 * 4. if succeeds--> forward to success.jsp
			 * 5. else forward to Register.jsp
			 */
			/*LoginBean lbean=(LoginBean)request.getAttribute("reg");
			System.out.println("loginbean-->"+lbean);*/
			EditBean bean=(EditBean)request.getAttribute("reg");
			System.out.println("editbean-->"+bean);
			
			HttpSession session=request.getSession(false);
			if(session==null || session.getAttribute("user")==null)
			{
				request.setAttribute("errorMsg", "First login, then try to edit account!");
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			else {
				String result=model.editAcc(bean);
				if(result.equals("SUCCESS")) {
					// Registration succeeded
					// forward to success.jsp
					request.setAttribute("message", "Your editing process succeeded!"
							+ "Click <a href='HomePage.html'>Click to go back to HomePage</a>"
							+ "Click <a href='/MVCRegisterationApp/logout.do'>Click here to logout.</a>");
					rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				else {
					// Registration failed
					request.setAttribute("errorMsg", result);
					rd=request.getRequestDispatcher("EditAccount.jsp");
					rd.forward(request, response);
				
				}
				
			}
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
			request.setAttribute("message","You have logged out successfully! Click <a href='HomePage.html'>Click to go back to HomePage</a>");
			rd.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do post of Coltroller");
		process(request, response);

	}

}
