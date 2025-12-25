package com.quizapp.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz implements Gradable {
    private List<Question> questions = new ArrayList<>();
    private String topic;
    private String difficulty;

    public Quiz(String topic, String difficulty) {
        this.topic = topic;
        this.difficulty = difficulty;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public int calculateScore() {
        int score = 0;
        for (Question q : questions) {
            if (q.checkAnswer()) score++;
        }
        return score;
    }

}
