package sai.daria.helpdesk.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sai.daria.helpdesk.DTO.UserServiceModel;
import sai.daria.helpdesk.entities.Users;
import sai.daria.helpdesk.repo.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserDetailService(UserRepository userRepository, RoleService roleService,
                           BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    public Users findUserByUserName(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }


    public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
        Users user = this.userRepository.findByUsername(userServiceModel.getUsername())
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));

        if(!this.bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        user.setPassword(!"".equals(userServiceModel.getPassword())  ?
                this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()) :user.getPassword());
        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    public List<Users> findAllUsers() {
        return this.userRepository.findAll();
    }


    public Users findUserById(String id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public void deleteUser(String userId) {
        this.userRepository.delete(findUserById(userId));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
