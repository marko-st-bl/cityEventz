<jsp:include flush="true" page="adminheader.jsp"/>
<%@ page import="java.util.List"%>
<%@ page import="org.unibl.etf.osi.dto.Event"%>
<jsp:useBean id="eventBean" class="org.unibl.etf.osi.beans.EventBean"></jsp:useBean>
<%
List<Event> events= eventBean.getAllEvents();
String output="";
output+="<div class=\"container\">";
output+="<div class=\"events\">";
output+="<div class=\"card-deck\">";
for(Event e:events){
	output+="<div class=\"col-lg-10\">" +
				"<div class=\"card text-white bg-dark mb-3\">" +
					"<div class=\"card-header\">" +e.getDate() + "<br>" + e.getTime() + "</div>" +
					"<div class=\"card-body\">" +
						"<h5 class=\"card-title\">" + e.getName() + "</h5>" +
						"<p class=\"card-text\">" + e.getDescription() + "</p>" +
					"</div>" +
				"</div>" +
			"</div>";
}
output+="</div>";
output+="</div>";
output+="</div>";
%>

<%= output %>


<jsp:include flush="true" page="footer.jsp"/>