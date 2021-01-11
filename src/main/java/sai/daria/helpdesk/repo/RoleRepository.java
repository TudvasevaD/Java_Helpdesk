package sai.daria.helpdesk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sai.daria.helpdesk.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByAuthority(String authority);
}
