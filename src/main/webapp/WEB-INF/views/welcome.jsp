<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1 class="text-primary">
		<center>Sound Track of My Life</center>
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
	<p>Mood: <input type="text" name="mood" value="${mood}"></p>
	<input type="hidden" name="latitude" id="lat" value="${lat}" />
	<input type="hidden" name="longitude" id="lon" value="${lon}" />
	<button type="submit">Search</button>
	</form>

	<div class="container" align="center">
		<table class="table"
			style="display: inline-block; border: 1px solid; float: left;">
			<thead class="text-success">
				<tr>
					<th>Playlists</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${playlist}" var="playlists">
					<tr>
						<td><iframe
								src="https://open.spotify.com/embed/playlist/${playlists.id}"
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

</body>
</html>