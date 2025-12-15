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
        }
        else if (topic.equals("Science") && difficulty.equals("Medium")) {
            questions.add(new MultipleChoiceQuestion(
                    "What is the powerhouse of the cell?",
                    new String[]{"Nucleus", "Mitochondria", "Ribosome", "Endoplasmic Reticulum"},
                    "Mitochondria"
            ));
            questions.add(new TrueFalseQuestion(
                    "Heat always flows from a warmer object to a cooler one.",
                    true
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What is the second law of thermodynamics about?",
                    new String[]{"Energy conservation", "Entropy increase", "Force and motion", "Quantum states"},
                    "Entropy increase"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What carries oxygen in the blood?",
                    new String[]{"White blood cells","Red blood cells","Platelets", "Plasma"},
                    "Red blood cells"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What happens to light when it passes from air into water?",
                    new String[]{"It speeds up","It stops","It bends","It becomes invisible"},
                    "It bends"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "When large areas of forest are removed so land can be converted for other uses, such as farming, which of the following occurs?",
                    new String[]{"Increased erosion","Colder temperature","Decreased carbon dioxide","Greater oxygen production"},
                    "Increased erosion"
            ));
            questions.add(new TrueFalseQuestion(
                    "The Earth’s magnetic field is created only by the Sun’s gravity.",
                    false
            ));
            questions.add(new TrueFalseQuestion(
                    "In a food chain, energy increases as it moves up each trophic level.",
                    false
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which gas is the most abundant in Earth’s atmosphere?",
                    new String[]{"Nitrogen","Oxygen","Carbon dioxide","Hydrogen"},
                    "Nitrogen"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What is the main cause of seasons on the Earth?",
                    new String[]{"The tilt of the Earth’s axis in relation to the sun","The distance between the Earth and the sun","The speed that the Earth rotates around the sun","Changes in the amount of energy coming from the sun"},
                    "The tilt of the Earth’s axis in relation to the sun"
            ));

        }
        else if (topic.equals("Science") && difficulty.equals("Hard")) {
                        //ZOR SCIENCE SORULARI
            questions.add(new MultipleChoiceQuestion(
                    //1.soru
                    "What is the Heisenberg Uncertainty Principle?",
                    new String[]{"It states that energy cannot be created or destroyed", "It states that the position and momentum of a particle cannot both be precisely determined at the same time", "It states that for every action, there is an equal and opposite reaction", "It states that light behaves both as a wave and a particle"},
                    "It states that the position and momentum of a particle cannot both be precisely determined at the same time"
            ));
            questions.add(new MultipleChoiceQuestion(
                    //2.Soru
                    "Which particle is responsible for mediating the strong nuclear force?",
                    new String[]{"Photon", "Gluon", "W boson", "Z boson"},
                    "Gluon"
            ));
            questions.add(new TrueFalseQuestion(
                    //3.soru
                    "In quantum mechanics, particles can exist in multiple states simultaneously until measured.",
                    true
            ));
            questions.add(new MultipleChoiceQuestion(
                    //4.soru
                    "Which layer of Earth’s atmosphere contains the ozone layer?",
                    new String[]{"Troposphere", "Stratosphere", "Mesosphere", "Thermosphere"},
                    "Stratosphere"
            ));
            questions.add(new MultipleChoiceQuestion(
                    //5.soru
                    "What phenomenon occurs when a wave changes frequency due to the relative motion of the observer and the source?",
                    new String[]{"Diffraction", "Interference", "Dispersion", "Doppler Effect"},
                    "Doppler Effect"
            ));
            questions.add(new TrueFalseQuestion(
                    //6.soru
                    "Natural selection always leads to organisms becoming more complex over time.",
                    false
            ));
            questions.add(new TrueFalseQuestion(
                    //7.soru
                    "An object moving in a circle at constant speed has zero acceleration.",
                    false
            ));
            questions.add(new MultipleChoiceQuestion(
                    //8.soru
                    "Which phase of the cell cycle is primarily responsible for DNA repair before mitosis?",
                    new String[]{"G₁ phase", "G₂ phase", "S phase", "M phase"},
                    "G₂ phase"
            ));
            questions.add(new MultipleChoiceQuestion(
                    //9.soru
                    "Which phenomenon proves the particle nature of light?",
                    new String[]{"Diffraction", "Interference", "Photoelectric effect", "Refraction"},
                    "Photoelectric effect"
            ));
            questions.add(new MultipleChoiceQuestion(
                    //10.soru
                    "What type of symbiosis results in one organism benefiting while the other is harmed?",
                    new String[]{"Mutualism", "Commensalism","Neutralism","Parasitism"},
                    "Parasitism"
            ));


        }
        else if (topic.equals("History") && difficulty.equals("Easy")) {
            questions.add(new MultipleChoiceQuestion(
                    "",
                    new String[]{},
                    ""
            ));
        }
        else if (topic.equals("History") && difficulty.equals("Medium")) {
            questions.add(new MultipleChoiceQuestion(
                    "",
                    new String[]{},
                    ""
            ));
        }
        else if (topic.equals("History") && difficulty.equals("Hard")) {
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
        }
        else if (topic.equals("Technology") && difficulty.equals("Easy")) {
            questions.add(new MultipleChoiceQuestion(
                    "Which of the following is an operating system?",
                    new String[]{"Java", "Python", "Windows", "HTML"},
                    "Windows"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What does “CPU” stand for?",
                    new String[]{"Central Processing Unit","Computer Power Unit", "Core Programming Utility", "Central Programming Unit"},
                    "Central Processing Unit"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which of these is an example of artificial intelligence?",
                    new String[]{"A calculator", "A light switch", "Voice assistants like Siri", "A regular keybord"},
                    "Voice assistants like Siri"
            ));
            questions.add(new TrueFalseQuestion(
                    "RAM stores data permanently, even when the computer is turned off.",
                    false
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What type of technology is used to scan your fingerprint on phones?",
                    new String[]{"Infrared","Biometric sensor", "Magnetic reader","Laser pointer"},
                    "Biometric sensor"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What does a compiler do?",
                    new String[]{"Draws graphics","Deletes unused files","Converts source code into machine code","Runs the internet"},
                    "Converts source code into machine code"
            ));
            questions.add(new TrueFalseQuestion(
                    "Cloud storage allows users to access their files from any device with internet access.",
                    true

            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which of the following is used for version control?\n",
                    new String[]{"Git","Usb","Java","Router"},
                    "Git"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Html is mainly used for...",
                    new String[]{"Creating websites","Editing videos","Designing mobile apps","Machine learning"},
                    "Creating websites"
            ));
            questions.add(new TrueFalseQuestion(
                    "Bluetooth is mainly used for long-distance communication over several kilometers.",
                    false
            ));
        } else if (topic.equals("Technology")&& difficulty.equals("Medium")) {
            questions.add(new MultipleChoiceQuestion(
                    "What is the core part of an operating system that manages system resources and acts as the interface between hardware and software?",
                    new String[]{"Graphical User Interface (GUI)","Device Drive","System Utility","Kernel"},
                    "Kernel"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Compared to a traditional Hard Disk Drive (HDD), what is the main performance advantage of a Solid State Drive (SSD)?",
                    new String[]{"Higher physical capacity in the same size factor","Significantly lower cost per gigabyte","Faster data access speeds due to no moving mechanical parts","Longer lifespan in terms of total write cycles"},
                    "Faster data access speeds due to no moving mechanical parts"
            ));
            questions.add(new TrueFalseQuestion(
                    "The CPU's clock speed is measured in Hertz (Hz) and determines how many instruction cycles the CPU can execute per second.",
                    true
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What is the primary benefit of using 'threads' instead of separate 'processes' in a modern operating system?",
                    new String[]{"Shared memory space and reduced context switching overhead","Easier debugging for developers","Complete memory isolation between tasks","Guaranteed real-time execution"},
                    "Shared memory space and reduced context switching overhead"
            ));
            questions.add(new TrueFalseQuestion(
                    "In a relational database, a foreign key is used to uniquely identify each record in the table.",
                    false
            ));
            questions.add(new MultipleChoiceQuestion(
                    "In C/C++ programming, what memory area is generally used for dynamic memory allocation (e.g., memory requested by the programmer using 'malloc' or 'new')?",
                    new String[]{"The Stack","The Data Segment","The Code Segment","The Heap"},
                    "The Heap"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which of the following protocols is connection-oriented and guarantees the delivery of data packets by retransmitting lost or corrupted data?",
                    new String[]{"User Datagram Protocol (UDP)","Transmission Control Protocol (TCP)","Address Resolution Protocol","Internet Control Message Protocol (ICMP)"},
                    "Transmission Control Protocol (TCP)"
            ));
            questions.add(new TrueFalseQuestion(
                    "A Graphics Processing Unit (GPU) is solely dedicated to rendering visuals and cannot be used for general-purpose parallel computing tasks.",
                    false
            ));
            questions.add(new MultipleChoiceQuestion(
                    "Which of the following best describes the relationship between a Class and an Object in OOP?",
                    new String[]{"An Object is a blueprint for a Class","They are interchangeable terms and mean the same thing","A Class is an instance of an Object","A Class is a blueprint (template) from which Objects (instances) are created"},
                    "A Class is a blueprint (template) from which Objects (instances) are created"
            ));
            questions.add(new MultipleChoiceQuestion(
                    "What term describes the situation where a machine learning model performs exceptionally well on the training data but performs poorly on the unseen test data?",
                    new String[]{"Underfitting","Bias","Overfitting","Variance"},
                    "Overfitting"
            ));

        }


        return questions;
    }
}