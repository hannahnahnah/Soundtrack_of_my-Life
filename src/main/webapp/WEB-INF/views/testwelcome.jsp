<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Click the button to get your coordinates.</p>

	<button onclick="getLocation()">Try It</button>

	<p id="demo"></p>

	<form id="locForm" action="/welcome" method="get" onsubmit="getLocation(); return false;">
		<button type="submit">Set Values</button>
		<input type="hidden" name="latitude" id="lat" value="1" />
		<input type="hidden" name="longitude" id="lon" value="1" />
	</form>

	<script>
		var x = document.getElementById("demo");
		var y = document.getElementById("lat");
		var z = document.getElementById("lon");
		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(setValues);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {
			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
		}
		function setValues(position) {
				y.value = position.coords.latitude;
				z.value = position.coords.longitude;
				document.getElementById("locForm").submit();
		}
	</script>


</body>
</html>