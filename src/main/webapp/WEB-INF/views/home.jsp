<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Soundtracks</title>
</head>
<body>
	<h1 class="text-primary">
		<center>Sound Track of My Life</center>
	</h1>
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