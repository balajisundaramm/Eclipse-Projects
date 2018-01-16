<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<center>
<h1><font color=blue>Your Contact Details</font></h1>
</center></head>
<body>
<center>
<table border="1"  cellpadding="10" >
 <tr>
   <td>Name</td>
   <td>Date Of Birth</td>
   <td>cr_date </td>
</tr>
 <j:forEach items="${bean}" var="be"> 
 <tr>  
 <td>${be.uname}</td>
 <td>${be.dob}</td>
<td>${be.cr_date}</td>
</tr>
</j:forEach>
</table>
<br></br>
<br></br>
</body>
<b><a href="LoginSuccess.jsp">Go Back to Menu</a></b>
</html>



