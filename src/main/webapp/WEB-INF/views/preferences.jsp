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
	<ul class="navbar-nav mr-auto" >
		<li class="nav-item">${hour} ${user.firstName}</li>
	</ul>
	<ul class="navbar-nav ml-auto" >
		<li class="nav-item"><a class="nav-link" href="/welcome">Home<span class="sr-only">(current)</span></a></li>
		<li class="nav-item"><a class="nav-link" href="/favorites">Favorites</a>
		<li class="nav-item"><a class="nav-link" href="/preferences">User Preferences</a></li>
		<li class="nav-item"><a class="nav-link" href="/">Logout</a></li>
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
		<form id="locForm" action="/" method="post">
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
	  			<legend><label class=" ">Choose your feeling</label></legend>
  				
  				 <h3 class="col-form-label">How make you feel when the weather is Thunderstorm?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingThunderstorm" value="excited"<c:if test="${feelingThunderstorm.equals('excited')}">checked</c:if>><label>excited</label><br>
	  					<input type="radio" class="form-check-input" name="feelingThunderstorm" value="scared"<c:if test="${feelingThunderstorm.equals('scared')}">checked</c:if>><label>scared</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is Drizzle?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingDrizzle" value="romantic"<c:if test="${feelingDrizzle.equals('romantic')}">checked</c:if>><label>romantic</label><br>
	  					<input type="radio" class="form-check-input" name="feelingDrizzle" value="sad"<c:if test="${feelingDrizzle.equals('sad')}">checked</c:if>><label>sad</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is Rain?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingRain" value="relax"<c:if test="${feelingRain.equals('relax')}">checked</c:if>><label>relax</label><br>
	  					<input type="radio" class="form-check-input" name="feelingRain" value="pissed"<c:if test="${feelingRain.equals('pissed')}">checked</c:if>><label>pissed</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is Snow?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSnow" value="peaceful"<c:if test="${feelingSnow.equals('peaceful')}">checked</c:if>><label>peaceful</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSnow" value="lonely"<c:if test="${feelingSnow.equals('lonely')}">checked</c:if>><label>lonely</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is Mist?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingMist" value="curious"<c:if test="${feelingMist.equals('curious')}">checked</c:if>><label>curious</label><br>
	  					<input type="radio" class="form-check-input" name="feelingMist" value="afraid"<c:if test="${feelingMist.equals('afraid')}">checked</c:if>><label>afraid</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is Smoke?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSmoke" value="surprising"<c:if test="${feelingSmoke.equals('surprising')}">checked</c:if>><label>surprising</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSmoke" value="anxiety"<c:if test="${feelingSmoke.equals('anxiety')}">checked</c:if>><label>anxiety</label><br>
  					</div>
  			
  			<h3 class="col-form-label">How make you feel when the weather is Haze?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingHaze" value="interested"<c:if test="${feelingHaze.equals('interested')}">checked</c:if>><label>interested</label><br>
	  					<input type="radio" class="form-check-input" name="feelingHaze" value="lazy"<c:if test="${feelingHaze.equals('lazy')}">checked</c:if>><label>lazy</label><br>
  					</div>
  			
  			<h3 class="col-form-label">How make you feel when the weather is Fog?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingFog" value="romantic"<c:if test="${feelingFog.equals('romantic')}">checked</c:if>><label>romantic</label><br>
	  					<input type="radio" class="form-check-input" name="feelingFog" value="confussed"<c:if test="${feelingFog.equals('confussed')}">checked</c:if>><label>confussed</label><br>
  					</div>
  					
  					
  			<h3 class="col-form-label">How make you feel when the weather is Sand?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSand" value="thoughtful"<c:if test="${feelingSand.equals('thoughtful')}">checked</c:if>><label>thoughtful</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSand" value="grubby"<c:if test="${feelingSand.equals('grubby')}">checked</c:if>><label>grubby</label><br>
  					</div>
  					
  			<h3 class="col-form-label">How make you feel when the weather is Dust?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingDust" value="pensive"<c:if test="${feelingDust.equals('pensive')}">checked</c:if>><label>pensive</label><br>
	  					<input type="radio" class="form-check-input" name="feelingDust" value="irritated"<c:if test="${feelingDust.equals('irritated')}">checked</c:if>><label>irritated</label><br>
  					</div>		
  					
  			<h3 class="col-form-label">How make you feel when the weather is Ash?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingAsh" value="reflective"<c:if test="${feelingAsh.equals('reflective')}">checked</c:if>><label>reflective</label><br>
	  					<input type="radio" class="form-check-input" name="feelingAsh" value="dirty"<c:if test="${feelingAsh.equals('dirty')}">checked</c:if>><label>dirty</label><br>
  					</div>	
  					
  			<h3 class="col-form-label">How make you feel when the weather is Squall?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSquall" value="alert"<c:if test="${feelingSquall.equals('alert')}">checked</c:if>><label>alert</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSquall" value="stress"<c:if test="${feelingSquall.equals('stress')}">checked</c:if>><label>stress</label><br>
  					</div>			
  			
  			<h3 class="col-form-label">How make you feel when the weather is Tornado?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingTornado" value="awake"<c:if test="${feelingTornado.equals('awake')}">checked</c:if>><label>awake</label><br>
	  					<input type="radio" class="form-check-input" name="feelingTornado" value="crazy"<c:if test="${feelingTornado.equals('crazy')}">checked</c:if>><label>crazy</label><br>
  					</div>				
  				
  			<h3 class="col-form-label">How make you feel when the weather is Clear?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingClear" value="hope"<c:if test="${feelingClear.equals('hope')}">checked</c:if>><label>hope</label><br>
	  					<input type="radio" class="form-check-input" name="feelingClear" value="annoying"<c:if test="${feelingClear.equals('annoying')}">checked</c:if>><label>annoying</label><br>
  					</div>		
  					
  					
  			<h3 class="col-form-label">How make you feel when the weather is Clouds?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingClouds" value="calm"<c:if test="${feelingClouds.equals('calm')}">checked</c:if>><label>calm</label><br>
	  					<input type="radio" class="form-check-input" name="feelingClouds" value="drowsy"<c:if test="${feelingClouds.equals('drowsy')}">checked</c:if>><label>drowsy</label><br>
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
  			
  				<input type="submit" value="Submit" class="btn btn-success btn-lg btn-block col-sm-4"><br>
  			
		</form>
		<div>
		<a href="/welcome" class="btn btn-primary btn-lg btn-block col-sm-4">Cancel</a><br>
		</div>
			
	</div>


	</div>

</body>

</html>