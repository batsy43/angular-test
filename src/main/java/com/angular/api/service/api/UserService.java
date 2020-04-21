package com.angular.api.service.api;

import com.angular.api.domain.User;
import com.angular.api.utils.messages.Response;

import java.util.List;

public interface UserService {

    Response save(User user);

    Response findAll();

    Response findByMsisdn(String msisdn);
}
