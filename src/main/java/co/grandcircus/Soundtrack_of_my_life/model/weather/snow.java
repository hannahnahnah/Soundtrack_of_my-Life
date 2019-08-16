package co.grandcircus.Soundtrack_of_my_life.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class snow {
	
	@JsonProperty("1h")
	private double oneHour;
	@JsonProperty("3h")
	private double threeHours;
	
	
	public double getOneHour() {
		return oneHour;
	}
	public void setOneHour(double oneHour) {
		this.oneHour = oneHour;
	}
	public double getThreeHours() {
		return threeHours;
	}
	public void setThreeHours(double threeHours) {
		this.threeHours = threeHours;
	}
	
}
