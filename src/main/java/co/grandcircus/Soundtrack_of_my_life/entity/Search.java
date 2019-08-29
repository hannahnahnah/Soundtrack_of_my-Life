package co.grandcircus.Soundtrack_of_my_life.entity;

public class Search {
	
	private boolean useCurrentLocation = true;
	private boolean searchReleaseDate = false;
	private boolean byMood = false;
	private String selectStartDate;
	private String selectEndDate;
	private String country;
	private String state;
	private String city;
	private String mood;
	
	public boolean isUseCurrentLocation() {
		return useCurrentLocation;
	}
	public void setUseCurrentLocation(boolean useCurrentLocation) {
		this.useCurrentLocation = useCurrentLocation;
	}
	public boolean isSearchReleaseDate() {
		return searchReleaseDate;
	}
	public void setSearchReleaseDate(boolean searchReleaseDate) {
		this.searchReleaseDate = searchReleaseDate;
	}
	public boolean isByMood() {
		return byMood;
	}
	public void setByMood(boolean byMood) {
		this.byMood = byMood;
	}
	public String getSelectStartDate() {
		return selectStartDate;
	}
	public void setSelectStartDate(String selectStartDate) {
		this.selectStartDate = selectStartDate;
	}
	public String getSelectEndDate() {
		return selectEndDate;
	}
	public void setSelectEndDate(String selectEndDate) {
		this.selectEndDate = selectEndDate;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	
	public void normalize() {
		if (city == null || city.isEmpty()) {
			useCurrentLocation = true;
		}else {
			useCurrentLocation = false;
		}
		
		if (useCurrentLocation) {
			city = "";
			state = "";
			country = "";
		}
		
		if (selectStartDate == null || selectStartDate.isEmpty()) {
			searchReleaseDate = false;
		}
		
		if (mood == null || mood.isEmpty()) {
			byMood = false;
		}
		
	}
	
}
