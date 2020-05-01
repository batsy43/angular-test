package com.registration.api.controller;

import com.registration.api.domain.User;
import com.registration.api.service.api.UserService;
import com.registration.api.utils.messages.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Response saveUser(@RequestBody User user)
    {

        return userService.save(user);
    }

    @GetMapping
    public Response findAll()
    {

        return userService.findAll();
    }

    @GetMapping("/msisdn/{msisdn}")
    public Response findByMsisdn(@PathVariable String msisdn)
    {

        return userService.findByMsisdn(msisdn);
    }
}
