package sai.daria.helpdesk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sai.daria.helpdesk.entities.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String username);
}