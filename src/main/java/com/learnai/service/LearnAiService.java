package com.learnai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class LearnAiService {

    private final PromptService promptService;
    private final OpenAiService openAiService;
    private final ObjectMapper objectMapper;

    public LearnAiService(PromptService promptService, OpenAiService openAiService, ObjectMapper objectMapper) {
        this.promptService = promptService;
        this.openAiService = openAiService;
        this.objectMapper = objectMapper;
    }

    public LearnAiResponse processRequest(LearnAiRequest request) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("prompts/learnai-prompt.txt");
            if (is == null) {
                throw new FileNotFoundException("Arquivo de prompt não encontrado no classpath!");
            }
            String template = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            String prompt = promptService.preparePrompt(template, request.getTopic(), request.getLevel());
            String aiResponse = openAiService.sendMessage(prompt);
            return objectMapper.readValue(aiResponse, LearnAiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar resposta da IA: " + e.getMessage(), e);
        }
    }
}
