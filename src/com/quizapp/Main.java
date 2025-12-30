package com.quizapp;

import com.quizapp.ui.QuizAppSwing; //Swingi çekiyoruz
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new QuizAppSwing().setVisible(true);
        });
    }
}



