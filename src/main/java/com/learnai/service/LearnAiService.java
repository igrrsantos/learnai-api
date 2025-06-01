package com.learnai.service;

import com.learnai.dto.LearnAiRequest;
import com.learnai.dto.LearnAiResponse;
import org.springframework.stereotype.Service;

@Service
public class LearnAiService {

    private final PromptService promptService;

    public LearnAiService(PromptService promptService) {
        this.promptService = promptService;
    }

    public LearnAiResponse processRequest(LearnAiRequest request) {
        try {
            String template = promptService.loadPromptTemplate("prompts/learnai-prompt.txt");
            String prompt = preparePrompt(template, request.getTopic(), request.getLevel());
            // Enviar o prompt para a API da OpenAI e processar a resposta
        } catch (Exception e) {
            // Tratar exceções de leitura do arquivo
        }
        return null;
    }

    private String preparePrompt(String template, String topic, String level) {
        return template.replace("{topic}", topic)
                .replace("{level}", level);
    }
}

