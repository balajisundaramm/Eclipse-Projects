<jsp:useBean id="Update" class="con.uttara.test.ContactApp.RegBean" scope="request"/>
<jsp:setProperty name="Update"  property="*"/>

<jsp:forward page="OpenEditView.do"/>