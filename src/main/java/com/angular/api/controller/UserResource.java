package com.angular.api.controller;

import com.angular.api.domain.User;
import com.angular.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    public User saveUser(@RequestBody User user)
    {

        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}
