package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.Arrays;

public class Album {

	private String album_group; //Possible values are “album”, “single”, “compilation”, “appears_on”.
	private String album_type; //The type of the album: one of “album”, “single”, or “compilation”.
	private Artist[] artists;
	private String[] available_markets;
	private URL external_urls; 
	private String href;
	private String id; 
	private Image[] images;
	private String name;
	private String release_date; 
	private String release_date_precision; //The precision with which release_date value is known: year , month , or day
	private Type type = Type.album;
	private String uri;
	
	public String getAlbum_group() {
		return album_group;
	}
	public void setAlbum_group(String album_group) {
		this.album_group = album_group;
	}
	public String getAlbum_type() {
		return album_type;
	}
	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}
	public Artist[] getArtists() {
		return artists;
	}
	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}
	public String[] getAvailable_markets() {
		return available_markets;
	}
	public void setAvailable_markets(String[] available_markets) {
		this.available_markets = available_markets;
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
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getRelease_date_precision() {
		return release_date_precision;
	}
	public void setRelease_date_precision(String release_date_precision) {
		this.release_date_precision = release_date_precision;
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
		return "Album [album_group=" + album_group + ", album_type=" + album_type + ", artists="
				+ Arrays.toString(artists) + ", available_markets=" + Arrays.toString(available_markets)
				+ ", external_urls=" + external_urls + ", href=" + href + ", id=" + id + ", images="
				+ Arrays.toString(images) + ", name=" + name + ", release_date=" + release_date
				+ ", release_date_precision=" + release_date_precision + ", type=" + type + ", uri=" + uri + "]";
	}
	
	
	
}
