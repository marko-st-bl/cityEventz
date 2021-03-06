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
<jsp:include flush="true" page="adminheader.jsp" />
<br>
<div class=" create-event container">
	<h1>Create event</h1>
	<form action="?action=addevent" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control"  name="name" id="event-name" placeholder="Enter name" required>
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<textarea class="form-control" name="description" id="event-description" rows="3"
				placeholder="Enter description" required></textarea>
		</div>
		<div class="form-group">
			<label for="address">Address</label>
			<textarea class="form-control" name="address" id="event-address" rows="2"
				placeholder="Enter address" required></textarea>
		</div>
		<div class="form-group">
			<label for="category">Select category</label> <select
				class="form-control" name="category" id="event-category">
				<%
					List<Category> categories = categoryBean.getAllCategories();
					for (Category cat : categories) {
						out.println("<option>" + cat.getName() + "</option>");
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label for="event-date">Date</label> <input type="date"
				class="form-control" name="date" id="event-date" required>
		</div>
		<div class="form-group">
			<label for="event-time">Time</label> <input type="time"
				class="form-control" name="time" id="event-time" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<jsp:include flush="true" page="footer.jsp"/>