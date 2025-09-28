
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class OnlineTestApp extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    JLabel questionLabel, timerLabel;
    JRadioButton[] options;
    JButton nextButton, addButton, submitButton;
    ButtonGroup bg;
    JMenuBar menuBar;
    JMenu fileMenu, helpMenu;
    JMenuItem resetMenuItem, exitMenuItem, aboutMenuItem;
    JPopupMenu popupMenu;
    JScrollPane scrollPane;
    JTextArea questionTextArea;
    JTextField option1Field, option2Field, option3Field, option4Field;
    JDialog addQuestionDialog;
    Timer timer;
    int duration = 120;
    int currentQuestion = 0;
    int correctAnswers = 0;

    // Questions and Answers
    String[] questions = { "What is the capital of France?", "What is the largest planet in our solar system?",
            "Who wrote 'To Kill a Mockingbird'?" };
    String[][] optionsData = { { "Paris", "London", "Rome", "Berlin" }, { "Earth", "Mars", "Jupiter", "Saturn" },
            { "Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald" } };
    int[] correctAnswersIndex = { 0, 2, 0 };

    OnlineTestApp(String title) {
        super(title);

        // Set layout
        setLayout(new BorderLayout());

        // MenuBar and Menus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        // MenuItems
        resetMenuItem = new JMenuItem("Reset");
        exitMenuItem = new JMenuItem("Exit");
        aboutMenuItem = new JMenuItem("About");
        resetMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);

        fileMenu.add(resetMenuItem);
        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // PopupMenu
        popupMenu = new JPopupMenu();
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        popupMenu.add(cutMenuItem);
        popupMenu.add(copyMenuItem);
        popupMenu.add(pasteMenuItem);

        // Question Label
        questionLabel = new JLabel("Question", JLabel.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // Options
        options = new JRadioButton[4];
        bg = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            optionsPanel.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        // Timer Label
        timerLabel = new JLabel("Time left: " + formatTime(duration));
        add(timerLabel, BorderLayout.SOUTH);

        // Buttons
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        addButton = new JButton("Add Question");
        addButton.addActionListener(this);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(nextButton);
        buttonPanel.add(addButton);
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Timer setup
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                duration--;
                if (duration >= 0) {
                    timerLabel.setText("Time left: " + formatTime(duration));
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(OnlineTestApp.this, "Time's up! Moving to next question.");
                    nextQuestion();
                }
            }
        });

        // Add Question Dialog
        addQuestionDialog = new JDialog(this, "Add Question", true);
        addQuestionDialog.setSize(400, 300);
        addQuestionDialog.setLayout(new GridLayout(6, 2));
        addQuestionDialog.add(new JLabel("Question:"));
        questionTextArea = new JTextArea(2, 20);
        scrollPane = new JScrollPane(questionTextArea);
        addQuestionDialog.add(scrollPane);
        addQuestionDialog.add(new JLabel("Option 1:"));
        option1Field = new JTextField();
        addQuestionDialog.add(option1Field);
        addQuestionDialog.add(new JLabel("Option 2:"));
        option2Field = new JTextField();
        addQuestionDialog.add(option2Field);
        addQuestionDialog.add(new JLabel("Option 3:"));
        option3Field = new JTextField();
        addQuestionDialog.add(option3Field);
        addQuestionDialog.add(new JLabel("Option 4:"));
        option4Field = new JTextField();
        addQuestionDialog.add(option4Field);
        JButton addQuestionButton = new JButton("Add");
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewQuestion();
            }
        });
        addQuestionDialog.add(addQuestionButton);

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        showQuestion();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (checkAnswer()) {
                correctAnswers++;
            }
            nextQuestion();
        } else if (e.getSource() == addButton) {
            addQuestionDialog.setVisible(true);
        } else if (e.getSource() == submitButton) {
            if (checkAnswer()) {
                correctAnswers++;
            }
            endTest();
        } else if (e.getSource() == resetMenuItem) {
            resetTest();
        } else if (e.getSource() == exitMenuItem) {
            System.exit(0);
        } else if (e.getSource() == aboutMenuItem) {
            JOptionPane.showMessageDialog(this, "Online Test Application\nVersion 1.0");
        }
    }

    private void showQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(optionsData[currentQuestion][i]);
            }
            bg.clearSelection();
        } else {
            endTest();
        }
    }

    private void nextQuestion() {
        currentQuestion++;
        if (currentQuestion < questions.length) {
            duration = 120;
            timerLabel.setText("Time left: " + formatTime(duration));
            showQuestion();
            timer.restart();
        } else {
            endTest();
        }
    }

    private void addNewQuestion() {
        String question = questionTextArea.getText();
        String option1 = option1Field.getText();
        String option2 = option2Field.getText();
        String option3 = option3Field.getText();
        String option4 = option4Field.getText();

        if (!question.isEmpty() && !option1.isEmpty() && !option2.isEmpty() && !option3.isEmpty()
                && !option4.isEmpty()) {
            questions = addElement(questions, question);
            optionsData = addElement(optionsData, new String[] { option1, option2, option3, option4 });
            correctAnswersIndex = addElement(correctAnswersIndex, 0); // default correct answer to the first option
            addQuestionDialog.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
    }

    private boolean checkAnswer() {
        return options[correctAnswersIndex[currentQuestion]].isSelected();
    }

    private void endTest() {
        timer.stop();
        JOptionPane.showMessageDialog(this,
                "Test Completed. Correct answers: " + correctAnswers + "/" + questions.length);
    }

    private void resetTest() {
        timer.stop();
        currentQuestion = 0;
        correctAnswers = 0;
        duration = 120;
        timerLabel.setText("Time left: " + formatTime(duration));
        showQuestion();
        timer.restart();
    }

    private String[] addElement(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private String[][] addElement(String[][] array, String[] element) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private String formatTime(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineTestApp("Online Test Application");
            }
        });
    }
}
