package com.example.railway_management.service;

import com.example.railway_management.model.User;
import com.example.railway_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(String username, String password, String role){
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()){
            throw new IllegalStateException("Username is already taken");
        }

        String encodePassword = passwordEncoder.encode(password);

        User newUser = new User(username, encodePassword, role);
        return userRepository.save(newUser);
    }
}
