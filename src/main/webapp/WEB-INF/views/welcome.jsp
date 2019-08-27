<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<ul class="navbar-nav mr-auto" >
		<li class="nav-item">${hour} ${user.firstName}</li>
	</ul>
	<ul class="navbar-nav ml-auto" >
		<li class="nav-item"><a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a></li>
		<li class="nav-item"><a class="nav-link" href="/preferences">User Preferences</a></li>
	</ul>
	
</nav>


	<h1 class="text-primary">
		<center>Soundtrack of My Life</center>
	</h1>
	
	<div class="container" align="center">
		<h1 class="text-primary"></h1>
		<table class="table">

			<thead class="text-success">
				<tr>
					<th>City Name</th>
					<th>Temperature</th>
					<th>Condition</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>${name}</td>
					<td>${temp}&#8457</td>
					<td>${mainCondition}</td>
					<td>${description}</td>
				</tr>

			</tbody>
		</table>
	</div>
	
	<form action="/welcome" method="post">
	<p>Look up music based on your mood</p>
	<p>Mood: <input type="text" name="mood" placeholder="Ex: ${defaultMood}"></p>
	<%-- <input type="hidden" name="latitude" id="lat" value="${lat}" />
	<input type="hidden" name="longitude" id="lon" value="${lon}" /> --%>
	<button type="submit">Search</button>
	</form>
	
	<form action="/welcome" method="get">
	<input type="hidden" name="weather" value="${mainCondition}" />
	<%-- <input type="hidden" name="latitude" id="lat" value="${lat}" />
	<input type="hidden" name="longitude" id="lon" value="${lon}" /> --%>
	<button type="submit">Search by Weather Condition</button>
	</form>
	

	<div >
	<p>Search Song by date (range)</p>
	<form action="/welcome" method="post">
	<input type="radio" name="whichDate" value="current"><label>Current</label><br>
	<input type="radio" name="whichDate" value="selected"><label>Select</label><br>
	<label>Select Start Date: </label><input type="date" name="selectStartDate" ><br>
	<label>Select End Date: </label><input type="date" name="selectEndDate" max=2019 ><label> (optional) </label><br>
	<button type="submit" >Go.</button><br>
	<input type="hidden" name="latitude" id="lat" value="${lat}" />
	<input type="hidden" name="longitude" id="lon" value="${lon}" />
	</form>
	</div>
	
	<div>
	<p>Search by alternate location: </p>
	<form action="/welcome" method="post">
	<label>country</label><input type="country" name=country >
	<label>state</label><input type="state" name=state >
	<label>city</label><input  type="city" name=city >
	<button type="submit" >Go.</button><br>
	</form>
	</div>
	
	<label class="switch">
  <input type="checkbox">
  <span class="slider round"></span>
</label>
	


	<div class="container" align="center">
		<table class="table"
			style="display: inline-block; border: 1px solid; float: left;">
			<thead class="text-success">
				<tr>
					<th>Playlists</th>
					<th>Favorite</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${playlist}" var="playlists">
					<tr>
						<td><iframe
								src="https://open.spotify.com/embed/playlist/${playlists.id}"
								width="500" height="75" frameborder="0" allowtransparency="true"
								allow="encrypted-media"></iframe></td>
						<td><button type="submit" name="favorite" value="${playlists.id}">Favorite</button>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1 class="text-primary"></h1>
		<table class="table" style="display: inline-block; border: 1px solid;">
			<thead class="text-success">
				<tr>
					<th>Tracks</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${track}" var="tracks">
					<tr>
						<td><iframe
								src="https://open.spotify.com/embed/track/${tracks.id}"
								width="500" height="75" frameborder="0" allowtransparency="true"
								allow="encrypted-media"></iframe></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container" align="center">
		<h1 class="text-primary"></h1>
		<table class="table"
			style="display: inline-block; border: 1px solid; float: left;">
			<thead class="text-success">
				<tr>
					<th>Artists</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artist}" var="artists">
					<tr>
						<td><iframe
								src="https://open.spotify.com/embed/artist/${artists.id}"
								width="500" height="75" frameborder="0" allowtransparency="true"
								allow="encrypted-media"></iframe></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h1 class="text-primary"></h1>
		<table class="table" style="display: inline-block; border: 1px solid;">
			<thead class="text-success">
				<tr>
					<th>Albums</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${album}" var="albums">
					<tr>
						<td><iframe
								src="https://open.spotify.com/embed/album/${albums.id}"
								width="500" height="75" frameborder="0" allowtransparency="true"
								allow="encrypted-media"></iframe></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>
<script>
function check() {
  document.getElementById("myCheck").checked = true;
  
}

function uncheck() {
  document.getElementById("myCheck").checked = false;
}
</script>
</body>
</html>