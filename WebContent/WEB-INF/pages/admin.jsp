<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean" scope="session"/>
<%
	if(!userBean.isLoggedIn())
		response.sendRedirect("index.jsp");
%>
<jsp:include flush="true" page="adminheader.jsp"/>
<br>
<h1>ADMIN HOME</h1>
</body>
</html>