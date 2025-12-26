package com.quizapp.model;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceQuestionTest {

    @org.junit.jupiter.api.Test
    void testCheckAnswer_Correct() {
        String[] options = {"Red", "Blue", "Green"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("What color is the sky?", options, "Blue");
        mcq.answer("Blue");
        assertTrue(mcq.checkAnswer(), "The answer should be correct.");
    }

    @org.junit.jupiter.api.Test
    void testCheckAnswer_Incorrect() {
        String[] options = {"Red", "Blue", "Green"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("What color is the sky?", options, "Blue");
        mcq.answer("Red");
        assertFalse(mcq.checkAnswer(), "The answer should be incorrect.");
    }

    @org.junit.jupiter.api.Test
    void testGetOptions() {
        String[] options = {"Red", "Blue", "Green"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("What color is the sky?", options, "Blue");
        assertArrayEquals(options, mcq.getOptions(), "The options should match the initialized values.");
    }

}