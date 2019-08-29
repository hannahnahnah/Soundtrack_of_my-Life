<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css" crossorigin="anonymous">

<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<div align="center">
	<h1>Welcome to Soundtrack of My Life!</h1>
	<form id="locForm" action="/session/set" method="get" onsubmit="getLocation(); return false;">
		<!-- <p>Username: <input type="text" name="username"> </p>
		<p>Password: <input type="password" name="password"></p>-->
		
		<input type="hidden" name="latitude" id="lat" value="1" />
		<input type="hidden" name="longitude" id="lon" value="1" />
		<button type="submit">Login</button>
	</form>
	
	<!-- <form action="/register" method="get">
	<p> Not registered? <button type="Submit">Create an Account</button>
	</form> -->
	</div>

	<script>
		var y = document.getElementById("lat");
		var z = document.getElementById("lon");
		function getLocation() {
			if (navigator.geolocation) {
				
				navigator.geolocation.getCurrentPosition(setValues);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}
		function setValues(position) {
			y.value = position.coords.latitude;
			z.value = position.coords.longitude;
			document.getElementById("locForm").submit();
		}
	</script>

</body>
</html>