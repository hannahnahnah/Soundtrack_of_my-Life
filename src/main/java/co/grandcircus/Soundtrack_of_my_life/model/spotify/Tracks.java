package co.grandcircus.Soundtrack_of_my_life.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tracks {
	
	private String href;
	@JsonProperty("items")
	private List<Track> trackItems; //look into this bc we dont know how to populate the search criteria into this
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
	public List<Track> getTrackItems() {
		return trackItems;
	}
	public void setTrackItems(List<Track> trackItems) {
		this.trackItems = trackItems;
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
		return "Tracks [href=" + href + ", trackItems=" + trackItems + ", limit=" + limit + ", next=" + next + ", offset="
				+ offset + ", previous=" + previous + ", total=" + total + "]";
	}
	
	
	
}
