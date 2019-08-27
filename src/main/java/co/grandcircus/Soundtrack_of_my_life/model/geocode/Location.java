package co.grandcircus.Soundtrack_of_my_life.model.geocode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	
	@JsonProperty("lat")
	private Double latitude;
	@JsonProperty("lng")
	private Double longitude;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	

}
