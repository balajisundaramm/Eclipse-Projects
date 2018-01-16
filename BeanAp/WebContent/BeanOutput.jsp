<%@page import="com.beans.RegBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeanOutput</title>
</head>
<body>
<h3>By using Bean Tag</h3>
<jsp:useBean id="reg" class="com.beans.RegBean" scope="request"/>
Name:<jsp:getProperty name="reg" property="name"/>
Email: <jsp:getProperty property="email" name="reg"/>
Password: <jsp:getProperty property="pwd" name="reg"/>
Repassword: <jsp:getProperty property="rPwd" name="reg"/>


<h3>By using Expression Tag</h3>
Name:<%= request.getParameter("name") %>
Email:<%= request.getParameter("email") %>
Pwd:<%= request.getParameter("pwd") %>
Rpwd:<%= request.getParameter("rPwd") %>

<h3>By using Scriptlet Tag</h3>
<%
RegBean r1= (RegBean) request.getAttribute("reg");
// com.beans.RegBean r1= (com.beans.RegBean) request.getAttribute("reg");
out.println("name from scriplet-->"+r1.getName());
out.println("<br/>Email from scriplet-->"+r1.getEmail());
out.println("<br/>Password from scriplet-->"+r1.getPwd());
out.println("<br/>RePassword from scriplet-->"+r1.getrPwd());
 

request.getParameter("name"); 
%>

</body>
</html>