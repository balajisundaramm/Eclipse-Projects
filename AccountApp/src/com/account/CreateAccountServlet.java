package com.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LinkedHashSet<Customer> set=new LinkedHashSet<Customer>();
		PrintWriter out=null;

    
    public CreateAccountServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		System.out.println("URI is  "+uri);
		//uri=uri.substring(12);
		if(uri.contains("CreateAccount")) 
			createAccount(request,response);
		if(uri.contains("ListOfAccounts"))
			ListOfAccounts(response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("inside createAccount()");
		Customer c1=new Customer(request.getParameter("name"),request.getParameter("number"),
				request.getParameter("accounttype"));
		set.add(c1);
		out=response.getWriter();
		String name=request.getParameter("name");
		String aNumber=request.getParameter("number");
		String aType=request.getParameter("accounttype");
		String msg="Your name is-->"+name+"</br>"+"Your account number is-->"+aNumber+"</br>"
				+"Your Account type-->"+aType+"</br>";
		out.println("<html><body><h1>Registered successfully!!!</h1><b>"+msg);
		out.print("Thanks for registering your deatils with us!!</br>"
				+ "<a href=\"CreateAccount.html\">Go back to create an account</a></br>"
				+ "<a href=\"ListOfAccounts\">Proceed to view list of accounts</a>\n"
				+ "</body></html>");
		out.println(set);
		
	}
	public void ListOfAccounts(HttpServletResponse response) throws IOException {
		System.out.println("inside ListOfAccounts()");
		out=response.getWriter();
		out.println("<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>CustomerDetails</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"<table>\n" + 
				"  <tr>\n" + 
				"    <th>Name</th>\n" + 
				"    <th>Account Number</th>\n" + 
				"    <th>Account type</th>\n" +  
				"  </tr>\n" + 
				"");
		for (Customer customer : set) {
			out.println( "<tr><td>"+customer.getName()+"</td>"+
					"<td>"+customer.getaNo()+"</td>"+
					"<td>"+customer.getaType()+"</td></tr>");
		}
		out.println("</table></body></html>");
		
	}
}
