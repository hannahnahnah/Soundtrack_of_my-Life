package co.grandcircus.Soundtrack_of_my_life.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.Soundtrack_of_my_life.entity.AlbumFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.ArtistFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.PlaylistFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.TrackFavorites;

@Repository
@Transactional
public class FavoritesDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<PlaylistFavorites> findAllPlaylists(){
		return em.createQuery("FROM PlaylistFavorites", PlaylistFavorites.class).getResultList();
	}
	
	public void createPlaylist(PlaylistFavorites fav) {
		em.persist(fav);
	}
	
	public void deletePlaylist(Long id) {
		PlaylistFavorites fav = em.getReference(PlaylistFavorites.class, id);
		em.remove(fav);
	}
	
	public List<ArtistFavorites> findAllArtists(){
		return em.createQuery("FROM ArtistFavorites", ArtistFavorites.class).getResultList();
	}
	
	public void createArtist(ArtistFavorites fav) {
		em.persist(fav);
	}
	
	public void deleteArtist(Long id) {
		ArtistFavorites fav = em.getReference(ArtistFavorites.class, id);
		em.remove(fav);
	}
	
	public List<AlbumFavorites> findAllAlbums(){
		return em.createQuery("FROM AlbumFavorites", AlbumFavorites.class).getResultList();
	}
	public void createAlbum(AlbumFavorites fav) {
		em.persist(fav);
	}
	
	public void deleteAlbum(Long id) {
		AlbumFavorites fav = em.getReference(AlbumFavorites.class, id);
		em.remove(fav);
	}
	
	public List<TrackFavorites> findAllTracks(){
		return em.createQuery("FROM TrackFavorites", TrackFavorites.class).getResultList();
	}
	public void createTrack(TrackFavorites fav) {
		em.persist(fav);
	}
	
	public void deleteTrack(Long id) {
		TrackFavorites fav = em.getReference(TrackFavorites.class, id);
		em.remove(fav);
	}
	
}
