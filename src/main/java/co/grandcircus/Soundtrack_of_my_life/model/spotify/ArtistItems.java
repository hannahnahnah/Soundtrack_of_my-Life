package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistItems {

	@JsonProperty("external_urls")
	private ArtistExternalUrls url;
	private String name;
	private Type type = Type.artist;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArtistExternalUrls getUrl() {
		return url;
	}
	public void setUrl(ArtistExternalUrls url) {
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
