package com.quizapp.model;

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
