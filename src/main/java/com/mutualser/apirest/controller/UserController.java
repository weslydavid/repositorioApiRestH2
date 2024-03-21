package com.mutualser.apirest.controller;

import com.mutualser.apirest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.mutualser.apirest.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public Page<User> getAllUser(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return userService.getAllUser(pageable);
    }
}
