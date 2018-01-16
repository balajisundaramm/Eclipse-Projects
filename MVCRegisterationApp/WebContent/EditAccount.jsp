<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EditAccInt.jsp" method="post">
Enter your name:<input type="text" name=name><br/>
Enter the same Email*:<input type="text" value="${sessionScope.user}" name=email  readonly><br/>
Enter your Password:<input type="password" name=pswd><br/>
Retype your Password:<input type="password" name=rePswd><br/>
<input type="submit" value="Confirm"><br/>
</form>
</body>
</html>