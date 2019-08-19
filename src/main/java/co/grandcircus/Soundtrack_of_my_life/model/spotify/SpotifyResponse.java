package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpotifyResponse {
	
	@JsonProperty("playlists")
	private PlaylistsResponse playlist;
	@JsonProperty("tracks")
	private TracksResponse track;

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
		
}
