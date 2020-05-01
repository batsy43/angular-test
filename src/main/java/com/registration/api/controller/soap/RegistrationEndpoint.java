package com.registration.api.controller.soap;

import com.registration.api.domain.User;
import com.registration.api.gs_ws.*;
import com.registration.api.service.api.UserService;
import com.registration.api.utils.messages.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


public class RegistrationEndpoint {

    public static final String NAMESPACE_URI = "http://www.registration.api.com/registration-ws";

    private UserService userService;

    public RegistrationEndpoint() {

    }

    @Autowired
    public RegistrationEndpoint(UserService userService) {

        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByMsisdnRequest")
    @ResponsePayload
    public GetUserByMsisdnResponse getUserByMsisdn(@RequestPayload GetUserByMsisdnRequest request) {
        GetUserByMsisdnResponse response = new GetUserByMsisdnResponse();
        Response user = userService.findByMsisdn(request.getMsisdn());

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        response.setUserResponse(userResponse);

        return response;

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    @ResponsePayload
    public GetAlUserResponse getAllUsers() {

        GetAlUserResponse response = new GetAlUserResponse();

        Response user = userService.findAll();

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        response.setUserResponse(userResponse);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();

        User userRequest = new User();
        BeanUtils.copyProperties(request, userRequest);

        Response user = userService.save(userRequest);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        response.setUserResponse(userResponse);

        return response;

    }



}
