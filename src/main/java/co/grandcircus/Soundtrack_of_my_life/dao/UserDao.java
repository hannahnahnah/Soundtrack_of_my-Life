package co.grandcircus.Soundtrack_of_my_life.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.Soundtrack_of_my_life.entity.User;

@Repository
@Transactional
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void update(Long id, String imploded) {
		User user = em.find(User.class, id);
		user.setGenrePreferences(imploded);
		em.merge(user);
	}
	
	public void updateUser(User user) {
				
		em.merge(user);
	}
	
	
	public String getGenrePreferences(Long id) {
		String genrePreferences = em.find(User.class, id).getGenrePreferences();
		return genrePreferences;
		
	}

	public User findById(Long id) {
		User user = em.find(User.class, id);
		return user;
		
	}

}
