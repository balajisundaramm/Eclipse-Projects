<jsp:useBean id="reg" class="com.uttara.mvc.RegBean" scope="request">
	<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="register.do"/>

<!--
	jsp:useBean => create object of RegBean
	jsp:setProperty => invokes setters on RegBean based on QS
	jsp:useBean => save inst and populated bean obj in request scope
	jsp:forward => use RD to forward to CS
-->