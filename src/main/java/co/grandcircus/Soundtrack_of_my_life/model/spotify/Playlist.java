package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.Arrays;

import co.grandcircus.Soundtrack_of_my_life.entity.User;

public class Playlist {
	
	private boolean collaborative;
	private URL external_urls;
	private String href;
	private String id;
	private Image[] images;
	private String name;
	private User owner;
	private Track tracks;
	private Type type = Type.playlist;
	private String uri;
	
	public boolean isCollaborative() {
		return collaborative;
	}
	public void setCollaborative(boolean collaborative) {
		this.collaborative = collaborative;
	}
	public URL getExternal_urls() {
		return external_urls;
	}
	public void setExternal_urls(URL external_urls) {
		this.external_urls = external_urls;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Track getTracks() {
		return tracks;
	}
	public void setTracks(Track tracks) {
		this.tracks = tracks;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "Playlist [collaborative=" + collaborative + ", external_urls=" + external_urls + ", href=" + href
				+ ", id=" + id + ", images=" + Arrays.toString(images) + ", name=" + name + ", owner=" + owner
				+ ", tracks=" + tracks + ", type=" + type + ", uri=" + uri + "]";
	}
	
	
	
}
