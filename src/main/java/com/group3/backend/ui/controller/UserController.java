package com.group3.backend.ui.controller;

import com.group3.backend.service.UserService;
import com.group3.backend.ui.model.request.UserRequest;
import com.group3.backend.ui.model.response.PharmacyResponse;
import com.group3.backend.ui.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //So we can use GET, POST, PUT, DELETE methods
@RequestMapping("users") //to define the URL. localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest uRequest) {
        UserResponse toReturn = userService.createUser(uRequest);
        return toReturn;
    }



}