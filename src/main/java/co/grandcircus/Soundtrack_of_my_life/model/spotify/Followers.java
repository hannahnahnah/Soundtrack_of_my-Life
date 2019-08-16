package co.grandcircus.Soundtrack_of_my_life.model.spotify;

public class Followers {
	
	private String href;
	private Integer total;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Followers [href=" + href + ", total=" + total + "]";
	}
	
	

}
