package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaylistItems {
	
	@JsonProperty("external_urls")
	private PlaylistExternalURL url;
	private String name;
	private Type type = Type.playlist;
	
	
	public PlaylistExternalURL getUrl() {
		return url;
	}
	public void setUrl(PlaylistExternalURL url) {
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
