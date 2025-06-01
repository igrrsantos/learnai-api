package com.learnai.controller;

import com.learnai.dto.LoginRequestDTO;
import com.learnai.dto.UserRegistrationDTO;
import com.learnai.entity.User;
import com.learnai.service.AuthService;
import com.learnai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO dto) {
        User user = userService.register(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso: " + user.getEmail());
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok().body(Map.of("token", token));
    }
}
