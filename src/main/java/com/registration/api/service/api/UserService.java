package com.registration.api.service.api;

import com.registration.api.domain.User;
import com.registration.api.utils.messages.Response;

public interface UserService {

    Response save(User user);

    Response findAll();

    Response findByMsisdn(String msisdn);
}
