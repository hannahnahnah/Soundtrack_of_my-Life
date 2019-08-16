package co.grandcircus.Soundtrack_of_my_life.model.weather;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class weatherResponse {
	@JsonProperty("id")
	private Long cityID;
	@JsonProperty("name")
	private String cityName;
	private double visibility;
	@JsonProperty("dt")
	private Long dateTime;
	private coord coord;
	private List<weather> weather;
	private main main;
	private Wind wind;
	private clouds clouds;
	private sys sys;
	private Long dt;
	private snow snow;
	private rain rain;
	
	public snow getSnow() {
		return snow;
	}
	public void setSnow(snow snow) {
		this.snow = snow;
	}
	public rain getRain() {
		return rain;
	}
	public void setRain(rain rain) {
		this.rain = rain;
	}
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public Long getId() {
		return cityID;
	}
	public void setId(Long id) {
		this.cityID = id;
	}
	public String getcityName() {
		return cityName;
	}
	public void setCityName(String name) {
		this.cityName = name;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public coord getCoord() {
		return coord;
	}
	public void setCoord(coord coord) {
		this.coord = coord;
	}
	public List<weather> getWeather() {
		return weather;
	}
	public void setWeather(List<weather> weather) {
		this.weather = weather;
	}
	public main getMain() {
		return main;
	}
	public void setMain(main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public clouds getClouds() {
		return clouds;
	}
	public void setClouds(clouds clouds) {
		this.clouds = clouds;
	}
	public sys getSys() {
		return sys;
	}
	public void setSys(sys sys) {
		this.sys = sys;
	}
	
}
