package sai.daria.helpdesk.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MainController {

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login(Model model) {
        return "login";
    }

}
