package com.learnai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnai.dto.LoginRequestDTO;
import com.learnai.dto.UserRegistrationDTO;
import com.learnai.entity.User;
import com.learnai.service.AuthService;
import com.learnai.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private AuthService authService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterSuccess() throws Exception {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.setEmail("novo@teste.com");
        dto.setPassword("senha123");
        dto.setFullName("Nome Teste");

        User user = new User();
        user.setEmail(dto.getEmail());

        when(userService.register(any(UserRegistrationDTO.class))).thenReturn(user);

        mockMvc.perform(post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuário registrado com sucesso: " + dto.getEmail()));
    }

    @Test
    void testLoginSuccess() throws Exception {
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setEmail("teste@email.com");
        dto.setPassword("senha123");

        when(authService.login(any(LoginRequestDTO.class))).thenReturn("token_abc123");

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Bearer token_abc123"));
    }
}
