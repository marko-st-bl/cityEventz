<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean" scope="session"/>
<%
	if(!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<jsp:include flush="true" page="adminHeader.jsp" />
	<br>
	<h1>Create Event</h1>
</body>
</html>