package com.quizapp.model;

/**
 * Abstract base class for all question types in the quiz.
 * Holds common properties like question text, user's answer, and difficulty level.
 */
public abstract class Question {
    protected String text;
    protected String userAnswer;
    protected String difficulty;

    public Question(String text) {
        this.text = text;
        this.userAnswer = null;
    }

    public String getText() {
        return text;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void answer(String answer) {
        this.userAnswer = answer;
    }

    /**
     * Checks if the user's provided answer is correct.
     * Each specific question type (MC or TF) implements its own logic.
     * @return true if the answer is correct, false otherwise.
     */
    public abstract boolean checkAnswer();

    public abstract String getCorrectAnswerDisplay();
}
