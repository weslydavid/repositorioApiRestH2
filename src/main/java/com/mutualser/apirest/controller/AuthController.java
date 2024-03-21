package com.mutualser.apirest.controller;

import com.mutualser.apirest.model.User;
import com.mutualser.apirest.security.Util.JwtUtil;
import com.mutualser.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authenticate")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping
    public String generateToken(@RequestBody User authRequest) throws Exception {
        boolean isAuthenticated = userService.authenticateUser(authRequest.getName(), authRequest.getPassword());
        if (isAuthenticated) {
            return jwtUtil.generateToken(authRequest.getName());
        } else {
            throw new Exception("Autenticación fallida");
        }
    }
}
