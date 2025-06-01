package com.learnai.controller;

import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import com.learnai.service.LearnAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/learnai")
public class LearnAiController {

    private final LearnAiService learnAiService;

    public LearnAiController(LearnAiService learnAiService) {
        this.learnAiService = learnAiService;
    }

    @PostMapping
    public ResponseEntity<LearnAiResponse> generateContent(@RequestBody LearnAiRequest request) {
        LearnAiResponse response = learnAiService.processRequest(request);
        return ResponseEntity.ok(response);
    }
}
