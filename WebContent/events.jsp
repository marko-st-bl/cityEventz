<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width initial-scale=1"/>
    <title>cityEventz</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
      .carousel{
        width: 100%;
        height: auto;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
      <ul class="navbar-nav nav">
          <a class="navbar-brand" href="#">cityEventz</a>
        <li class="dropdown">
          <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="#">Concert</a></li>
              <li><a href="#">Exhibition</a></li>
              <li><a href="#">Promotion</a></li>
            </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Today</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Upcoming</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Past</a>
        </li>
      </ul>
    </nav>
    <div id="slider" class="carousel slide container" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
          <li data-target="#slider" data-slide-to="0" class="active"></li>
          <li data-target="#slider" data-slide-to="1"></li>
          <li data-target="#slider" data-slide-to="2"></li>
        </ul>
      
        <!-- The slideshow -->
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100" src="img/art.jpg" alt="Izlozba" >
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/concert.jpg" alt="Koncert"  >
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/promotion.jpg" alt="Promocija"  >
          </div>
        </div>
      
        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#slider" data-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#slider" data-slide="next">
          <span class="carousel-control-next-icon"></span>
        </a>
      
      </div>
  </body>
</html>