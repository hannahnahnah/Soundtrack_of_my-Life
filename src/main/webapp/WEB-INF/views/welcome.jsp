<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item">${hour} ${user.firstName}</li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item"><a class="nav-link" href="/welcome">Home<span
				class="sr-only">(current)</span></a></li>
		<li class="nav-item"><a class="nav-link" href="/favorites">Favorites</a>
		<li class="nav-item"><a class="nav-link" href="/preferences">User
				Preferences</a></li>
		<li class="nav-item"><a class="nav-link" href="/">Logout</a></li>
	</ul>

	</nav>

	<div class="container">
	
	<h1 class="text-primary">
		<center>Soundtrack of My Life</center>
	</h1>

	<div align="center">
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

<script>
	function toggleSelectLocation() {
		let checkbox = document.getElementById("useCurrentLocation");
		let locationFormRow = document.getElementById("locationFormRow");
		let useCurrentLocation = checkbox.checked;
		
		if (useCurrentLocation) {
			locationFormRow.classList.add("use-current-location");
		} else {
			locationFormRow.classList.remove("use-current-location");
		}
	}

	function toggleSelectDate() {
		let checkbox = document.getElementById("releaseDate");
		let dateFormRow = document.getElementById("dateFormRow");
		let releaseDate = checkbox.checked;
		
		if (releaseDate) {
			dateFormRow.classList.add("use-release-date");
		} else {
			dateFormRow.classList.remove("use-release-date");
		}
	}
	
	function toggleSelectMood() {
		let checkbox = document.getElementById("mood");
		let formMood = document.getElementById("formMood");
		let mood = checkbox.checked;
		
		if (mood) {
			formMood.classList.add("use-release-mood");
		} else {
			formMood.classList.remove("use-release-mood");
		}
	}
</script>		

  <div >
	<h3>Location</h3>
	<div id="locationFormRow" class="form-inline">
		<div class="form-check mb-2 mr-sm-2">
		    <input class="form-check-input" type="checkbox" id="useCurrentLocation" onchange="toggleSelectLocation()">
		    <label class="form-check-label" for="useCurrentLocation">
		      Use Current
		    </label>
	  	</div>
	
		<label class="sr-only" for="country">Country</label>
	    <input type="text" class="form-control mb-2 mr-sm-2" id="country" placeholder="Country">
		
	   <label class="sr-only" for="state">State</label>
       <input type="text" class="form-control mb-2 mr-sm-2" id="state" placeholder="State">
		
	   <label class="sr-only" for="city">City</label>
	   <input type="text" class="form-control mb-2 mr-sm-2" id="city" placeholder="City">
	</div>
	
	<h3>Date</h3>
	<div id="dateFormRow" class="form-row">
			<div class="form-group col-auto">
			  <div class="form-check">
			    <input class="form-check-input" type="checkbox" id="releaseDate" onchange="toggleSelectDate()">
			    <label class="form-check-label" for="releaseDate">
			      Search By Release Date
			    </label>
		  	  </div>
		  	</div>
		    <div class="form-group col-auto date-selector">
		      <label for="inputEmail4">Start Date</label>
		      <input type="date" class="form-control" id="inputEmail4">
		    </div>
		    <div class="form-group col-auto date-selector">
		      <label for="inputPassword4">End Date (Optional)</label>
		      <input type="date" class="form-control" id="inputPassword4">
		    </div>
		  </div>	
	
	<h3>Mood</h3>
	<div id="formMood" class="form-inline">
		<div class="form-check mb-2 mr-sm-2">
		    <input class="form-check-input" type="checkbox" id="mood" onchange="toggleSelectMood()">
		    <label class="form-check-label" for="mood">
		      Optional Enter Your Mood
		    </label>
	  	</div>
		<label class="sr-only" for="mood">Mood</label>
	    <input type="text" class="form-control mb-2 mr-sm-2" id="mood" placeholder="Mood">	
	</div>
	
	
	<form action="/welcome" method="post">
	<p>Look up music based on your mood</p>
		<p>
			Mood: <input type="text" name="mood"
				placeholder="Ex:<c:if test="${empty mood}">${defaultMood}</c:if>
	<c:if test="${not empty mood}">${mood}</c:if>" />
		</p>
	
	<p>Search Song by date (range)</p>
	<input type="radio" name="whichDate" value="current"><label>Current</label><br>
	<input type="radio" name="whichDate" value="selected"><label>Select</label><br>
	<label>Select Start Date: </label><input type="date" name="selectStartDate" ><br>
	<label>Select End Date: </label><input type="date" name="selectEndDate" max=2019 ><label> (optional) </label><br>
	
	<p>Search by alternate location: </p>
	<label>country</label><input type="country" name=country >
	<label>state</label><input type="state" name=state >
	<label>city</label><input  type="city" name=city >
	
	
	
	<button type="submit" >Go.</button><br>
	</form>
	
	
	<form action="/currentlocation" method="get">
		<input type="hidden" name="weather" value="${mainCondition}" />
		<button type="submit"  >Search by Current Location</button>
	</form>
</div>
	
	
	<label class="switch">
  <input type="checkbox">
  <span class="slider round"></span>
</label>
	

	<div class="container" align="center">
		<form action="/favorite/playlist" method="post">
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
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${playlists.id}">Favorite</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
 		<form action="/favorite/track" method="post">
			<h1 class="text-primary"></h1>
			<table class="table"
				style="display: inline-block; border: 1px solid;">
				<thead class="text-success">
					<tr>
						<th>Tracks</th>
						<th>Favorite</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${track}" var="tracks">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/track/${tracks.id}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${tracks.id}">Favorite</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<div class="container" align="center">
		<form action="/favorite/artist" method="post">
			<h1 class="text-primary"></h1>
			<table class="table"
				style="display: inline-block; border: 1px solid; float: left;">
				<thead class="text-success">
					<tr>
						<th>Artists</th>
						<th>Favorite</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${artist}" var="artists">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/artist/${artists.id}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${artists.id}">Favorite</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<form action="/favorite/album" method="post">
			<h1 class="text-primary"></h1>
			<table class="table"
				style="display: inline-block; border: 1px solid;">
				<thead class="text-success">
					<tr>
						<th>Albums</th>
						<th>Favorite</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${album}" var="albums">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/album/${albums.id}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${albums.id}">Favorite</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	

</body>
</html>