package com.angular.api.service.impl;

import com.angular.api.domain.User;
import com.angular.api.repository.UserRepository;
import com.angular.api.service.api.UserService;
import com.angular.api.utils.messages.Response;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Response save(User user) {

        Response response = new Response();

        Optional<User> userSearched = userRepository.findByMsisdn(user.getMsisdn());

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
        return null;
    }
}
