package com.quizapp.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student participating in the quiz.
 * Tracks the student's name, their most recent score, and their entire score history.
 */
public class Student {
    private String name;
    private double lastScore;

    /**
     * Initializes a new Student with the given name.
     * * @param name The name of the student.
     */
    public Student(String name) {
        this.name = name;
    }

    // Getters
    /**
     * @return The student's name.
     */
    public String getName() { return name; }
    /**
     * @return The most recent score recorded for this student.
     */
    public double getLastScore() { return lastScore; }

}
