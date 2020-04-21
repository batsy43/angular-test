package com.angular.api.controller;

import com.angular.api.domain.User;
import com.angular.api.repository.UserRepository;
import com.angular.api.service.api.UserService;
import com.angular.api.utils.messages.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
