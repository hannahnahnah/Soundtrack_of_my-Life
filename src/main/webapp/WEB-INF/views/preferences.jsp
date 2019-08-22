<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css" crossorigin="anonymous">
<meta charset="UTF-8">

<title>User Preferences</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<ul class="navbar-nav ml-auto" >
		<li class="nav-item"><a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a></li>
		<li class="nav-item"><a class="nav-link" href="/preferences">User Preferences</a></li>
	</ul>
</nav>
	
<div class="container">

	<div>
		<h1> Welcome ${user.firstName}</h1>
	</div>
	<div>
		<h3> Set your profile preferences</h3>
	</div>
	<div >
		<form id="locForm" action="/" method="post" onsubmit="getLocation(); return false;">
		<fieldset >
  			<div class="form-group"><label class="col-form-label">First name: </label>
  				<div><input type="text" class="form-control col-sm-4" name="firstName" value="${user.firstName }"></div>
  			</div>
  		
  			<div class="form-group"><label class="col-form-label">Last name: </label>
  				<div><input type="text" class="form-control col-sm-4" name="lastName" value="${user.lastName }"></div>
  			</div>
  			
  			<div class="form-group"><label class="col-form-label">User name:</label>
  				<div><input type="text" class="form-control col-sm-4" name="userName" value="${user.userName }"></div>
  			</div>

  			<div class="form-group"><label class="col-form-label">Password:</label>
  				<div><input type="password" class="form-control col-sm-4" name="password" value="${user.password }"></div>
  			</div>
  			
  		</fieldset>
  			
  			<fieldset class="form-group">
  			<legend><label class="form-check-label">Mood Preference</label></legend>
  			<div class="form-check">
	  			<input type="radio" class="form-check-input" name="mood" value="Happy"<c:if test="${mood.equals('Happy')}">checked</c:if>><label>Happy</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Sad"<c:if test="${mood.equals('Sad')}">checked</c:if>><label>Sad</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Joyful" <c:if test="${mood.equals('Joyful')}">checked</c:if>><label>Joyful</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Angry" <c:if test="${mood.equals('Angry')}">checked</c:if>><label>Angry</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Frustrated" <c:if test="${mood.equals('Frustrated')}">checked</c:if>><label>Frustrated</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Loving" <c:if test="${mood.equals('Loving')}">checked</c:if>><label>Loving</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Fearful" <c:if test="${mood.equals('Fearful')}">checked</c:if>><label>Fearful</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Peaceful" <c:if test="${mood.equals('Peaceful')}">checked</c:if>><label>Peaceful</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Good Vibes" <c:if test="${mood.equals('Good Vibes')}">checked</c:if>><label>Good Vibes</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Relaxed" <c:if test="${mood.equals('Relaxed')}">checked</c:if>><label>Relaxed</label><br>
	  			<input type="radio" class="form-check-input" name="mood" value="Beast Mode" <c:if test="${mood.equals('Beast Mode')}">checked</c:if>><label>Beast Mode</label><br>
	  			</div>
  			</fieldset>
  			
  			<input type="hidden" name="latitude" id="lat" value="1" />
			<input type="hidden" name="longitude" id="lon" value="1" />
  			<input type="submit" value="Submit" class="btn btn-success btn-lg btn-block col-sm-4"><br>
  			
		</form>
		<div>
		<a href="/" class="btn btn-primary btn-lg btn-block col-sm-4">Cancel</a><br>
		</div>
			
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











<%-- <fieldset>
<legend>I would not like to hear music from these genres:</legend>
<form action="/preferences"> 

	<input type="checkbox" name="genres" value="Rock" <c:if test="${imploded.contains('Rock')}">checked</c:if>><label for="Rock">Rock</label><br>
	<input type="checkbox" name="genres" value="Country" <c:if test="${imploded.contains('Country')}">checked</c:if>><label for="Country">Country</label><br>
	<input type="checkbox" name="genres" value="Folk" <c:if test="${imploded.contains('Folk')}">checked</c:if>><label for="Folk">Folk</label><br>
	<input type="checkbox" name="genres" value="Metal" <c:if test="${imploded.contains('Metal')}">checked</c:if>><label for="Metal">Metal</label><br>
	<input type="checkbox" name="genres" value="Trance" <c:if test="${imploded.contains('Trance')}">checked</c:if>><label for="Trance">Trance</label><br>
	<input type="checkbox" name="genres" value="Latin" <c:if test="${imploded.contains('Latin')}">checked</c:if>><label for="Latin">Latin</label><br>
	<input type="checkbox" name="genres" value="Opera" <c:if test="${imploded.contains('Opera')}">checked</c:if>><label for="Opera">Opera</label><br>
	<input type="checkbox" name="genres" value="Rap" <c:if test="${imploded.contains('Rap')}">checked</c:if>><label for="Rap">Rap</label><br>
	<input type="checkbox" name="genres" value="Classical" <c:if test="${imploded.contains('Classical')}">checked</c:if>><label for="Classical">Classical</label><br>
	<input type="checkbox" name="genres" value="Jazz" <c:if test="${imploded.contains('Jazz')}">checked</c:if>><label for="Jazz">Jazz</label><br>

<input type="submit" value="Submit" data-dismiss="alert">
//FIXME stretch goal. reset all <button type="reset" value="Reset" name="${ genres = null }">Reset</button>



</form>
</fieldset> --%>

	</div>

</body>

</html>