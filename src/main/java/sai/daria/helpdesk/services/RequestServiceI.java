package sai.daria.helpdesk.services;

import sai.daria.helpdesk.DTO.RequestDTO;
import sai.daria.helpdesk.entities.Request;

import java.util.List;

public interface RequestServiceI {

    public List<Request> findAllRequests();

    public Request createRequest(Request request);

    public Request updateRequest(RequestDTO requestDTO);

    Request registerRequest(RequestDTO requestDTO);

    Request findRequestByUserName(String name);

    Request findRequestById(String id);

    void deleteRequest(String requestId);
}
