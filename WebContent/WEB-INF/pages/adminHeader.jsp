<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width inital-scale=1">
<title>Data administration</title>
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
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fas fa-calendar-alt"></i>Events<span class="caret"></span></a>
					<div class="dropdown-menu">
						<a  class="dropdown-item"href="Controller?action=createevent">Create new
								event</a>
						<a class="dropdown-item" href="#">Show all events </a>
						<a class="dropdown-item" href="#">Show today's events</a>
						<a class="dropdown-item" href="#">Show upcoming events</a>
						<a class="dropdown-item" href="#">Show past events</a>
					</div></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fas fa-th-large"></i>Categories<span class="caret"></span></a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="Controller?action=createcategory">Create new
								category</a>
						<a class="dropdown-item" href="Contreoller?action=showcategories">Show all categories</a>
					</div></li>
			</ul>
			<ul class="navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="Controller?action=logout"><i class="fas fa-sign-out-alt"></i>
						Logout</a></li>
			</ul>
		</div>
	</nav>