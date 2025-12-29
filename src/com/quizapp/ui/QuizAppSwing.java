package com.quizapp.ui;
import com.quizapp.model.*;
import com.quizapp.service.QuestionBank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * The main Graphical User Interface (GUI) for the Quiz Application.
 * Manages screen transitions between setup, the active quiz, and final results.
 */

public class QuizAppSwing extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    // Game State
    private Student currentStudent;
    private Quiz currentQuiz;
    private int currentQuestionIndex = 0;

    // Components
    private JTextField nameField;
    private JPanel quizContentPanel;
    private JLabel questionLabel;
    private JPanel optionsPanel;
    private ButtonGroup optionsGroup;

    /**
     * Initializes the UI components and starts the application.
     */

    public QuizAppSwing() {
        setTitle("OOP QUIZ");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 1. Setup Panel
        cardPanel.add(createSetupPanel(), "SETUP");

        // 2. Quiz Activate Panel
        cardPanel.add(createQuizPanel(), "QUIZ");


        add(cardPanel);
    }

    private Timer quizTimer;
    private int timeLeft = 180;
    private JLabel timerLabel;

    private JPanel createSetupPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Quiz");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(new JLabel("Name:"), gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(new JLabel("Select Subject"), gbc);

        JPanel subjectPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        ButtonGroup subjectGroup = new ButtonGroup();
        String[] topics = {"Science", "History", "Technology"};
        for (String topic : topics) {
            JRadioButton btn = new JRadioButton(topic);
            btn.setActionCommand(topic);
            subjectGroup.add(btn);
            subjectPanel.add(btn);
        }
        gbc.gridy = 3;
        panel.add(subjectPanel, gbc);

        gbc.gridy = 4;
        panel.add(new JLabel("Select Difficulty"), gbc);

        JPanel difficultyPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        ButtonGroup difficultyGroup = new ButtonGroup();
        String[] difficulties = {"Easy", "Medium", "Hard"};
        for (String level : difficulties) {
            JRadioButton btn = new JRadioButton(level);
            btn.setActionCommand(level);
            difficultyGroup.add(btn);
            difficultyPanel.add(btn);
        }
        gbc.gridy = 5;
        panel.add(difficultyPanel, gbc);

        JButton startQuizButton = new JButton("Start");
        startQuizButton.setEnabled(false); // Initially disabled
        startQuizButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name");
                return;
            }

            String selectedSubject = subjectGroup.getSelection() != null ? subjectGroup.getSelection().getActionCommand() : null;
            String selectedDifficulty = difficultyGroup.getSelection() != null ? difficultyGroup.getSelection().getActionCommand() : null;

            if (selectedSubject == null || selectedDifficulty == null) {
                JOptionPane.showMessageDialog(this, "Please select both subject and difficulty");
                return;
            }

            this.currentStudent = new Student(name);
            this.currentQuiz = generateQuiz(selectedSubject, selectedDifficulty);
            this.currentQuestionIndex = 0;

            loadQuestionUI();
            cardLayout.show(cardPanel, "QUIZ");

            //Timerı başlat
            startCountdown();
        });


        ActionListener enableStartButton = e -> {
            if (subjectGroup.getSelection() != null && difficultyGroup.getSelection() != null) {
                startQuizButton.setEnabled(true);
            }
        };

        Enumeration<AbstractButton> subjectButtons = subjectGroup.getElements();
        while (subjectButtons.hasMoreElements()) {
            subjectButtons.nextElement().addActionListener(enableStartButton);
        }

        Enumeration<AbstractButton> difficultyButtons = difficultyGroup.getElements();
        while (difficultyButtons.hasMoreElements()) {
            difficultyButtons.nextElement().addActionListener(enableStartButton);
        }

        gbc.gridy = 6;
        panel.add(startQuizButton, gbc);

        return panel;
    }

    private JPanel createQuizPanel() {
        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel("Question will appear here");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        timerLabel = new JLabel("Time: 03:00");
        timerLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        timerLabel.setForeground(Color.RED);

        questionLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        topPanel.add(questionLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);
        panel.add(topPanel, BorderLayout.NORTH);

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        panel.add(optionsPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> handleNextQuestion());
        panel.add(nextButton, BorderLayout.SOUTH);

        return panel;
    }

    private void startQuiz(String topic, String difficulty) {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name");
            return;
        }

        this.currentStudent = new Student(name);
        this.currentQuiz = generateQuiz(topic, difficulty);
        this.currentQuestionIndex = 0;

        loadQuestionUI();
        cardLayout.show(cardPanel, "QUIZ");
    }

    // Soru UI ını yükler
    private void loadQuestionUI() {
        if (currentQuestionIndex >= currentQuiz.getQuestions().size()) {
            showResults();
            return;
        }

        Question q = currentQuiz.getQuestions().get(currentQuestionIndex);
        questionLabel.setText("<html>Question " + (currentQuestionIndex + 1) + "/10: <br><br><br>" + q.getText() + "</html>");

        optionsPanel.removeAll();
        optionsGroup = new ButtonGroup();

        if (q instanceof MultipleChoiceQuestion) {
            String[] opts = ((MultipleChoiceQuestion) q).getOptions();
            for (String opt : opts) {
                JRadioButton rb = new JRadioButton(opt);
                rb.setActionCommand(opt);
                optionsGroup.add(rb);
                optionsPanel.add(rb);
            }
        } else if (q instanceof TrueFalseQuestion) {
            JRadioButton trueBtn = new JRadioButton("True");
            trueBtn.setActionCommand("True");
            JRadioButton falseBtn = new JRadioButton("False");
            falseBtn.setActionCommand("False");

            optionsGroup.add(trueBtn);
            optionsGroup.add(falseBtn);
            optionsPanel.add(trueBtn);
            optionsPanel.add(falseBtn);
        }

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    private void startCountdown() {
        timeLeft = 180;
        updateTimerDisplay();

        if (quizTimer != null && quizTimer.isRunning()) {
            quizTimer.stop();
        }

        quizTimer = new Timer(1000, e -> {
            timeLeft--;
            if (timeLeft <= 0) {
                quizTimer.stop();
                JOptionPane.showMessageDialog(this, "Time is up!");
                showResults();
            } else {
                updateTimerDisplay();
            }
        });
        quizTimer.start();
    }

    private void updateTimerDisplay() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }

    private void handleNextQuestion() {
        if (optionsGroup == null) {
            JOptionPane.showMessageDialog(this, "Couldn't upload the questions.");
            return;
        }


        if (optionsGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please mark an answer");
            return;
        }

        String answer = optionsGroup.getSelection().getActionCommand();
        currentQuiz.getQuestions().get(currentQuestionIndex).answer(answer);

        currentQuestionIndex++;
        loadQuestionUI();
    }

    /**
     * Displays the final score and a list of incorrectly answered questions.
     */
    private void showResults() {
        JPanel resultPanel = new JPanel(new BorderLayout());


        // Result Header
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        header.setBackground(Color.DARK_GRAY);

        JLabel scoreLabel = new JLabel("Score: " + currentQuiz.calculateScore() + " / 10");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel nameLabel = new JLabel("Student: " + currentStudent.getName());
        nameLabel.setForeground(Color.LIGHT_GRAY);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(scoreLabel);
        header.add(nameLabel);
        resultPanel.add(header, BorderLayout.NORTH);

        // Incorrect Questions List
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Question q : currentQuiz.getQuestions()) {
            if (!q.checkAnswer()) {
                listModel.addElement("<html><b>Question:</b> " + q.getText() +
                        "<br><b>Your Answer:</b> <font color='red'>" +
                        (q.getUserAnswer() == null ? "Not Answered" : q.getUserAnswer()) +
                        "</font><br><b>Correct:</b> <font color='green'>" +
                        q.getCorrectAnswerDisplay() + "</font><br><hr></html>");
            }
        }

        if (listModel.isEmpty()) {
            listModel.addElement("Congratulations! You answered all of them correctly.");
        }

        JList<String> wrongList = new JList<>(listModel);
        wrongList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(wrongList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Your Wrong Answers"));
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Restart Button
        JButton restartBtn = new JButton("Restart");
        restartBtn.addActionListener(e -> {
            nameField.setText("");
            cardLayout.show(cardPanel, "SETUP");
        });
        resultPanel.add(restartBtn, BorderLayout.SOUTH);

        cardPanel.add(resultPanel, "RESULTS");
        cardLayout.show(cardPanel, "RESULTS");
    }

    /**
     * Generates a new Quiz object populated with randomized questions
     * based on the specified subject and difficulty level.
     * * @param topic The subject of the quiz (e.g., History, Science)
     * @param difficulty The difficulty level (e.g., Easy, Medium, Hard)
     * @return A Quiz object containing the prepared questions
     */
    private Quiz generateQuiz(String topic, String difficulty) {
        // Create a new Quiz instance to hold the selected questions
        Quiz quiz = new Quiz();

        //  Retrieve the list of questions matching the selected topic and difficulty from the QuestionBank
        java.util.List<Question> questionList = QuestionBank.getQuestionsForTopic(topic, difficulty);

        //  Randomly reorder the questions to ensure a unique experience for everytime the quiz is taken
        java.util.Collections.shuffle(questionList);

        //  Added the shuffled list of questions into the Quiz object's internal collection
        quiz.getQuestions().addAll(questionList);
        return quiz;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizAppSwing().setVisible(true);
        });
    }
}
