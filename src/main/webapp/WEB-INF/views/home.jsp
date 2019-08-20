<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Soundtrack of My Life!</title>
</head>
<body>
	<p>Username: <input type="text" name="username"> </p>
	<p>Password: <input type="password" name="password"></p>
	<p><button type="submit">Login</button>
	
	<form id="locForm" action="/welcome" method="get" onsubmit="getLocation(); return false;">
		<button type="submit">Set Values</button>
		<input type="hidden" name="latitude" id="lat" value="1" />
		<input type="hidden" name="longitude" id="lon" value="1" />
	</form>

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