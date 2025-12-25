package com.quizapp.model;

public class MultipleChoiceQuestion extends Question {
    private String[] options;
    private String correctAnswer;

    public MultipleChoiceQuestion(String text, String[] options, String correctAnswer) {
        super(text);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public boolean checkAnswer() {
        return correctAnswer.equals(userAnswer);
    }

    @Override
    public String getCorrectAnswerDisplay() {
        return correctAnswer;
    }
}
