package com.learnai.controller;

import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import com.learnai.service.LearnAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "LearnAI", description = "Endpoints de geração de conteúdo com IA")
public class LearnAiController {

    private final LearnAiService learnAiService;

    public LearnAiController(LearnAiService learnAiService) {
        this.learnAiService = learnAiService;
    }

    @Operation(
            summary = "Gerar conteúdo com IA",
            description = "Gera um conteúdo de aprendizagem com base no tópico e nível informados",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping("/learnai")
    public ResponseEntity<LearnAiResponse> generateContent(@Valid @RequestBody LearnAiRequest request) {
        LearnAiResponse response = learnAiService.processRequest(request);
        return ResponseEntity.ok(response);
    }
}
