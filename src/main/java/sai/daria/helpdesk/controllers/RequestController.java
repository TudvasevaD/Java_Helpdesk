package sai.daria.helpdesk.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sai.daria.helpdesk.entities.Request;
import sai.daria.helpdesk.repo.RequestRepository;


@Controller
@Component
public class RequestController {
    private static final int PAGE_SIZE = 10;
    private static Logger logger = LoggerFactory.getLogger(RequestController.class);

    private RequestRepository requestRepository;

    @Autowired
    public void setClientService(RequestRepository requestRepository){
        this.requestRepository=requestRepository;
    }

    @GetMapping("/requests")
    public String requests(Model model) {
        model.addAttribute("requests", requestRepository.findAll(Sort.by("status","theme","user")));
        System.out.println(requestRepository.findAll(Sort.by("status","theme","user")));
        return "requests/ticket";
    }

    @GetMapping("/ticketred/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional(propagation = Propagation.REQUIRED)
    public String edit(Model model, @PathVariable("id") Integer id) {
        Request r = requestRepository.getOne(id);
        model.addAttribute("request",r);
        return "request/ticketred";
    }

    @PostMapping("/postrequest")
    @Transactional(propagation = Propagation.REQUIRED)
    public String postRequest(@ModelAttribute Request request, Model model) {
        logger.info(request.toString());
        requestRepository.saveAndFlush(request);
        return "redirect:/user";
    }
}