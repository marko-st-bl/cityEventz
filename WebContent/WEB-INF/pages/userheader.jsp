<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="org.unibl.etf.osi.dto.Category"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="categoryBean" class="org.unibl.etf.osi.beans.CategoryBean" scope="session" />
<%
String categoryList="";
List<Category> categories = categoryBean.getAllCategories();
for (Category cat : categories){
	categoryList+="<a class=\"dropdown-item\" href=\"Controller?action=showbycategory&name=" + cat.getName() + "\">" + 
					cat.getName() +"</a>";
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Browse Events</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<div class="collapse navbar-collapse">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">cityEventz</a>
			</div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="Controller?action=showtodays">Today</a></li>
				<li class="nav-item"><a class="nav-link" href="Controller?action=showupcoming">Upcoming</a></li>
				<li class="nav-item"><a class="nav-link" href="Controller?action=showpast">Past</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
					data-toggle="dropdown" href="#">Category</a>
					<div class="dropdown-menu">
						<%= categoryList %>
					</div></li>
			</ul>
		</div>
	</nav>