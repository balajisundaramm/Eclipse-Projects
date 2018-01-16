<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><h1>Hurray!!!</h1>
<body>
Welcome${param.uname}<br>
${Success	}<br>
<a href="OpenAddContactView.do">1: Add Contact</a><br>
<a href="OpenListContactView.do">2: List Contact</a><br>
<a href="OpenSearchContactView.do">3: Search </a><br>
<a href="OpenBirthdayReminderView.do">5: Birthday</a><br>


<h4><a href="ViewEditAC.do">Edit account Details</a><br></h4>
<b></b><a href="Logout.do">Logout</a>
</body>
</html>