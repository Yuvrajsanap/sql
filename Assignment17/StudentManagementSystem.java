
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class StudentManagementSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private String[] questions = { "What is the capital of France?", "What is 2 + 2?", "What is the square root of 16?",
            "Who wrote 'To Kill a Mockingbird'?", "What is the chemical symbol for water?" };

    private String[][] options = { { "Paris", "London", "Berlin", "Madrid" }, { "3", "4", "5", "6" },
            { "2", "3", "4", "5" }, { "Harper Lee", "Jane Austen", "Mark Twain", "J.K. Rowling" },
            { "H2O", "CO2", "NaCl", "O2" } };

    private int[] correctAnswers = { 0, 1, 2, 0, 0 }; // Index of correct answers

    private int currentQuestionIndex = 0;
    private int score = 0;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton nextButton;
    private JLabel timerLabel;
    private Timer timer;
    private int timeRemaining;

    public StudentManagementSystem() {
        setTitle("Online Test System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createQuestionPanel(), "Question");
        mainPanel.add(createResultPanel(), "Result");

        add(mainPanel);
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel welcomeLabel = new JLabel("Welcome to the Online Test", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLUE);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Test");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Question");
                startTimer();
                loadQuestion();
            }
        });
        panel.add(startButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createQuestionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setForeground(Color.BLACK);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            optionButtons[i].setBackground(Color.WHITE);
            optionButtons[i].setForeground(Color.DARK_GRAY);
            buttonGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        timerLabel = new JLabel("Time remaining: 60", JLabel.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setForeground(Color.RED);
        bottomPanel.add(timerLabel, BorderLayout.NORTH);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 18));
        nextButton.setBackground(Color.BLUE);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    loadQuestion();
                    restartTimer();
                } else {
                    cardLayout.show(mainPanel, "Result");
                    showResult();
                }
            }
        });
        bottomPanel.add(nextButton, BorderLayout.SOUTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultLabel.setForeground(Color.MAGENTA);
        panel.add(resultLabel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart Test");
        restartButton.setFont(new Font("Arial", Font.BOLD, 18));
        restartButton.setBackground(Color.ORANGE);
        restartButton.setForeground(Color.WHITE);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentQuestionIndex = 0;
                score = 0;
                cardLayout.show(mainPanel, "Welcome");
            }
        });
        panel.add(restartButton, BorderLayout.SOUTH);

        return panel;
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[currentQuestionIndex][i]);
            optionButtons[i].setSelected(false);
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected() && i == correctAnswers[currentQuestionIndex]) {
                score++;
            }
        }
    }

    private void showResult() {
        String resultText = "You scored " + score + " out of " + questions.length;
        ((JLabel) ((JPanel) mainPanel.getComponent(2)).getComponent(0)).setText(resultText);
    }

    private void startTimer() {
        timeRemaining = 60; // 60 seconds for each question
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time remaining: " + timeRemaining);
                if (timeRemaining <= 0) {
                    timer.stop();
                    nextButton.doClick();
                }
            }
        });
        timer.start();
    }

    private void restartTimer() {
        if (timer != null) {
            timer.stop();
        }
        startTimer();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentManagementSystem app = new StudentManagementSystem();
                app.setVisible(true);
            }
        });
    }
}
