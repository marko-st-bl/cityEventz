<jsp:include flush="true" page="adminheader.jsp" />
<jsp:useBean id="cityBean" class="org.unibl.etf.osi.beans.CityBean"></jsp:useBean>
<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean"
	scope="session" />
<%@ page import="org.unibl.etf.osi.dto.City"%>
<%
	if (!userBean.isLoggedIn())
		response.sendRedirect("Controller?action=login");
%>
<%
	City city = cityBean.getCityInfo();
%>
<div class="city-config container">
	<h1>Update city parameters</h1>
	<form action="Controller?action=updatecity" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control" name="name" id="city-name"
				value="<%=city.getName()%>">
		</div>
		<div class="form-group">
			<label for="country">Country</label> <input type="text"
				class="form-control" name="country" id="city-country"
				value="<%=city.getCountry()%>">
		</div>
		<div class="form-group">
			<label for="region">Region</label> <input type="text"
				class="form-control" name="region" id="city-region"
				value="<%=city.getRegion()%>">
		</div>
		<div class="form-group">
			<label for="population">Population</label> <input type="number"
				class="form-control" name="population" id="city-population"
				value="<%=city.getPopulation()%>">
		</div>
		<div class="form-group">
			<label for="area">Area</label> <input type="number"
				class="form-control" name="area" id="city-area"
				value="<%=city.getArea()%>">
		</div>
		<button type="submit" class="btn btn-primary">Update</button>
	</form>
</div>
<jsp:include flush="true" page="footer.jsp" />