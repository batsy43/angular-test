package com.angular.api.controller.soap;

import com.angular.api.domain.User;
import com.angular.api.gs_ws.GetUserByMsisdnRequest;
import com.angular.api.gs_ws.GetUserByMsisdnResponse;
import com.angular.api.gs_ws.UserResponse;
import com.angular.api.service.api.UserService;
import com.angular.api.utils.messages.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.angular.api.gs_ws.AddUserResponse;


public class RegistrationEndpoint {

    public static final String NAMESPACE_URI = "http://www.angular.api.com/registration-ws";

    private UserService userService;

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



}
