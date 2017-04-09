<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Yelp Data</title>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
	<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<link href="resources/css/style.css" rel='stylesheet' type='text/css'>	
	<link href="resources/css/search.css" rel='stylesheet' type='text/css'>	
			
	<script src="resources/js/jquery-3.1.0.js" type="text/javascript"></script>
	<script src="resources/js/main.js" type="text/javascript"></script>
	
	<!-- Optional theme -->
	<!-- link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
	<link href="resources/css/menu.css" rel='stylesheet' type='text/css'>  
	<link href="resources/css/main.css" rel='stylesheet' type='text/css'-->
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	
	<script id="result-template" type="text/x-handlebars-template">
      <div class="ProfileCard u-cf">
        <img class="ProfileCard-avatar" src="{{profile_image_url_https}}">

        <div class="ProfileCard-details">
          <div class="ProfileCard-realName">{{name}}</div>
          <div class="ProfileCard-screenName">@{{screen_name}}</div>
          <div class="ProfileCard-description">{{description}}</div>
        </div>

        <div class="ProfileCard-stats">
          <div class="ProfileCard-stat"><span class="ProfileCard-stat-label">Tweets:</span> {{statuses_count}}</div>
          <div class="ProfileCard-stat"><span class="ProfileCard-stat-label">Following:</span> {{friends_count}}</div>
          <div class="ProfileCard-stat"><span class="ProfileCard-stat-label">Followers:</span> {{followers_count}}</div>
        </div>
      </div>
    </script>
    <script id="empty-template" type="text/x-handlebars-template">
      <div class="EmptyMessage">Your search turned up 0 results. This most likely means the backend is down, yikes!</div>
    </script>
</head>
<body>
	<div class="app">
	<nav class="nav">
 			<a href="./" class="logo">
				<div class="desktop">
					<span>Yelp Data</span>
				</div>
				<div class="mobile">
					<span>I</span>T
				</div>
			</a>
			<div class="menu">
		<a href="RecommendServlet">Home</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="index.jsp">Login Page</a>
		</div>
		</nav>
		
		