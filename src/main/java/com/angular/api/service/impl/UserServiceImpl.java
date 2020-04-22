package com.angular.api.service.impl;

import com.angular.api.domain.User;
import com.angular.api.repository.UserRepository;
import com.angular.api.service.api.UserService;
import com.angular.api.utils.messages.Response;
import zw.co.econet.commons.msisdn.Msisdn;
import zw.co.econet.commons.msisdn.formatter.MsisdnFormatter;
import zw.co.econet.commons.msisdn.parser.MsisdnParser;


import java.util.List;
import java.util.Optional;

import static java.util.Locale.ENGLISH;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final MsisdnParser msisdnParser;

    public UserServiceImpl(UserRepository userRepository, MsisdnParser msisdnParser) {
        this.userRepository = userRepository;
        this.msisdnParser = msisdnParser;
    }

    @Override
    public Response save(User user) {

        Response response = new Response();

        Optional<User> userSearched = userRepository.findByMsisdn(msisdnConverter(user.getMsisdn()));

        if(userSearched.isPresent())
        {
            response.setMessage("already Registered");
            response.setSuccess(false);
            response.setUser(userSearched.get());

            return response;
        }

        User userSaved = userRepository.save(user);

        response.setMessage("success");
        response.setSuccess(true);
        response.setUser(userSaved);

        return response;
    }

    @Override
    public Response findAll() {

        Response response = new Response();

        List<User> userList = userRepository.findAll();

        response.setMessage("success");
        response.setSuccess(true);
        response.setUserList(userList);

        return response;
    }

    @Override
    public Response findByMsisdn(String msisdn) {

        Response response = new Response();

        Optional<User> userSearched = userRepository.findByMsisdn(msisdnConverter(msisdn));

        if(!userSearched.isPresent())
        {
            response.setMessage("Please Register First ");
            response.setSuccess(false);

            return response;
        }

        response.setMessage("success");
        response.setSuccess(true);
        response.setUser(userSearched.get());

        return response;
    }


    public String msisdnConverter(String msisdn)
    {

        Msisdn msisdnParsed = msisdnParser.parse(msisdn,ENGLISH);

        String msisdnFormated = MsisdnFormatter.MIN_ZERO_PREFIXED.format(msisdnParsed);

        return msisdnFormated;

    }
}
