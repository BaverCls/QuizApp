package com.quizapp.service;
import com.quizapp.model.MultipleChoiceQuestion;
import com.quizapp.model.Question;
import com.quizapp.model.TrueFalseQuestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for managing the question data.
 * It handles reading questions from an external text file and filtering them
 * based on category and difficulty.
 */


public class QuestionBank {

    /**
     * Loads and filters questions from the resource file.
     * @param topic The subject of the questions (e.g., Science, History).
     * @param difficulty The level of difficulty (e.g., Easy, Hard).
     * @return A list of filtered Question objects.
     */

    private static final String FILE_PATH = "src/questions.txt";

    public static List<Question> getQuestionsForTopic(String topic, String difficulty) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 6) continue;

                String qTopic = parts[1];
                String qDifficulty = parts[2];

                if (qTopic.equalsIgnoreCase(topic) && qDifficulty.equalsIgnoreCase(difficulty)) {
                    String type = parts[0];
                    String text = parts[3];
                    if (type.equals("MC")) {
                        questions.add(new MultipleChoiceQuestion(text, parts[4].split(";"), parts[5]));
                    } else if (type.equals("TF")) {
                        questions.add(new TrueFalseQuestion(text, Boolean.parseBoolean(parts[5])));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occured while reading the file: " + e.getMessage());
        }

        return questions;
    }


}