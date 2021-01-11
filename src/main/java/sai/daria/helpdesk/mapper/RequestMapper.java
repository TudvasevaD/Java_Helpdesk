package sai.daria.helpdesk.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sai.daria.helpdesk.DTO.RequestDTO;
import sai.daria.helpdesk.entities.Request;
import sai.daria.helpdesk.services.UserDetailService;

@Component
public class RequestMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserDetailService userDetailService;

    public Request mapRequestsDTOToRequests(RequestDTO requestsDTO) {
        Request request = new Request();

        request.setText(requestsDTO.getRequest().getText());
        request.setStatus(requestsDTO.getRequest().getStatus());
        request.setUser(requestsDTO.getRequest().getUser());
        request.setTheme(requestsDTO.getRequest().getTheme());
        request.setRdate(requestsDTO.getRequest().getRdate());
        request.setComm(requestsDTO.getRequest().getComm());

        return request;
    }
}
