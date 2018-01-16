<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="java.util.*,com.uttara.mvc.*"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>Display of Registered Users</h1>
	
	<h2>Using Scriplet</h2>
	<%
		List<RegBean> list = (List<RegBean>)request.getAttribute("listUsers");
		for(RegBean bean : list)
		{
			if(bean.getUname().contains("amu"))
				out.println("Name : "+bean.getUname()+" Email : "+bean.getEmail()+" Pass : "+bean.getPass()+" <br/>");
			
		}
	
	%>
	<h2>Using JSTL</h2>
	
	<jstl:forEach var="x" items="${listUsers}">	
			Name:${x.uname} Email:${x.email} Pass:${x.pass} <br/>
	</jstl:forEach>
	
</body>
</html>






