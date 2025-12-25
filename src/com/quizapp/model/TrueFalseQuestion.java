package com.quizapp.model;

/**
 * Represents a true/false question type.
 * Validates user input against a boolean correct answer.
 */
public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String text, boolean correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer() {
        if (userAnswer == null) return false;
        boolean userBool = userAnswer.equalsIgnoreCase("True");
        return userBool == correctAnswer;
    }

    @Override
    public String getCorrectAnswerDisplay() {
        return correctAnswer ? "True" : "False";
    }
}
