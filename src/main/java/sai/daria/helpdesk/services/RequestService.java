package sai.daria.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sai.daria.helpdesk.DTO.RequestDTO;
import sai.daria.helpdesk.entities.Request;
import sai.daria.helpdesk.mapper.RequestMapper;
import sai.daria.helpdesk.repo.RequestRepository;

import java.util.ArrayList;
import java.util.List;

public class RequestService implements RequestServiceI{

    private final RequestRepository requestRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private RequestMapper requestMapper;

    @Autowired
    public RequestService (RequestRepository requestRepository, RoleService roleService,
                               BCryptPasswordEncoder bCryptPasswordEncoder, RequestMapper requestMapper) {
        this.requestRepository = requestRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.requestMapper = requestMapper;
    }

    public Request registerRequest(RequestDTO requestDTO) {
        this.roleService.seedRolesInDb();
        requestDTO.setAuthorities(new ArrayList<>());
        requestDTO.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
        requestDTO.setPassword(this.bCryptPasswordEncoder.encode(requestDTO.getPassword()));

        Request employee=this.requestMapper.mapRequestsDTOToRequests(requestDTO);

        return this.requestRepository.saveAndFlush(employee);

    }

    @Override
    public Request findRequestByUserName(String username) {
        return this.requestRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    @Override
    public List<Request> findAllRequests() {
        return this.requestRepository.findAll();
    }

    @Override
    public Request findRequestById(String id) {
        return this.requestRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new IllegalArgumentException());
    }
    @Override
    public void deleteRequest(String employeeId) {
        this.requestRepository.delete(findRequestById(employeeId));
    }

    @Override
    public Request createRequest(Request employee) {
        return this.requestRepository.saveAndFlush(employee);
    }

    @Override
    public Request updateRequest(RequestDTO requestDTO) {
        Request employee=this.requestMapper.mapRequestsDTOToRequests(requestDTO);
        return this.requestRepository.saveAndFlush(employee);
    }
}
