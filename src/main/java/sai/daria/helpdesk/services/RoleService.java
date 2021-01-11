package sai.daria.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sai.daria.helpdesk.entities.Role;
import sai.daria.helpdesk.repo.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void seedRolesInDb() {
        if(this.roleRepository.count()==0){
            this.roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
            this.roleRepository.saveAndFlush(new Role("ROLE_USER"));
        }
    }

    public List<Role> findAllRoles() {
        return this.roleRepository.findAll();
    }

    public Role findByAuthority(String authority) {
        return this.roleRepository.findByAuthority(authority);
    }

    public Role findById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
