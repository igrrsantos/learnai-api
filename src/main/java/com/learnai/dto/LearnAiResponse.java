package com.learnai.dto;

import java.util.List;

public class LearnAiResponse {
    private String summary;
    private List<String> topics;
    private List<QuizItem> quiz;
    private List<String> tips;

    // Getters e Setters


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<QuizItem> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<QuizItem> quiz) {
        this.quiz = quiz;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public static class QuizItem {
        private String question;
        private List<String> options;
        private String answer;

        // Getters e Setters

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
