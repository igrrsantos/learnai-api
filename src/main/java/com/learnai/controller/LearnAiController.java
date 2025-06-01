package com.learnai.controller;

import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import com.learnai.service.LearnAiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LearnAiController {

    private final LearnAiService learnAiService;

    public LearnAiController(LearnAiService learnAiService) {
        this.learnAiService = learnAiService;
    }

    @PostMapping("/learnai")
    public ResponseEntity<LearnAiResponse> generateContent(@Valid @RequestBody LearnAiRequest request) {
        LearnAiResponse response = learnAiService.processRequest(request);
        return ResponseEntity.ok(response);
    }
}
