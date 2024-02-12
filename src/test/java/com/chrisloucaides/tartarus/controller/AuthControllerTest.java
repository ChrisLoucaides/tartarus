package com.chrisloucaides.tartarus.controller;

import com.chrisloucaides.tartarus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void testLogin_ValidCredentials_ReturnsOk() throws Exception { //TODO FYP-2: Revisit this after frontend implementation
        // Given
        String userEmail = "test@example.com";
        String password = "password123";
        when(userService.authenticateUser(userEmail, password)).thenReturn(true);

        // When
        MockHttpServletRequestBuilder request = post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("userEmail", userEmail)
                .param("password", password)
                .with(csrf());
        ResultActions resultActions = mockMvc.perform(request);

        // Then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("Login success!"));
    }
}
