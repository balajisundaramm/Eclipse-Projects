<%@page import="con.uttara.test.ContactApp.TempBean"%>
<%@page import="con.uttara.test.ContactApp.AddContactBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" import="java.util.*" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<center><h1><font color="red">Edit or Delete Contacts</font></h1></center>
<center>
<table border="1"  cellpadding="10" >
 <tr>
   <td>Name</td>
   <td>Email 1 </td>
   <td>Email 2 </td>
   <td>Email 3 </td>
   <td>Birth Of Date</td>
   <td>Tags</td>
   <td>Cr_date</td>
   <td>EDIT</td>
   <td>DELETE</td>
 </tr>
 <j:forEach items="${UserData}" var="bean"> 
 <tr>  
 <td>${bean.uname }</td>
 <td>${bean.email1 }</td>
<td>${bean.email2}</td>
<td>${bean.email3}</td>
<td>${bean.dob}</td>
<td>${bean.tags}</td>
<td>${bean.cr_date}</td>
<td><a href="OpenEditConView.do?Name=${bean.uname }"><input type="button" value="Edit"></input></a></td>
<td><a href="OpenDeleteContactView.do?Name=${bean.uname}"><input type="button" value="Delete"></input></a></td>
</tr>
</j:forEach>
</table>
<br></br>
<br></br>
<b><a href="LoginSuccess.jsp">Go Back to Menu</a></b>

</center>

</body>
</html>


