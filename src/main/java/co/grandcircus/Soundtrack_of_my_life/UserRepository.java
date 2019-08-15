package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Soundtrack_of_my_life.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
