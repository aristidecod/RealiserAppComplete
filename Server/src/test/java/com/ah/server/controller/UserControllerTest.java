package com.ah.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ah.server.model.User;
import com.ah.server.service.UserService;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)  // Désactive les filtres de sécurité
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    // Test pour récupérer tous les utilisateurs
    @Test
    public void getAllUsersTest() throws Exception {
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        given(userService.getAllUsers()).willReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    // Test pour récupérer un utilisateur par ID
    @Test
    public void getUserByIdTest() throws Exception {
        User user = new User("user1", "password1");

        given(userService.getUserById(1L)).willReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(user.getUsername()));
    }

    // Test pour créer un nouvel utilisateur
    @Test
    public void createUserTest() throws Exception {
        User user = new User("newUser", "newPassword");
        given(userService.registerUser(user.getUsername(), user.getPasswordHash())).willReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(user.getUsername()));
    }

    // Test pour mettre à jour un utilisateur
    @Test
    public void updateUserTest() throws Exception {
        User updatedUser = new User("updatedUser", "updatedPassword");
        given(userService.updateUser(1L, updatedUser.getUsername(), updatedUser.getPasswordHash())).willReturn(updatedUser);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(updatedUser.getUsername()));
    }

    // Test pour supprimer un utilisateur
    @Test
    public void deleteUserTest() throws Exception {
        doNothing().when(userService).deleteUserById(1L);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}
