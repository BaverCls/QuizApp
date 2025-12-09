// File: src/QuestionBank.java
import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    public static List<Question> getQuestionsForTopic(String topic, String difficulty) {
        List<Question> questions = new ArrayList<>();

        //SCIENCE SORULARI
        if (topic.equals("Science") && difficulty.equals("Easy")) {
            questions.add(new MultipleChoiceQuestion(
                    "What is the chemical formula for water?",
                    new String[]{"CO2", "H2O", "NaCl", "O2"},
                    "H2O"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which is the largest planet in the solar system?",
                    new String[]{"Mars", "Earth", "Jupiter", "Saturn"},
                    "Jupiter"
            ));
            questions.add(new TrueFalseQuestion(
                    "Light travels faster than sound.",
                    true
            ));

            questions.add(new MultipleChoiceQuestion(
                    "Which organ pumps blood through the human body?",
                    new String[]{"Brain", "Lungs", "Heart", "Kidney"},
                    "Heart"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which scientist proposed the theory of relativity?",
                    new String[]{"Isaac Newton", "Albert Einstein", "Nikola Tesla", "Marie Curie"},
                    "Albert Einstein"
            ));

            questions.add(new TrueFalseQuestion(
                    "Whale is a mammal",
                    true
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What is the closest star to Earth?",
                    new String[]{"Alpha Centauri", "Polaris", "Sirius", "The Sun"},
                    "The Sun"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What tool is used to measure temperature?",
                    new String[]{"Thermometer", "Ruler", "Compass", "Stopwatch"},
                    "Thermometer"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Oil, natural gas and coal are examples of …",
                    new String[]{"Geothermal resources", "Biofuels", "Renewable resources", "Fossil fuels"},
                    "Fossil fuels"
            ));
            questions.add(new TrueFalseQuestion(
                    "The boiling point of water at standard atmospheric pressure is 0 Kelvin.",
                    false
            ));
        } else if (topic.equals("History") && difficulty.equals("Hard")) {
            questions.add(new MultipleChoiceQuestion(
                    "What were the main causes of the Crusades?",
                    new String[]{"Desire to spread Islamic teachings", "Competition between European merchants", "Religious motivations and control of the Holy Land", "Fear of Viking invasions"},
                    "Religious motivations and control of the Holy Land"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which ancient civilization built Machu Picchu?",
                    new String[]{"Aztecs", "Mayans", "Greeks", "Incas"},
                    "Incas"
            ));
            questions.add(new TrueFalseQuestion(
                    "The Renaissance began in Italy during the 14th century.",
                    true
            ));
        } else if (topic.equals("Technology")) {
            questions.add(new MultipleChoiceQuestion(
                    "Which of the following is an operating system?",
                    new String[]{"Java", "Python", "Windows", "HTML"},
                    "Windows"
            ));
        }

        return questions;
    }
}