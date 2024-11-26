package kz.bitlab.g128security.reposity;

import java.util.Optional;
import kz.bitlab.g128security.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @EntityGraph(attributePaths = "roles")
  @Query(value = "SELECT u FROM User u WHERE u.username = :username")
  Optional<User> findByUsernameWithRoles(String username);

  Optional<User> findByUsername(String username);
}
