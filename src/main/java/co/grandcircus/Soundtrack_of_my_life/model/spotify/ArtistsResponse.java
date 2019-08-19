package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistsResponse {
	@JsonProperty("items")
	private List<ArtistItems> items;

	public List<ArtistItems> getItems() {
		return items;
	}

	public void setItems(List<ArtistItems> items) {
		this.items = items;
	}
	
	
}
