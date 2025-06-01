package com.learnai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnai.config.SecurityConfigTest;
import com.learnai.dto.UserRegistrationDTO;
import com.learnai.entity.User;
import com.learnai.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.learnai.service.UserService;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ActiveProfiles("test")
@Import(SecurityConfigTest.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterSuccess() throws Exception {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.setEmail("novo@teste.com");
        dto.setPassword("senha123");
        dto.setFullName("Nome Teste");

        User user = UserFactory.createUserWithEmail(dto.getEmail());

        when(userService.register(any(UserRegistrationDTO.class))).thenReturn(user);

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuário registrado com sucesso: " + dto.getEmail()));
    }

}