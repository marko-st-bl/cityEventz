<jsp:include flush="true" page="adminheader.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Event"%>
<jsp:useBean id="eventBean" class="org.unibl.etf.osi.beans.EventBean"></jsp:useBean>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean"
	scope="session" />
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Category"%>
<%@ page import="org.unibl.etf.osi.beans.EventBean"%>
<jsp:useBean id="categoryBean"
	class="org.unibl.etf.osi.beans.CategoryBean" scope="session" />
<%
	if (!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<%
eventBean = (EventBean) session.getAttribute("eventBean");
Event event = eventBean.getEvent();
%>

<div class="modify-event container">
	<h1>Update event</h1>
	<form action="Controller?action=updateevent" method="post">
		<input type="hidden" name="id" value="<%=event.getId() %>"/>
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control"  name="name" id="event-name" value="<%= event.getName() %>">
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<textarea class="form-control" name="description" id="event-description" rows="3">
			<%= event.getDescription() %></textarea>
		</div>
		<div class="form-group">
			<label for="address">Address</label>
			<textarea class="form-control" name="address" id="event-address" rows="2">
			<%=event.getAddress()%></textarea>
		</div>
		<div class="form-group">
			<label for="category">Select category</label> <select
				class="form-control" name="category" id="event-category">
				<%
					List<Category> categories = categoryBean.getAllCategories();
					for (Category cat : categories) {
						if(cat.getName().equals(event.getCategory().getName())){
							out.println("<option selected>" + cat.getName() + "</option>");
						}else{
							out.println("<option>" + cat.getName() + "</option>");
						}
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label for="event-date">Date</label> <input type="text"
				class="form-control" name="date" id="event-date" onfocus="this.type='date'" 
				onblur="this.type='text'" value="<%= event.getDate() %>">
		</div>
		<div class="form-group">
			<label for="event-time">Time</label> <input type="text" onfocus="this.type='time'"
				onblur="this.type='text'" value="<%= event.getTime() %>" class="form-control" name="time" id="event-time">
		</div>
		<button type="submit" class="btn btn-primary">Update</button>
	</form>
</div>
<jsp:include flush="true" page="footer.jsp" />