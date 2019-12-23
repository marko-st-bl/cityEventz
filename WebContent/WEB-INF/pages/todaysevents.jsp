<jsp:include flush="true" page="userheader.jsp"/>
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Event"%>
<jsp:useBean id="eventBean" class="org.unibl.etf.osi.beans.EventBean"></jsp:useBean>
<%
List<Event> events= eventBean.getTodaysEvents();
String todays="";
todays+="<div class=\"container\">";
todays+="<div class=\"events card-deck\">";
for(Event e:events){
	todays+="<div class=\"card bg-light mb-3\">" +
				"<div class=\"card-header\">Today at " + e.getTime() + "</div>" +
				"<div class=\"card-body\">" +
					"<h5 class=\"card-title\">" + e.getName() + "</h5>" +
					"<p class=\"card-text\">" + e.getDescription() + "</p>" +
				"</div>" +
			"</div>";
}
todays+="</div>";
todays+="</div>";
%>

<%= todays %>


<jsp:include flush="true" page="footer.jsp"/>