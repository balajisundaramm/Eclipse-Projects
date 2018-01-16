
<jsp:useBean id="ctact" class="com.uttara.contactApp.ContactBean" scope="request">
	<jsp:setProperty name="ctact" property="*"/>
</jsp:useBean>
<jsp:forward page="addcontact.do"/>

<!-- 
	RegBean reg = new RegBean();
	reg.setUname(request.getParameter("uname"))
	reg.setEmail(request.getParameter("email"))
	reg.setPass(request.getParameter("pass"))
	reg.setRpass(request.getParameter("rpass"))
	request.setAttribute("reg",reg);
	RequestDispatcher rd = request.getRequestDispatcher("/register.do");
	rd.forward(request,response);
 -->


<!-- 
	instantiate bean obj
	populate bean obj with user inputs from q.s in req
	save bean in scope
	forward to controller
	
	Q.S: uname=Ramu&email=Ramu@gmail.com&pass=123&rpass=123
	
	
 -->

