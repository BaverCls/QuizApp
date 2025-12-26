package com.quizapp.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    void testTotalScoreCalculation() {
        Quiz quiz = new Quiz();

        // Simulate one correct and one incorrect answer for testing
        TrueFalseQuestion q1 = new TrueFalseQuestion("Is Java object-oriented?", true);
        q1.answer("True"); // Correct answer

        TrueFalseQuestion q2 = new TrueFalseQuestion("Is 2+2=5?", false);
        q2.answer("True"); // Incorrect answer

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        // Expected Score: 1
        assertEquals(1, quiz.calculateScore(), "Scoring logic is incorrect!");
    }
}
