package com.quizapp.model;

import static org.junit.jupiter.api.Assertions.*;

class TrueFalseQuestionTest {
    @org.junit.jupiter.api.Test
    void testCheckAnswer_CorrectTrue() {
        TrueFalseQuestion tfq = new TrueFalseQuestion("The sky is blue.", true);
        tfq.answer("True");
        assertTrue(tfq.checkAnswer(), "The answer should be correct for True.");
    }

    @org.junit.jupiter.api.Test
    void testCheckAnswer_CorrectFalse() {
        TrueFalseQuestion tfq = new TrueFalseQuestion("The sky is green.", false);
        tfq.answer("False");
        assertTrue(tfq.checkAnswer(), "The answer should be correct for False.");
    }

    @org.junit.jupiter.api.Test
    void testCheckAnswer_Incorrect() {
        TrueFalseQuestion tfq = new TrueFalseQuestion("The sky is blue.", true);
        tfq.answer("False");
        assertFalse(tfq.checkAnswer(), "The answer should be incorrect.");
    }

    @org.junit.jupiter.api.Test
    void testGetCorrectAnswerDisplay_True() {
        TrueFalseQuestion tfq = new TrueFalseQuestion("The sky is blue.", true);
        assertEquals("True", tfq.getCorrectAnswerDisplay(), "The correct answer display should be 'True'.");
    }

    @org.junit.jupiter.api.Test
    void testGetCorrectAnswerDisplay_False() {
        TrueFalseQuestion tfq = new TrueFalseQuestion("The sky is green.", false);
        assertEquals("False", tfq.getCorrectAnswerDisplay(), "The correct answer display should be 'False'.");
    }

}