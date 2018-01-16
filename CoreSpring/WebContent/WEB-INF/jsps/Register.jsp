<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
<h2>Register</h2>
<s:form action="register" method="post" modelAttribute="reg">
Enter your name:<s:input path="uname"/><s:errors path="uname"/></br>
Enter your email:<s:input path="uemail"/><s:errors path="uemail"/></br>
Enter your password:<s:password path="upass"/><s:errors path="upass"/></br>
Retype your name:<s:password path="rpass"/><s:errors path="rpass"/></br>
Enter your date of birth(dd/MM/yyyy):<s:input path="udate"/><s:errors path="udate"/></br>
<input type="submit" value="Register"/>

</s:form>
</body>
</html>