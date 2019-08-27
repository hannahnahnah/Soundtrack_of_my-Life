package co.grandcircus.Soundtrack_of_my_life.entity;

import java.io.Serializable;

public class Coordinates implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String longitude;
	private String latitude;
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}
