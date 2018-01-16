<jsp:useBean id="con" class="con.uttara.test.ContactApp.AddContactBean" scope="request"/>

<jsp:setProperty name="con" property="*"/>

<jsp:forward page="AddContact.do"/>