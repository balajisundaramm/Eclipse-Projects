<jsp:useBean id="searchData" class="con.uttara.test.ContactApp.TempBean" scope="request"/>
<jsp:setProperty name="searchData" property="*"/>

<jsp:forward page="Search.do"></jsp:forward>