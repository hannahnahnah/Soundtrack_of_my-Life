package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackItems {
	
	@JsonProperty("external_urls")
	private TrackExternalUrls url;
	private String name;
	private Type type = Type.track;
	
	
	public TrackExternalUrls getUrl() {
		return url;
	}
	public void setUrl(TrackExternalUrls url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}
