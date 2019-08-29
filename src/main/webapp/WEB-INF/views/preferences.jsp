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
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
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
  				
  				 <h3 class="col-form-label">How do you feel when the weather is thunderstorming?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingThunderstorm" value="excited"<c:if test="${feelingThunderstorm.equalsIgnoreCase('excited')}">checked</c:if>><label>Excited</label><br>
	  					<input type="radio" class="form-check-input" name="feelingThunderstorm" value="scared"<c:if test="${feelingThunderstorm.equalsIgnoreCase('scared')}">checked</c:if>><label>Scared</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How do you feel when the weather is drizzling?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingDrizzle" value="romantic"<c:if test="${feelingDrizzle.equalsIgnoreCase('romantic')}">checked</c:if>><label>Romantic</label><br>
	  					<input type="radio" class="form-check-input" name="feelingDrizzle" value="sad"<c:if test="${feelingDrizzle.equalsIgnoreCase('sad')}">checked</c:if>><label>Sad</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How do you feel when the weather is raining?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingRain" value="relax"<c:if test="${feelingRain.equalsIgnoreCase('relax')}">checked</c:if>><label>Relax</label><br>
	  					<input type="radio" class="form-check-input" name="feelingRain" value="pissed"<c:if test="${feelingRain.equalsIgnoreCase('pissed')}">checked</c:if>><label>Pissed</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How do you feel when the weather is snowing?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSnow" value="peaceful"<c:if test="${feelingSnow.equalsIgnoreCase('peaceful')}">checked</c:if>><label>Peaceful</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSnow" value="lonely"<c:if test="${feelingSnow.equalsIgnoreCase('lonely')}">checked</c:if>><label>Lonely</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How make you feel when the weather is misty?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingMist" value="curious"<c:if test="${feelingMist.equalsIgnoreCase('curious')}">checked</c:if>><label>Curious</label><br>
	  					<input type="radio" class="form-check-input" name="feelingMist" value="afraid"<c:if test="${feelingMist.equalsIgnoreCase('afraid')}">checked</c:if>><label>Afraid</label><br>
  					</div>
  					
  				<h3 class="col-form-label">How do you feel when the weather is smokey?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSmoke" value="surprising"<c:if test="${feelingSmoke.equalsIgnoreCase('surprising')}">checked</c:if>><label>Surprising</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSmoke" value="anxiety"<c:if test="${feelingSmoke.equalsIgnoreCase('anxiety')}">checked</c:if>><label>Anxiety</label><br>
  					</div>
  			
  			<h3 class="col-form-label">How do you feel when the weather is hazey?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingHaze" value="interested"<c:if test="${feelingHaze.equalsIgnoreCase('interested')}">checked</c:if>><label>Interested</label><br>
	  					<input type="radio" class="form-check-input" name="feelingHaze" value="lazy"<c:if test="${feelingHaze.equalsIgnoreCase('lazy')}">checked</c:if>><label>Lazy</label><br>
  					</div>
  			
  			<h3 class="col-form-label">How do you feel when the weather is foggy?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingFog" value="romantic"<c:if test="${feelingFog.equalsIgnoreCase('romantic')}">checked</c:if>><label>Romantic</label><br>
	  					<input type="radio" class="form-check-input" name="feelingFog" value="confussed"<c:if test="${feelingFog.equalsIgnoreCase('confussed')}">checked</c:if>><label>Confussed</label><br>
  					</div>
  					
  					
  			<h3 class="col-form-label">How do you feel when the weather is sandy?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSand" value="thoughtful"<c:if test="${feelingSand.equalsIgnoreCase('thoughtful')}">checked</c:if>><label>Thoughtful</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSand" value="grubby"<c:if test="${feelingSand.equalsIgnoreCase('grubby')}">checked</c:if>><label>Grubby</label><br>
  					</div>
  					
  			<h3 class="col-form-label">How do you feel when the weather is dusty?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingDust" value="pensive"<c:if test="${feelingDust.equalsIgnoreCase('pensive')}">checked</c:if>><label>Pensive</label><br>
	  					<input type="radio" class="form-check-input" name="feelingDust" value="irritated"<c:if test="${feelingDust.equalsIgnoreCase('irritated')}">checked</c:if>><label>Irritated</label><br>
  					</div>		
  					
  			<h3 class="col-form-label">How do you feel when the weather is ashy?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingAsh" value="reflective"<c:if test="${feelingAsh.equalsIgnoreCase('reflective')}">checked</c:if>><label>Reflective</label><br>
	  					<input type="radio" class="form-check-input" name="feelingAsh" value="dirty"<c:if test="${feelingAsh.equalsIgnoreCase('dirty')}">checked</c:if>><label>Dirty</label><br>
  					</div>	
  					
  			<h3 class="col-form-label">How do you feel when the weather is squall?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingSquall" value="alert"<c:if test="${feelingSquall.equalsIgnoreCase('alert')}">checked</c:if>><label>Alert</label><br>
	  					<input type="radio" class="form-check-input" name="feelingSquall" value="stress"<c:if test="${feelingSquall.equalsIgnoreCase('stress')}">checked</c:if>><label>Stress</label><br>
  					</div>			
  			
  			<h3 class="col-form-label">How do you feel when the weather is like a tornado?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingTornado" value="awake"<c:if test="${feelingTornado.equalsIgnoreCase('awake')}">checked</c:if>><label>Awake</label><br>
	  					<input type="radio" class="form-check-input" name="feelingTornado" value="crazy"<c:if test="${feelingTornado.equalsIgnoreCase('crazy')}">checked</c:if>><label>Crazy</label><br>
  					</div>				
  				
  			<h3 class="col-form-label">How do you feel when the weather is clear?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingClear" value="sunny"<c:if test="${feelingClear.equalsIgnoreCase('sunny')}">checked</c:if>><label>Sunny</label><br>
	  					<input type="radio" class="form-check-input" name="feelingClear" value="bright"<c:if test="${feelingClear.equalsIgnoreCase('bright')}">checked</c:if>><label>Bright</label><br>
  					</div>		
  					
  					
  			<h3 class="col-form-label">How do you feel when the weather is cloudy?</h3>
  					<div class="form-check">
	  					<input type="radio" class="form-check-input" name="feelingClouds" value="calm"<c:if test="${feelingClouds.equalsIgnoreCase('calm')}">checked</c:if>><label>Calm</label><br>
	  					<input type="radio" class="form-check-input" name="feelingClouds" value="drowsy"<c:if test="${feelingClouds.equalsIgnoreCase('drowsy')}">checked</c:if>><label>Drowsy</label><br>
  					</div>	
  					
  			</fieldset>
  			
  			<%-- <fieldset class="form-group">
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
  			</fieldset> --%>
  			
  				<input type="submit" value="Submit" class="btn btn-success btn-lg btn-block col-sm-4"><br>
  			
		</form>
		<div>
		<a href="/welcome" class="btn btn-primary btn-lg btn-block col-sm-4">Cancel</a><br>
		</div>
			
	</div>


	</div>

</body>

</html>