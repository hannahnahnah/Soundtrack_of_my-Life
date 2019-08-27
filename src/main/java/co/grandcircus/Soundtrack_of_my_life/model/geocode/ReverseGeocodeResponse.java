package co.grandcircus.Soundtrack_of_my_life.model.geocode;

import java.util.Arrays;

public class ReverseGeocodeResponse {
	
	private ReverseResult[] results;


	public ReverseResult[] getResults() {
		return results;
	}

	public void setResults(ReverseResult[] results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ReverseGeocodeResponse [results=" + Arrays.toString(results) + "]";
	}

}
