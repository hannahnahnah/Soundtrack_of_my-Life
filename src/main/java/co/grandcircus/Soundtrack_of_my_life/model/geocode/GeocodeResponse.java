package co.grandcircus.Soundtrack_of_my_life.model.geocode;

import java.util.Arrays;

public class GeocodeResponse {
	
	private Result[] results;
	private String status;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
