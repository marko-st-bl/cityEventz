<jsp:useBean id="userBean" class="org.unibl.etf.osi.beans.UserBean" scope="session"/>
<%
	if(!userBean.isLoggedIn())
		response.sendRedirect("index.jsp");
%>
<jsp:include flush="true" page="adminheader.jsp"/>
<div class="jumbotron jumbotron-fluid bg-dark">
	<div class="jumbotron-background">
		<img src="img/background1.jpg" class="blur"/>
	</div>
		<div class="container text-white">
			<h1 class="display-3">cityEventz</h1>
			<h2 class="lead"><strong>Made for those who don't like staying home.</strong></h2>
		</div>
</div>
<div class="jumbotron-2">
<div class="jumbotron jumbotron-fluid">
	<div class="jumbotron-background">
	</div>
	<div class="container text-white">
		<h1>From music festivals to all kinds of promotions and meeting, transform your vision into an experience people will love</h1>
	</div>
</div>
</div>
<jsp:include flush="true" page="footer.jsp"/>