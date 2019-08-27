package co.grandcircus.Soundtrack_of_my_life.model.geocode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReverseResult {
	
	@JsonProperty("formatted_address")
	private String formattedAddress;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	@Override
	public String toString() {
		return "ReverseResult [formattedAddress=" + formattedAddress + "]";
	}
	
	

}
