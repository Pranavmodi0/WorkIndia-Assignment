package com.example.railway_management.service;

import com.example.railway_management.model.User;
import com.example.railway_management.repository.UserRepository;
import com.example.railway_management.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            String token = TokenUtil.generateToken();
            user.setToken(token);
            userRepository.save(user);
            return token;
        }
        return null;
    }
}
