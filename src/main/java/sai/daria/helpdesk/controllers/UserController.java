package sai.daria.helpdesk.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sai.daria.helpdesk.DTO.UserEditBindingModel;
import sai.daria.helpdesk.DTO.UserProfileViewModel;
import sai.daria.helpdesk.DTO.UserServiceModel;
import sai.daria.helpdesk.entities.Users;
import sai.daria.helpdesk.services.RequestServiceI;
import sai.daria.helpdesk.services.UserDetailService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController  {

    private final UserDetailService userService;
    private final RequestServiceI requestService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserDetailService userService, RequestServiceI requestService, ModelMapper modelMapper) {
        this.userService = userService;
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "login";
    }


    @GetMapping("/adm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin(Model model) {

        model.addAttribute("users", requestService.findAllRequests());
        return "user/adm";
    }

    @GetMapping("/userReq/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userReq(@PathVariable String id, Model model) {
        this.userService.findUserById(id).getName();
        model.addAttribute("users", requestService.findRequestByUserName(this.userService.findUserById(id).getName()));
        return "user/userReq";
    }

}
