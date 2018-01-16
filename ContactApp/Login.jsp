<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head><h1>Login</h1>
<body>
<form action="LogInt.jsp" method="post">
Enter Email:<input type="text" name="email"/><br>
Enter Password<input type="password" name="pass"/><br>
<input type="submit" value="Login"/>
</form>
</body>${Error}
</html>