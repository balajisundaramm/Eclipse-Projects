<jsp:useBean id="log" class="con.uttara.test.ContactApp.LoginBean" scope="request"/>
<jsp:setProperty name="log" property="*" />

<jsp:forward page="/Login.do"></jsp:forward>