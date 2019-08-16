package co.grandcircus.Soundtrack_of_my_life.model.spotify;

public class TokenResponse {
	
	private String access_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	@Override
	public String toString() {
		return "TokenResponse [access_token=" + access_token + "]";
	}
	
	
}
