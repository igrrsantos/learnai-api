package com.learnai.dto;

import jakarta.validation.constraints.NotNull;

public class LearnAiRequest {
    @NotNull(message = "O campo 'topic' é obrigatório.")
    private String topic;

    @NotNull(message = "O campo 'level' é obrigatório.")
    private String level;

    // Getters e Setters
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
