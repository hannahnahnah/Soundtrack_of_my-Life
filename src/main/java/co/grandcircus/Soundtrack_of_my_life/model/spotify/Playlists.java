package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Playlists {
	
	private String href;
	@JsonProperty("items")
	private List<Playlist> playlistItems; 
	private Integer limit;
	private String next;
	private Integer offset;
	private String previous;
	private Integer total;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Playlist> getPlaylistItems() {
		return playlistItems;
	}
	public void setPlaylistItems(List<Playlist> playlistItems) {
		this.playlistItems = playlistItems;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Playlists [href=" + href + ", playlistItems=" + playlistItems + ", limit=" + limit + ", next=" + next
				+ ", offset=" + offset + ", previous=" + previous + ", total=" + total + "]";
	}

	
	
}
