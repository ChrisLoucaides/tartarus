package com.chrisloucaides.tartarus.controller;

import com.chrisloucaides.tartarus.service.UserService;
import com.chrisloucaides.tartarus.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping("/userlogin/")
    public ResponseEntity<String> login(@RequestParam String userEmail, @RequestParam String password) { //TODO FYP-2: Refactor me
        boolean isAuthenticated = userService.authenticateUser(userEmail, password);

        if (isAuthenticated) {
            String jwtToken = jwtTokenUtil.generateToken(userEmail);

            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Authorization", "Bearer " + jwtToken)
                    .body("User authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
}
