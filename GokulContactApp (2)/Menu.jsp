<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user}'s Home</title>
</head>
<body>
	
	
	<h4>Welcome ${user}</h4>
	
	<h1>Menu</h1>
	<a href="openEditAccountview.do">Change Password</a>
	<a href="logout.do">LogOut</a>
	
	<br/>
	${msg}<br/><br/><br/><br/><br/><br/>
	
	<h5><a href="openAddContactView.do">01. Add Contact</a><br/></h5>
	<h5><a href="openListContactView.do">02. List Contacts</a><br/></h5>
	<h5><a href="searchContact.do">03. Search Contacts</a><br/></h5>
	<h5><a href="editContact.do">04. Edit Contacts</a><br/></h5>
	<h5><a href="birthdayRemainder.do">05. Birthday Remainders</a><br/></h5>
	
</body>
</html>





