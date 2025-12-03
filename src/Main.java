import java.util.ArrayList;
import java.util.List;



interface Gradable {
    int calculateScore();
}

abstract class Question {
    protected String text;
    protected String userAnswer;
    protected String difficulty;
    public Question(String text) {
        this.text = text;
        this.userAnswer = null;
    }

    public String getText() { return text; }
    public String getUserAnswer() { return userAnswer; }
    public String getDifficulty() { return difficulty; }
    public void answer(String answer) { this.userAnswer = answer; }

    public abstract boolean checkAnswer();
    public abstract String getCorrectAnswerDisplay();
}

class MultipleChoiceQuestion extends Question {
    private String[] options;
    private String correctAnswer;

    public MultipleChoiceQuestion(String text, String[] options, String correctAnswer) {
        super(text);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String[] getOptions() { return options; }

    @Override
    public boolean checkAnswer() {
        return correctAnswer.equals(userAnswer);
    }

    @Override
    public String getCorrectAnswerDisplay() {
        return correctAnswer;
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String text, boolean correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer() {
        if (userAnswer == null) return false;
        boolean userBool = userAnswer.equalsIgnoreCase("True");
        return userBool == correctAnswer;
    }

    @Override
    public String getCorrectAnswerDisplay() {
        return correctAnswer ? "True" : "False";
    }
}

class Quiz implements Gradable {
    private List<Question> questions = new ArrayList<>();
    private String topic;
    private String difficulty;

    public Quiz(String topic, String difficulty) {
        this.topic = topic;
        this.difficulty = difficulty;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }
    public String getDifficulty() {
        return difficulty;
    }

    @Override //sko
    public int calculateScore() {
        int score = 0;
        for (Question q : questions) {
            if (q.checkAnswer()) score++;
        }
        return score;
    }

}



