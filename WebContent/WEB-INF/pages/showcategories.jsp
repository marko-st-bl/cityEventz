<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Category"%>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean"
	scope="session" />
<jsp:useBean id="categoryBean"
	class="org.unibl.etf.osi.beans.CategoryBean" scope="session" />
<%
	if (!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<jsp:include flush="true" page="adminHeader.jsp" />
<br>
<div class="container">
	<h1>Categories</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Category> categories = categoryBean.getAllCategories();
				for (Category cat : categories) {
					out.println("<tr>");
					out.println("	<td>" + cat.getId() + "</td>");
					out.println("	<td>" + cat.getName() + "</td>");
					out.println("	<td><a href=\"#\"><i class=\"fas fa-trash-alt\"></i></a></td>");
					out.println("</tr>");
				}
			%>
		</tbody>
	</table>
</div>
</body>
</html>