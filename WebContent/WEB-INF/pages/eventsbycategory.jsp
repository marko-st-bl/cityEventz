<jsp:include flush="true" page="userheader.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Event"%>
<jsp:useBean id="eventBean" class="org.unibl.etf.osi.beans.EventBean"></jsp:useBean>
<%
	List<Event> events = (List<Event>) session.getAttribute("eventsByCategory");
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
				+ e.getName() + "</h5>" + "<p class=\"card-text\">" + e.getDescription() + "</p>" + "</div>"
				+ "</div>" + "</div>";
	}
	output += "</div>";
	output += "</div>";
	output += "</div>";
%>

<%=output%>
<jsp:include flush="true" page="footer.jsp" />