<jsp:useBean id="Reg" class="con.uttara.test.ContactApp.RegBean" scope="request"/>
<jsp:setProperty name="Reg"  property="*"/>

<jsp:forward page="/register.do"/>