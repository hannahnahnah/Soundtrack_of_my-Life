package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumsResponse {
	@JsonProperty("items")
	private List<AlbumtItems> items;

	public List<AlbumtItems> getItems() {
		return items;
	}

	public void setItems(List<AlbumtItems> items) {
		this.items = items;
	}
	
	
}
