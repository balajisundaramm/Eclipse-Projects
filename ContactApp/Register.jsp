<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head><h1>Register!!</h1>
<body>
<form action="RegInt.jsp" method="post">
Enter name:<input type="text" name="uname"/></br>
Enter Email:<input type="text" name="email"/></br>
Enter Password:<input type="password" name="pass"/></br>
Repeat Password:<input type="password" name="rpass"/></br>
<input type="submit"/>
</form>
</body>${Error}
</html> 