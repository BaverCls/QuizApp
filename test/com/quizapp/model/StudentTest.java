package com.quizapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testStudentInitialization() {
        Student student = new Student("Baver");
        assertEquals("Baver", student.getName(), "Name should be correctly initialized.");
    }

    @Test
    void testSetAndGetLastScore() {
        Student student = new Student("Baver");
        student.setLastScore(8);
        assertEquals(8, student.getLastScore(), "Last score should be updated correctly.");
    }
}