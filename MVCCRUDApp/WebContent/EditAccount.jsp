<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Account</h1>
	<form action="" method="post">
		Enter name:<input type="text" name="uname" value='${userDetail.uname}'/><br/>
		Enter email:<input type="text" name="email" value='${userDetail.email}' readonly="readonly"/><br/>
		Enter pass:<input type="password" name="pass" value='${userDetail.pass}'/><br/>
		Repeat pass:<input type="password" name="rpass" value='${userDetail.pass}'/><br/>	
		<br/>
		<input type="submit"/>
	</form>
	
	<b>${errorMsg}</b>
	
</body>
</html>






