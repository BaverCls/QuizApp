
# 🎓 Quiz Application - OOP Final Project

A robust, console-based Java application designed to simulate a professional quiz environment. This project emphasizes **Object-Oriented Programming (OOP)** principles, strict input validation, and real-time session management.

---

## 🚀 Key Features

* **Temporal Control:** Integrated 3-minute (180s) countdown timer that automatically terminates the session upon expiration.
* **Dynamic Question Delivery:** Uses `Collections.shuffle()` to ensure every quiz session provides a unique experience.
* **Strict Input Validation:** Handles typos, invalid letter choices (A-D), and case-insensitive True/False inputs without crashing.
* **Detailed Results Review:** Provides a comprehensive summary at the end of the quiz, showing the user's answer vs. the correct solution for every missed question.
* **Data Persistence:** Loads questions from an external `questions.txt` file for easy content management.

---

## 🛠️ Technical Architecture

| Component | Description |
| --- | --- |
| **Encapsulation** | Used `private` and `protected` modifiers to secure data within models. |
| **Inheritance** | Hierarchical structure with `MultipleChoiceQuestion` and `TrueFalseQuestion` extending a base class. |
| **Polymorphism** | Runtime method binding for answer checking and display logic. |
| **Interfaces** | Implementation of `Gradable` for standardized scoring mechanisms. |

---

## 🧪 Testing & Quality Assurance

The core logic of the application is verified by a suite of **15 JUnit tests**, ensuring:

* Accurate score calculation.
* Correct question-to-topic mapping.
* Reliable data loading from external sources.

---

## 📦 Project Structure

```text
src/com/quizapp/
├── model/       # Question types and Student entities
├── service/     # QuestionBank and Logic handlers
├── ConsoleApp   # Main UI and Session Controller
└── Main         # Application entry point

```

---

## 📝 Usage

1. **Clone the repo:** `git clone https://github.com/BaverCls/QuizApp.git`
2. **Ensure `questions.txt` is in the root directory.**
3. **Run the application:** Execute the `Main.java` file.
4. **Follow the prompts:** Enter your name, select a topic, and race against the 3-minute clock!

---

**Author:** Mustafa Baver Çalış
**Course:** Object-Oriented Programming

---
