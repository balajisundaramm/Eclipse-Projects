package com.uttara.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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





