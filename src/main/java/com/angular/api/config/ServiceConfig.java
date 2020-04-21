package com.angular.api.config;

import com.angular.api.repository.UserRepository;
import com.angular.api.service.api.UserService;
import com.angular.api.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(UserRepository userRepository)
    {
        return new UserServiceImpl(userRepository);
    }
}
