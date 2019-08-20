package co.grandcircus.Soundtrack_of_my_life.entity;

import java.util.List;

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
	private String[] genrePreferences;
	@Column (name="mood_preferences")
	private String moodPreferences;
	
	
	
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
	public String[] getGenrePreferences() {
		return genrePreferences;
	}
	public void setGenrePreferences(String[] genrePreferences) {
		this.genrePreferences = genrePreferences;
	}
	public String getMoodPreferences() {
		return moodPreferences;
	}
	public void setMoodPreferences(String moodPreferences) {
		this.moodPreferences = moodPreferences;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", genrePreferences=" + genrePreferences + ", moodPreferences="
				+ moodPreferences + "]";
	}
	
		
	

}
