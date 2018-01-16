<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<body>
	<h1>Edit Account info</h1>
	
	<form method="post" action="EditInt.jsp">
		Enter name:<input type="text" value= "${uname}" name="uname"/><Br/>
		Enter email:<input type="text" value= "${email}" readonly="readonly" name="email"/><Br/>
		Enter pass:<input type="password" value="${pass}" name="pass"/><Br/>
		Repeat pass:<input type="password" value="${pass}" name="rpass"/><Br/>
		<br/>
		<input type="submit"/>
	</form>
	
	${msg}
</body>
</html>






