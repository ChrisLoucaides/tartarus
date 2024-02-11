package com.chrisloucaides.tartarus.service;

import com.chrisloucaides.tartarus.model.User;
import com.chrisloucaides.tartarus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String userEmail) { //TODO FYP-2: TDD ME
        return userRepository.findByEmail(userEmail);
    }

    public boolean authenticateUser(String userEmail, String password) {
        User user = userRepository.findByEmail(userEmail);
        return user != null && user.password().equals(password);
    }
}
