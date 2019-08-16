package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpotifyResponse {
	
	private Albums albums;
	private Artists artists;
	private Tracks tracks;
	private Playlists playlists;
	public Albums getAlbums() {
		return albums;
	}
	public void setAlbums(Albums albums) {
		this.albums = albums;
	}
	public Artists getArtists() {
		return artists;
	}
	public void setArtists(Artists artists) {
		this.artists = artists;
	}
	public Tracks getTracks() {
		return tracks;
	}
	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}
	public Playlists getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}
	@Override
	public String toString() {
		return "SpotifyResponse [albums=" + albums + ", artists=" + artists + ", tracks=" + tracks + ", playlists="
				+ playlists + "]";
	}
	

	
	
	
//	@JsonProperty("albums")
//	private List<Albums> albumList;
//	@JsonProperty("artists")
//	private List<Artists> artistList;
//	@JsonProperty("tracks")
//	private List<Tracks> trackList;
//	@JsonProperty("playlists")
//	private List<Playlists> playlistList;
//	
//	public List<Albums> getAlbumList() {
//		return albumList;
//	}
//	public void setAlbumList(List<Albums> albumList) {
//		this.albumList = albumList;
//	}
//	public List<Artists> getArtistList() {
//		return artistList;
//	}
//	public void setArtistList(List<Artists> artistList) {
//		this.artistList = artistList;
//	}
//	public List<Tracks> getTrackList() {
//		return trackList;
//	}
//	public void setTrackList(List<Tracks> trackList) {
//		this.trackList = trackList;
//	}
//	public List<Playlists> getPlaylistList() {
//		return playlistList;
//	}
//	public void setPlaylistList(List<Playlists> playlistList) {
//		this.playlistList = playlistList;
//	}
//	@Override
//	public String toString() {
//		return "SpotifyResponse [albumList=" + albumList + ", artistList=" + artistList + ", trackList=" + trackList
//				+ ", playlistList=" + playlistList + "]";
//	}
	
	

}
