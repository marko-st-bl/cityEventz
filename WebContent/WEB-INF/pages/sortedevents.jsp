<jsp:include flush="true" page="adminheader.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Event"%>
<jsp:useBean id="eventBean" class="org.unibl.etf.osi.beans.EventBean"></jsp:useBean>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean"
	scope="session" />
<%
	if (!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<%
	List<Event> events = (List<Event>) session.getAttribute("sortedList");
	if (events == null) {
		events = eventBean.getAllEvents();
	}
	String output = "";
	output += "<div class=\"container\">";
	output += "<div class=\"events\">";
	output += "<div class=\"card-deck\">";
	for (Event e : events) {
		String dateParams[] = e.getDate().split("-");
		output += "<div class=\"col-lg-12\">" + "<div class=\"card bg-light mb-3\">"
				+ "<div class=\"card-header\">" + dateParams[2] + "." + dateParams[1] + "." + dateParams[0]
				+ ", " + e.getTime() + "</div>" + "<div class=\"card-body\">" + "<h5 class=\"card-title\">"
				+ e.getName() + "</h5>" + "<p class=\"card-text\">" + e.getDescription() + "</p>" +
				"<p class=\"card-text\">" + e.getAddress() + "</p></div>" + 
				"<div class=\"card-footer\"><a href=\"Controller?action=deleteevent&id=" + e.getId() +"\" class=\"btn btn-danger float-right\">Delete</a><a href=\"Controller?action=modifyevent&id=" + e.getId() + "\" class=\"btn btn-secondary float-right\">Modify</a></div>"
				+ "</div>" + "</div>";
	}
	output += "</div>";
	output += "</div>";
	output += "</div>";
%>

<div class="container">
	<div class="sort">
		<form id="form" action="Controller?action=sort" method="POST">
			<div class="form-group">
				<label for="sortBy">Sort by:</label> <select name="sortBy">
					<option>Name</option>
					<option>Category</option>
					<option>Date</option>
					<option>Time</option>
				</select> <label for="order">Order:</label> <select name="order">
					<option>Ascending</option>
					<option>Descending</option>
				</select>
				<button id="sort-btn" type="submit" class="btn btn-secondary">Sort</button>
			</div>
		</form>
	</div>
</div>
<%=output%>


<jsp:include flush="true" page="footer.jsp" />