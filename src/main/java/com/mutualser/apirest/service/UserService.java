package com.mutualser.apirest.service;

import com.mutualser.apirest.model.User;
import com.mutualser.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Page<User> getAllUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public boolean authenticateUser(String name, String password) {
        User user = userRepository.findByName(name);
        if (user.getName().equals(name) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
