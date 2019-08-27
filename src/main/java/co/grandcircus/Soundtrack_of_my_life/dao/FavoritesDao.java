package co.grandcircus.Soundtrack_of_my_life.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.Soundtrack_of_my_life.entity.PlaylistFavorites;

@Repository
@Transactional
public class FavoritesDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<PlaylistFavorites> findAll(){
		return em.createQuery("FROM PlaylistFavorites", PlaylistFavorites.class).getResultList();
	}
	
	public void create(PlaylistFavorites fav) {
		em.persist(fav);
	}
	
	public void delete(Long id) {
		PlaylistFavorites fav = em.getReference(PlaylistFavorites.class, id);
		em.remove(fav);
	}
}
