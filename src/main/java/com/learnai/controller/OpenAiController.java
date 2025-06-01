package com.learnai.controller;

import com.learnai.service.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class OpenAiController {

    private final OpenAiService openAiService;

    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody String message) {
        String response = openAiService.sendMessage(message);
        return ResponseEntity.ok(response);
    }
}

