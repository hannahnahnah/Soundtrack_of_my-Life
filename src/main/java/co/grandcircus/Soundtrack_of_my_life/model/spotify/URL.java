package co.grandcircus.Soundtrack_of_my_life.model.spotify;

public class URL {
	
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "URL [key=" + key + ", value=" + value + "]";
	}
	
	

}
