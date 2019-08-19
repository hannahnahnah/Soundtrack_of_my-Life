package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumtItems {
	
	@JsonProperty("external_urls")
	private AlbumExternalUrls url;
	private String name;
	private Type type = Type.album;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AlbumExternalUrls getUrl() {
		return url;
	}
	public void setUrl(AlbumExternalUrls url) {
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
