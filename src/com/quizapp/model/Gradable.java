package com.quizapp.model;
/**
 * Base interface for entities that can be graded.
 * Standardizes the score calculation logic across the quiz system.
 */
public interface Gradable {
    /**
     * Calculates the total score based on the number of correct answers.
     * @return The calculated total score.
     */
    int calculateScore();
}
