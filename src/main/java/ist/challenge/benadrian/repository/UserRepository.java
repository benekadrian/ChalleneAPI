package ist.challenge.benadrian.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ist.challenge.benadrian.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	 Optional<UserModel> findByUsername(String username);

	    @Query("SELECT u.password FROM UserModel u WHERE u.id = ?1")
	    String getPasswordById(Long id);

	    @Query("SELECT u.password FROM UserModel u WHERE u.username = ?1")
	    String getPasswordByUsername(String username);
}
