package co.grandcircus.Soundtrack_of_my_life.model.geocode;

import java.util.Arrays;

public class GeocodeResponse {
	
	private Result[] results;


	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "GeocodeResponse [results=" + Arrays.toString(results) + "]";
	}


}
