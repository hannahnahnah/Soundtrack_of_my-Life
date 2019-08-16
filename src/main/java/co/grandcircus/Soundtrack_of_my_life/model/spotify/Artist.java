package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.awt.Image;
import java.util.Arrays;

public class Artist {
	
	private URL external_urls;
	private Followers followers; 
	private String[] genres;
	private String href;
	private String id;
	private Image[] images; 
	private String name;
	private Integer popularity;
	private Type type = Type.artist; 
	private String uri;
	
	public URL getExternal_urls() {
		return external_urls;
	}
	public void setExternal_urls(URL external_urls) {
		this.external_urls = external_urls;
	}
	public Followers getFollowers() {
		return followers;
	}
	public void setFollowers(Followers followers) {
		this.followers = followers;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
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
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
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
		return "ArtistResponse [external_urls=" + external_urls + ", followers=" + followers + ", genres="
				+ Arrays.toString(genres) + ", href=" + href + ", id=" + id + ", images=" + Arrays.toString(images)
				+ ", name=" + name + ", popularity=" + popularity + ", type=" + type + ", uri=" + uri + "]";
	}
	
	
	
	
	
}
