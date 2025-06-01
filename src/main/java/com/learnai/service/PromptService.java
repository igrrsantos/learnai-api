package com.learnai.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class PromptService {

    public String loadPromptTemplate(String filePath) throws Exception {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] bytes = Files.readAllBytes(resource.getFile().toPath());
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public String preparePrompt(String template, String topic, String level) {
        if (topic == null || level == null) {
            throw new IllegalArgumentException("Os parâmetros 'topic' e 'level' não podem ser nulos.");
        }
        return template
                .replace("{topic}", topic)
                .replace("{level}", level);
    }
}
