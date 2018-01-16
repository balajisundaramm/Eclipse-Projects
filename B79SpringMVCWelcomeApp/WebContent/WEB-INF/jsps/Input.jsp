<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Input</h1>
	<sf:form action="welcome" method="get" modelAttribute="input">
		Enter name:<sf:input path="uname"/><sf:errors path="uname"/><br/>
		Enter age:<sf:input path="age"/><sf:errors path="age"/><br/>
		<br/>
		<input type="submit"/>
	</sf:form>
</body>
</html>



