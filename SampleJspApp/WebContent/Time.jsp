<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Current Time</title>
</head>
<body>
<h3>Hello world jsp!!!</h3>
<h2>Expression examples</h2>
<h3>Single line java code</h3>
Current time on the server is <%= new java.util.Date() %> <br/>
Changing the String into UpperCase <%=new String("Hello").toUpperCase()%><br/>
Changing the String into UpperCase <%="Hello pool object".toUpperCase()%><br/>
Mathematical operations 25*4--><%= 25*4 %><br/>
25<88? <%= 25<88 %><br/>

<h2>Scriplet Example</h2><br/>
<h3>it is used to code multi-line java code.. (local variables)<br/></h3>
<%
	for(int i=1;i<=5;i++){
		out.println("I love coding "+i+" times<br/>");
		out.println(makeLowercase("BALAJI_SWEET"+i+"<br/>"));
		
	}
%>
<h2>Declaration Example</h2><br/>
<h3>it is used to declare instance variable and methods..<br/></h3>
<%!  String makeLowercase(String s){ // can create static and istance  methods why???
	return s.toLowerCase();
	}
%> 
 the lower case of the given string is--><%=makeLowercase("HELLO WORLD") %>



</body>
</html>