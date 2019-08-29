<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorites</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css"
	crossorigin="anonymous">
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
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>
	</nav>

	<h1 class="text-primary">
		<center>Soundtrack of My Life</center>
	</h1>

	<div class="container" align="center">
		<form action="/favorite/playlist/delete" method="post">
			<table class="table"
				style="display: inline-block; border: 1px solid; float: left;">
				<thead class="text-success">
					<tr>
						<th>Playlists</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${playlistFavs}" var="playlists">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/playlist/${playlists.playlistId}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${playlists.id}">Delete</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
	<div class="container" align="center">
		<form action="/favorite/track/delete" method="post">
			<table class="table"
				style="display: inline-block; border: 1px solid; float: left;">
				<thead class="text-success">
					<tr>
						<th>Tracks</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${trackFavs}" var="tracks">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/track/${tracks.trackId}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${tracks.id}">Delete</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
	<div class="container" align="center">
		<form action="/favorite/artist/delete" method="post">
			<table class="table"
				style="display: inline-block; border: 1px solid; float: left;">
				<thead class="text-success">
					<tr>
						<th>Artists</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${artistFavs}" var="artist">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/artist/${artist.artistId}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${artist.id}">Delete</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
	<div class="container" align="center">
		<form action="/favorite/album/delete" method="post">
			<table class="table"
				style="display: inline-block; border: 1px solid; float: left;">
				<thead class="text-success">
					<tr>
						<th>Albums</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${albumFavs}" var="album">
						<tr>
							<td><iframe
									src="https://open.spotify.com/embed/album/${album.albumId}"
									width="500" height="75" frameborder="0"
									allowtransparency="true" allow="encrypted-media"></iframe></td>
							<td><button type="submit" name="favorite"
									value="${album.id}">Delete</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>