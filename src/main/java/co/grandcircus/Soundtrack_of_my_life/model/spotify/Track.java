package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.Arrays;

public class Track {
	
	private Album album; 
	private Artist artists;
	private String[] available_markets;
	private Integer duration_ms;
	private boolean explicit;
	private URL external_urls;
	private String href;
	private String id;
	private String name;
	private Integer popularity;
	private String preview_url;
	private Integer track_number;
	private Type type = Type.track;
	private String uri;
	private boolean is_local;
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Artist getArtists() {
		return artists;
	}
	public void setArtists(Artist artists) {
		this.artists = artists;
	}
	public String[] getAvailable_markets() {
		return available_markets;
	}
	public void setAvailable_markets(String[] available_markets) {
		this.available_markets = available_markets;
	}
	public Integer getDuration_ms() {
		return duration_ms;
	}
	public void setDuration_ms(Integer duration_ms) {
		this.duration_ms = duration_ms;
	}
	public boolean isExplicit() {
		return explicit;
	}
	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
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
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	public Integer getTrack_number() {
		return track_number;
	}
	public void setTrack_number(Integer track_number) {
		this.track_number = track_number;
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
	public boolean isIs_local() {
		return is_local;
	}
	public void setIs_local(boolean is_local) {
		this.is_local = is_local;
	}
	@Override
	public String toString() {
		return "TrackResponse [album=" + album + ", artists=" + artists + ", available_markets="
				+ Arrays.toString(available_markets) + ", duration_ms=" + duration_ms + ", explicit=" + explicit
				+ ", external_urls=" + external_urls + ", href=" + href + ", id=" + id + ", name=" + name
				+ ", popularity=" + popularity + ", preview_url=" + preview_url + ", track_number=" + track_number
				+ ", type=" + type + ", uri=" + uri + ", is_local=" + is_local + "]";
	}
	
	
	
}
