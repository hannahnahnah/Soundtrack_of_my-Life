<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Preferences</title>
</head>
<body>
	
<div class="container">

	<div>
		<h1> Welcome ${user.firstName}</h1>
	</div>
	<div>
		<h3> Set your profile preferences</h3>
	</div>
	<div>
		<form action="/" method="post">
  			<p><label>First name:</label><input type="text" name="firstName" value="${user.firstName }" ></p>
  			<p><label>Last name: </label><input type="text" name="lastName" value="${user.lastName }"></p>
  			<p><label>User name: </label><input type="text" name="userName" value="${user.userName }"></p>
  			<p><label>Password: </label><input type="password" name="password" value="${user.password }"></p>
  			
  			<p><label>Mood Preferences</label><br>
  			<input type="radio" name="mood" value="Happy"><label>Happy</label><br>
  			<input type="radio" name="mood" value="Sad"><label>Sad</label><br>
  			<input type="radio" name="mood" value="Joyful"><label>Joyful</label><br>
  			<input type="radio" name="mood" value="Angry"><label>Angry</label><br>
  			<input type="radio" name="mood" value="Frustrated"><label>Frustrated</label><br>
  			<input type="radio" name="mood" value="Loving"><label>Loving</label><br>
  			<input type="radio" name="mood" value="Fearful"><label>Fearful</label><br>
  			<input type="radio" name="mood" value="Peaceful"><label>Peaceful</label><br>
  			<input type="radio" name="mood" value="Good Vibes"><label>Good Vibes</label><br>
  			<input type="radio" name="mood" value="Relaxed"><label>Relaxed</label><br>
  			<input type="radio" name="mood" value="Beast Mode"><label>Beast Mode</label><br>
  			</p>
  			<input type="submit" value="Submit">
		</form>
		<a href="/" class="button">Cancel</a>
	</div>












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