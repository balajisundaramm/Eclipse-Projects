<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<h3>Login!!!</h3>
<form action="LoginInt.jsp" method="post">
Enter Email:<input type="text" name="email"><br/>
Enter Password:<input type="password" name="pswd"><br/>
<input type="submit" value="login">
</form>
<b>${errorMsg}</b>
</body>
</html>