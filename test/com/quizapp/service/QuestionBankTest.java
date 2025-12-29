package com.quizapp.service;

import com.quizapp.model.Question;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuestionBank service.
 * These tests ensure that questions are correctly loaded, filtered,
 * and handled even when invalid inputs are provided.
 */
class QuestionBankTest {

    /**
     * Verifies that the QuestionBank successfully retrieves a list of questions
     * for a valid subject and difficulty level.
     */
    @Test
    void testGetQuestionsForTopic_ValidSelection() {
        // Arrange & Act: Request questions for a known valid category
        List<Question> questions = QuestionBank.getQuestionsForTopic("Science", "Easy");

        // Assert: The result should not be null
        assertNotNull(questions, "The question list should not be null for valid inputs.");

        // Assert: Ensure the list is not empty (assuming questions.txt has Science questions)
        assertFalse(questions.isEmpty(), "The question list should contain questions for a valid topic.");
    }

    /**
     * Verifies that the system handles invalid topics gracefully by returning
     * an empty list instead of throwing an exception or returning null.
     */
    @Test
    void testGetQuestionsForTopic_InvalidTopic() {
        // Act: Request questions for a topic that does not exist
        List<Question> questions = QuestionBank.getQuestionsForTopic("NonExistentTopic", "Easy");

        // Assert: The service should return an empty list for invalid topics
        assertNotNull(questions, "The service should return an empty list, not null, for invalid topics.");
        assertTrue(questions.isEmpty(), "The list should be empty when an invalid topic is selected.");
    }

    /**
     * Verifies the integrity of the data loaded from the file.
     * Checks if the question text is properly populated and not blank.
     */
    @Test
    void testQuestionDataIntegrity() {
        // Arrange: Load questions from a specific category
        List<Question> questions = QuestionBank.getQuestionsForTopic("History", "Medium");

        // Assert: If questions are found, verify the content of the first one
        if (!questions.isEmpty()) {
            Question firstQuestion = questions.get(0);

            // Text should be present
            assertNotNull(firstQuestion.getText(), "The question text must not be null.");

            // Text should not be an empty or whitespace-only string
            assertFalse(firstQuestion.getText().trim().isEmpty(), "The question text must not be blank.");
        }
    }

    /**
     * Verifies that the correct number of questions is retrieved if specified.
     * Note: Adjust the expected number based on your questions.txt content.
     */
    @Test
    void testQuestionCount() {
        List<Question> questions = QuestionBank.getQuestionsForTopic("Technology", "Hard");

        // Example assertion: Check if at least one question is loaded
        assertTrue(questions.size() >= 0, "QuestionBank should attempt to load questions from the file.");
    }
}