package co.grandcircus.Soundtrack_of_my_life.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name="first_name")
	private String firstName;
	@Column (name="last_name")
	private String lastName;
	@Column (name="user_name")
	private String userName;
	private String password;
	@Column (name="genre_preferences")
	private String genrePreferences;
	@Column (name="mood_preferences")
	private String moodPreferences;
	
	private String thunderstorm;
	private String drizzle;
	private String rain;
	private String snow;
	private String mist;
	private String smoke;
	private String haze;
	private String fog;
	private String sand;
	private String dust;
	private String ash;
	private String squall;
	private String tornado;
	private String clear;
	private String clouds;
	
	
	
	
	public User() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGenrePreferences() {
		return genrePreferences;
	}
	public void setGenrePreferences(String genrePreferences) {
		this.genrePreferences = genrePreferences;
	}
	public String getMoodPreferences() {
		return moodPreferences;
	}
	public void setMoodPreferences(String moodPreferences) {
		this.moodPreferences = moodPreferences;
	}
	
	
	
	
	public String getThunderstorm() {
		return thunderstorm;
	}


	public void setThunderstorm(String thunderstorm) {
		this.thunderstorm = thunderstorm;
	}


	public String getDrizzle() {
		return drizzle;
	}


	public void setDrizzle(String drizzle) {
		this.drizzle = drizzle;
	}


	public String getRain() {
		return rain;
	}


	public void setRain(String rain) {
		this.rain = rain;
	}


	public String getSnow() {
		return snow;
	}


	public void setSnow(String snow) {
		this.snow = snow;
	}


	public String getMist() {
		return mist;
	}


	public void setMist(String mist) {
		this.mist = mist;
	}


	public String getSmoke() {
		return smoke;
	}


	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}


	public String getHaze() {
		return haze;
	}


	public void setHaze(String haze) {
		this.haze = haze;
	}


	public String getFog() {
		return fog;
	}


	public void setFog(String fog) {
		this.fog = fog;
	}


	public String getSand() {
		return sand;
	}


	public void setSand(String sand) {
		this.sand = sand;
	}


	public String getDust() {
		return dust;
	}


	public void setDust(String dust) {
		this.dust = dust;
	}


	public String getAsh() {
		return ash;
	}


	public void setAsh(String ash) {
		this.ash = ash;
	}


	public String getSquall() {
		return squall;
	}


	public void setSquall(String squall) {
		this.squall = squall;
	}


	public String getTornado() {
		return tornado;
	}


	public void setTornado(String tornado) {
		this.tornado = tornado;
	}


	public String getClear() {
		return clear;
	}


	public void setClear(String clear) {
		this.clear = clear;
	}


	public String getClouds() {
		return clouds;
	}


	public void setClouds(String clouds) {
		this.clouds = clouds;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", genrePreferences=" + genrePreferences + ", moodPreferences="
				+ moodPreferences + ", thunderstorm=" + thunderstorm + ", drizzle=" + drizzle + ", rain=" + rain
				+ ", snow=" + snow + ", mist=" + mist + ", smoke=" + smoke + ", haze=" + haze + ", fog=" + fog
				+ ", sand=" + sand + ", dust=" + dust + ", ash=" + ash + ", squall=" + squall + ", tornado=" + tornado
				+ ", clear=" + clear + ", clouds=" + clouds + "]";
	}


	
		
		
	

}
