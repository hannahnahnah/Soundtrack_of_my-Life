package co.grandcircus.Soundtrack_of_my_life.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="album_favorites")
public class AlbumFavorites {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String albumId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setPlaylistId(String albumId) {
		this.albumId = albumId;
	}
}
