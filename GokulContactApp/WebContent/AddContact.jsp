<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contacts</title>
</head>
<body>
	<h1>Lets Add a Contact</h1>
	
	<form method="post" action="AddConInt.jsp">
		Enter name:<input type="text" name="name"/><Br/><Br/>
		Enter email:<input type="text" name="email"/><Br/><Br/>
		Enter Phone number:<input type="text" name="ph_no"/><Br/><Br/>
		Enter Tags:<Br/>Tag1<input type="text" name="tag1"/>Tag2:<input type="text" name="tag2"/>Tag3:<input type="text" name="tag3"/><Br/><Br/>
		Enter DOB(yyyy-mm-dd):<input type="text" name="dob"/><Br/><Br/>
		Male<input type="radio" name="gender" value="male"><span></span>Female<input type="radio"/>
		
		<br><br><input type="submit"/>
	</form>
	
	${msgs}
</body>
</html>