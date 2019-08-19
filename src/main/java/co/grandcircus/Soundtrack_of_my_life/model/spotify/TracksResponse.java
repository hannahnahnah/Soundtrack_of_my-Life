package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TracksResponse {
	@JsonProperty("items")
	private List<TrackItems> items;

	public List<TrackItems> getItems() {
		return items;
	}

	public void setItems(List<TrackItems> items) {
		this.items = items;
	}
	
}
