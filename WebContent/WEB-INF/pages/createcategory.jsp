<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean"
	scope="session" />
<%
	if (!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<jsp:include flush="true" page="adminHeader.jsp" />
<br>
<div class="container">
	<h1>Create category</h1>
	<form action="?action=addcategory" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control"  name="name" id="category-name" placeholder="Enter name">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>