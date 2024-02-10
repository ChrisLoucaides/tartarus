package com.chrisloucaides.tartarus.service;

import com.chrisloucaides.tartarus.model.User;
import com.chrisloucaides.tartarus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public boolean authenticateUser(String userEmail, String password) {
        User user = userRepository.findByUserEmail(userEmail);
        return user != null && user.password().equals(password);
    }
}
