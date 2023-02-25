package com.techmaster.testSpringRESTAPI.controller;

import com.techmaster.testSpringRESTAPI.model.User;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(

    )
}
