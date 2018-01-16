<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><h1>Add Contact</h1>
<body>
<form action="AddInt.jsp" method="post">
Enter Name<input type="text" name="uname"/><br>
Enter Email<input type="text" name="emails"/>
Email:<input type="text" name="emails"/>
Email:<input type="text" name="emails"/><br>
Enter Phone:<input type="text" name="phone"/>
Phone:<input type="text" name="phone"/>
Phone:<input type="text" name="phone"/><br>
Enter Tag's<input type="text" name="tag"/><br>
Enter Dob<input type="text" name="dob"/><br>
Gender Male:<input type="radio" name="gender" value="male">
	Female<input type="radio" name="gender" value="female"><br/>
<input type="submit" value="Add Contact"/>
</form><br>

<a href="LoginSuccess.jsp">Go Back to Menu</a>

</body>
</html>