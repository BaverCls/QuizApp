package com.quizapp;

import com.quizapp.model.*;
import com.quizapp.service.QuestionBank;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Main application controller that manages the Quiz lifecycle via a Console Interface.
 * This class implements a 3-minute time limit, randomized question delivery using shuffle,
 * and strict input validation to ensure a robust user experience.
 */
public class ConsoleApp {

    // 3 minutes in milliseconds
    private static final long TIME_LIMIT = 180000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("========================================");
            System.out.println("    WELCOME TO THE QUIZ APPLICATION     ");
            System.out.println("========================================");

            String name = "";
            while (name.isEmpty()) {
                System.out.print("Please enter your name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) System.out.println("!!! Name cannot be empty.");
            }
            Student student = new Student(name);

            String topic = getValidatedTopic(scanner);
            String difficulty = getValidatedDifficulty(scanner);

            startQuizSession(student, topic, difficulty, scanner);

            keepRunning = askToRestart(scanner);
        }
        System.out.println("\nExiting...");
        scanner.close();
    }

    /**
     * Executes the main quiz session. It handles the temporal control (3-minute limit),
     * randomizes question order using Collections.shuffle, and manages the question-answer loop.
     * @param student The current student participating in the quiz.
     * @param topic The selected subject category.
     * @param difficulty The selected level of difficulty.
     * @param scanner The Scanner object for user input.
     */
    private static void startQuizSession(Student student, String topic, String difficulty, Scanner scanner) {
        List<Question> questions = QuestionBank.getQuestionsForTopic(topic, difficulty);

        if (questions.isEmpty()) {
            System.out.println("\n!!! No questions found.");
            return;
        }

        // Shuffle the questions to randomize their order
        Collections.shuffle(questions);

        Quiz quiz = new Quiz();
        questions.forEach(quiz::addQuestion);

        // --- Large Timer Alert ---
        System.out.println("\n-------------------------------------------");
        System.out.println("* *");
        System.out.println("* !!! YOU HAVE 3 MINUTES !!!      *");
        System.out.println("* *");
        System.out.println("-------------------------------------------");

        long startTime = System.currentTimeMillis(); // Timer starts here
        boolean timeOut = false;

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            // Pre-question time check
            if (System.currentTimeMillis() - startTime > TIME_LIMIT) {
                timeOut = true;
                break;
            }

            Question q = quiz.getQuestions().get(i);
            boolean valid = false;

            while (!valid) {
                // Secondary time check inside validation loop
                if (System.currentTimeMillis() - startTime > TIME_LIMIT) {
                    timeOut = true;
                    break;
                }

                System.out.println("\nQuestion " + (i + 1) + ": " + q.getText());
                valid = processAnswer(q, scanner);
                if (!valid) System.out.println("!!! Invalid input. Please input a valid answer.");
            }

            if (timeOut) break;
        }

        if (timeOut) {
            System.out.println("\n\n[!] TIME EXCEEDED! Redirecting to results...");
        }

        displayResults(student, quiz);
    }

    private static void displayResults(Student student, Quiz quiz) {
        int score = quiz.calculateScore();
        student.setLastScore(score);

        System.out.println("\n========================================");
        System.out.println("QUIZ RESULTS FOR " + student.getName().toUpperCase());
        System.out.println("Score: " + score + " / " + quiz.getQuestions().size());
        System.out.println("========================================");

        System.out.println("\n--- Review of Incorrect/Unanswered Questions ---");
        boolean perfect = true;
        for (Question q : quiz.getQuestions()) {
            if (!q.checkAnswer()) {
                perfect = false;
                System.out.println("\nQ: " + q.getText());
                // Handle null answers from timeout
                String userAns = (q.getUserAnswer() == null) ? "NOT ANSWERED (TIMEOUT)" : q.getUserAnswer();
                System.out.println("    Your Answer: " + userAns);
                System.out.println("    Correct Answer: " + q.getCorrectAnswerDisplay());
            }
        }
        if (perfect) System.out.println("Amazing! All answers were correct.");
    }

    /**
     * Processes and validates the user's answer based on the question type.
     * objects through a single interface, ensuring strict input compliance.
     * @param q The current Question object being answered.
     * @param scanner The Scanner for reading user choices.
     * @return boolean True if the input is valid and processed; false otherwise.
     */
    private static boolean processAnswer(Question q, Scanner scanner) {
        if (q instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) q;
            String[] opts = mcq.getOptions();
            for (int j = 0; j < opts.length; j++) {
                System.out.println("   " + (char)('A' + j) + ") " + opts[j]);
            }
            System.out.print("Answer (Letter): ");
            String input = scanner.nextLine().toUpperCase().trim();
            if (input.length() == 1) {
                int index = input.charAt(0) - 'A';
                if (index >= 0 && index < opts.length) {
                    q.answer(opts[index]);
                    return true;
                }
            }
        } else if (q instanceof TrueFalseQuestion) {
            System.out.println("   (True / False)");
            System.out.print("Answer: ");
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("true") || input.equals("false")) {
                q.answer(input);
                return true;
            }
        }
        return false;
    }

    // Helper methods for validation
    private static String getValidatedTopic(Scanner scanner) {
        String t = null;
        while (t == null) {
            System.out.println("\nSelect Subject (1: Science, 2: Technology, 3: History):");
            String in = scanner.nextLine().toLowerCase().trim();
            if (in.equals("1") || in.equals("science")) t = "Science";
            else if (in.equals("2") || in.equals("technology")) t = "Technology";
            else if (in.equals("3") || in.equals("history")) t = "History";
            else System.out.println("!!! Invalid choice.");
        }
        return t;
    }

    private static String getValidatedDifficulty(Scanner scanner) {
        String d = null;
        while (d == null) {
            System.out.println("\nSelect Difficulty (1: Easy, 2: Medium, 3: Hard):");
            String in = scanner.nextLine().toLowerCase().trim();
            if (in.equals("1") || in.equals("easy")) d = "Easy";
            else if (in.equals("2") || in.equals("medium")) d = "Medium";
            else if (in.equals("3") || in.equals("hard")) d = "Hard";
            else System.out.println("!!! Invalid choice.");
        }
        return d;
    }

    private static boolean askToRestart(Scanner scanner) {
        while (true) {
            System.out.print("\nAnother quiz? (y/n): ");
            String c = scanner.nextLine().toLowerCase().trim();
            if (c.equals("y")) return true;
            if (c.equals("n")) return false;
            System.out.println("!!! Use 'y' or 'n'.");
        }
    }
}