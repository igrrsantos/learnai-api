package com.learnai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnAiService {

    private final PromptService promptService;
    private final OpenAiService openAiService;
    private final ObjectMapper objectMapper;

    @Autowired
    public LearnAiService(PromptService promptService, OpenAiService openAiService, ObjectMapper objectMapper) {
        this.promptService = promptService;
        this.openAiService = openAiService;
        this.objectMapper = objectMapper;
    }

    public LearnAiResponse processRequest(LearnAiRequest request) {
        try {
            String template = promptService.loadPromptTemplate("prompts/learnai-prompt.txt");
            String prompt = promptService.preparePrompt(template, request.getTopic(), request.getLevel());
            String aiResponse = openAiService.sendMessage(prompt);
            return objectMapper.readValue(aiResponse, LearnAiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar resposta da IA: " + e.getMessage(), e);
        }
    }
}
