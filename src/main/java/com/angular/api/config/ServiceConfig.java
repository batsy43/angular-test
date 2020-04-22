package com.angular.api.config;

import com.angular.api.repository.UserRepository;
import com.angular.api.service.api.UserService;
import com.angular.api.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.econet.commons.msisdn.parser.MsisdnParser;


@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(UserRepository userRepository, MsisdnParser msisdnParser)
    {
        return new UserServiceImpl(userRepository,msisdnParser);
    }
}
