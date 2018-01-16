package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In second servlet");
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession(false);
		if(s==null) {
			out.println("<b>Your session does not exist...</b>");
		}
		else {
		String name=(String)s.getAttribute("user");
		int num=(Integer)s.getAttribute("num");
		out.write("<b>Data from session is "+name+" num-->"+num+"</b>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
