package com.learnai.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class PromptService {

    private final ResourceLoader resourceLoader;

    public PromptService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String loadPromptTemplate(String filePath) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
