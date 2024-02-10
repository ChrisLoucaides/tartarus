package com.chrisloucaides.tartarus.service;

import com.chrisloucaides.tartarus.model.User;
import com.chrisloucaides.tartarus.repository.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    public static final String A_VALID_USER_EMAIL = "christosloucaides@gmail.com";
    public static final String AN_INVALID_USER_EMAIL = "nonexistent@example.com";
    public static final String A_VALID_USER_PASSWORD = "password123";
    public static final String AN_INVALID_USER_PASSWORD = "invalid";

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Nested
    class UserRepositoryLoginTest {
        @Test
        public void shouldAuthenticateGivenValidUserWithValidPassword() {

            givenAUserWithEmail(A_VALID_USER_EMAIL);

            boolean isAuthenticated = whenAuthenticatingUser(A_VALID_USER_EMAIL, A_VALID_USER_PASSWORD);
            
            thenUserShouldBeAuthenticated(isAuthenticated);
        }

        @Test
        void shouldNotAuthenticateGivenInvalidUser() {
            givenAUserWithEmail(A_VALID_USER_EMAIL);

            boolean isAuthenticated = whenAuthenticatingUser(AN_INVALID_USER_EMAIL, A_VALID_USER_PASSWORD);

            thenUserShouldNotBeAuthenticated(isAuthenticated);
        }

        @Test
        void shouldNotAuthenticateGivenCorrectEmailButWrongPassword() {
            givenAUserWithEmail(AN_INVALID_USER_EMAIL);

            boolean isAuthenticated = whenAuthenticatingUser(AN_INVALID_USER_EMAIL, AN_INVALID_USER_PASSWORD);

            thenUserShouldNotBeAuthenticated(isAuthenticated);
        }

        private void givenAUserWithEmail(String email) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(UserServiceTest.A_VALID_USER_PASSWORD);
            when(userRepository.findByUserEmail(email)).thenReturn(user);
        }

        private boolean whenAuthenticatingUser(String userEmail, String password) {
            return userService.authenticateUser(userEmail, password);
        }

        private void thenUserShouldBeAuthenticated(boolean isAuthenticated) {
            assertTrue(isAuthenticated, "User should be authenticated");
        }

        private void thenUserShouldNotBeAuthenticated(boolean isAuthenticated) {
            assertFalse(isAuthenticated, "User should not be authenticated");
        }
    }
}