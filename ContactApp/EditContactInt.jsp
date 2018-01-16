<jsp:useBean id="UpdateCon" class="con.uttara.test.ContactApp.TempBean" scope="request"/>
<jsp:setProperty name="UpdateCon" property="*"/>

<jsp:forward page="OpenEditContactUpdate.do"/>