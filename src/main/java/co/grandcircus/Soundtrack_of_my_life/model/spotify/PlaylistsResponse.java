package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaylistsResponse {
	@JsonProperty("items")
	private List<PlaylistItems> items;

	public List<PlaylistItems> getItems() {
		return items;
	}

	public void setItems(List<PlaylistItems> items) {
		this.items = items;
	}
	
}
