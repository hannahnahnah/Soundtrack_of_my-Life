package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpotifyResponse {
	
	@JsonProperty("playlists")
	private PlaylistsResponse playlist;
	@JsonProperty("tracks")
	private TracksResponse track;
	@JsonProperty("artists")
	private ArtistsResponse artist;
	@JsonProperty("albums")
	private AlbumsResponse album;
	

	public PlaylistsResponse getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlaylistsResponse playlist) {
		this.playlist = playlist;
	}

	public TracksResponse getTrack() {
		return track;
	}

	public void setTrack(TracksResponse track) {
		this.track = track;
	}

	public ArtistsResponse getArtist() {
		return artist;
	}

	public void setArtist(ArtistsResponse artist) {
		this.artist = artist;
	}

	public AlbumsResponse getAlbum() {
		return album;
	}

	public void setAlbum(AlbumsResponse album) {
		this.album = album;
	}

	
		
}
