package classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUsername(String username, String password);
	

}