<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>	
	<h1>Menu</h1>
	
	<h2>Welcome ${user}</h2>

	<a href="openEditAccountView.do">Click to edit account</a><br/>
	<a href="logout.do">Click to logout</a><br/>

	<h2>Tasks List</h2>
	
	<a href='openAddTaskView.do'>Click to Add Task</a><br/>
	<table>
	<td>Name</td><td>Desc</td><td>To Delete</td>
		<tr/>
	<jstl:forEach var="bean" items="${listTasks}">
		<td><a href='openUpdateTaskView.do?sl_no=${bean.sl_no}'>${bean.name}</a></td><td>${bean.desc}</td><td><a href='deleteTask.do?sl_no=${bean.sl_no}'>Click to Delete</a></td><tr/>
	</jstl:forEach>
	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	
</body>
</html>






