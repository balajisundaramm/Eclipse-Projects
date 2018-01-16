<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><h1>Edit Contact Details</h1>
<body>
<form action="EditContactInt.jsp" method="post">
Enter Name:<input type="text" name="uname" value ="${bean.uname}" readonly="readonly"/><br>
Enter Email1:<input type="text" name="email1" value ="${bean.email1}"/><br>
Enter Email2:<input type="text" name="email2" value="${bean.email2}"/><br>
Enter Email3:<input type="text" name="email3" value="${bean.email3}"/><br>
<input type="submit" value="Update"/>
</form>

</body>
</html>