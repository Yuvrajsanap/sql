
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class OnlineTestTimer extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JPanel panel;
    private JPanel questionPanel;
    private JPanel bookmarkPanel;
    private JLabel timerLabel;
    private Timer timer;
    private int duration = 120; // Total test duration in seconds
    private List<Question> questions;
    private boolean[] bookmarked; // Array to keep track of bookmarked questions
    private List<JToggleButton> bookmarkButtons;
    private List<ButtonGroup> answerGroups;

    public OnlineTestTimer(String title, List<Question> questions) {
        super(title);
        this.questions = questions;
        this.bookmarkButtons = new ArrayList<>();
        this.bookmarked = new boolean[questions.size()];
        this.answerGroups = new ArrayList<>();

        panel = new JPanel(new BorderLayout());

        // Timer label setup
        timerLabel = new JLabel("Time left: " + formatTime(duration));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(timerLabel, BorderLayout.NORTH);

        // Question and bookmark panel setup
        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        JScrollPane questionScrollPane = new JScrollPane(questionPanel);
        questionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        questionScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(questionScrollPane, BorderLayout.CENTER);

        bookmarkPanel = new JPanel();
        bookmarkPanel.setLayout(new BoxLayout(bookmarkPanel, BoxLayout.Y_AXIS));

        JScrollPane bookmarkScrollPane = new JScrollPane(bookmarkPanel);
        bookmarkScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        bookmarkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bookmarkScrollPane.setPreferredSize(new Dimension(200, getHeight())); // Fixed width for bookmark panel

        panel.add(bookmarkScrollPane, BorderLayout.EAST);

        add(panel);

        // Timer setup
        timer = new Timer(1000, e -> {
            duration--;
            if (duration >= 0) {
                timerLabel.setText("Time left: " + formatTime(duration));
            } else {
                timer.stop();
                JOptionPane.showMessageDialog(OnlineTestTimer.this, "Time's up for the entire test!");
                showResult();
            }
        });
        timer.start();

        // Add questions and options
        addQuestions();

        // Buttons setup (only Result button)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnResult = new JButton("Result");
        btnResult.addActionListener(this);
        buttonPanel.add(btnResult);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Result")) {
            showResult();
        }
    }

    private void addQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            // Question panel setup
            JPanel questionContentPanel = new JPanel();
            questionContentPanel.setLayout(new BoxLayout(questionContentPanel, BoxLayout.Y_AXIS));

            JLabel questionLabel = new JLabel(question.getQuestion());
            questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            questionContentPanel.add(questionLabel);

            ButtonGroup bg = new ButtonGroup();
            for (String option : question.getOptions()) {
                JRadioButton radioButton = new JRadioButton(option);
                radioButton.setActionCommand(option);
                radioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
                questionContentPanel.add(radioButton);
                bg.add(radioButton);
            }
            answerGroups.add(bg);

            // Bookmark button setup
            JToggleButton bookmarkButton = new JToggleButton("Bookmark");
            bookmarkButton.setActionCommand(String.valueOf(i));
            bookmarkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = Integer.parseInt(e.getActionCommand());
                    bookmarked[index] = !bookmarked[index];
                    updateBookmarkPanel();
                }
            });
            bookmarkButtons.add(bookmarkButton);
            questionContentPanel.add(bookmarkButton);

            questionPanel.add(questionContentPanel);
        }

        questionPanel.revalidate();
        questionPanel.repaint();

        updateBookmarkPanel(); // Initial update to bookmark panel
    }

    private void updateBookmarkPanel() {
        bookmarkPanel.removeAll();
        for (int i = 0; i < questions.size(); i++) {
            if (bookmarked[i]) {
                JLabel bookmarkLabel = new JLabel("Question " + (i + 1));
                bookmarkLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bookmarkPanel.add(bookmarkLabel);
            }
        }
        bookmarkPanel.revalidate();
        bookmarkPanel.repaint();
    }

    private String formatTime(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }

    private void showResult() {
        int correctAnswers = correctAnswersCount();
        new ResultPage("Test Results", correctAnswers, questions.size()).setVisible(true);
        this.dispose();
    }

    private int correctAnswersCount() {
        int correctCount = 0;
        for (int i = 0; i < questions.size(); i++) {
            ButtonGroup bg = answerGroups.get(i);
            Question question = questions.get(i);
            String selectedAnswer = bg.getSelection() != null ? bg.getSelection().getActionCommand() : "";
            if (selectedAnswer.equals(question.getOptions()[question.getCorrectOptionIndex()])) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static void main(String[] args) {
        // Example questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Que1: What is Collection in Java?", new String[] { "A group of objects",
                "A group of classes", "A group of interfaces", "None of the above" }, 0));
        questions.add(new Question("Que2: Which keyword is used by the method to refer to the object that invoked it?",
                new String[] { "import", "catch", "abstract", "this" }, 3));
        questions.add(new Question("Que3: Which of these are not a core interface of the Java Collections Framework?",
                new String[] { "List", "Set", "SortedMap", "SortedList" }, 3));
        questions.add(new Question("Que4: What is the size of boolean variable?",
                new String[] { "8 bit", "16 bit", "32 bit", "1 bit" }, 3));
        questions.add(new Question("Que5: Method Overriding is an example of?",
                new String[] { "Static Binding", "Dynamic Binding", "None", "Both" }, 1));

        SwingUtilities.invokeLater(() -> new OnlineTestTimer("Online Test App", questions));
    }
}

class ResultPage extends JFrame {
    private static final long serialVersionUID = 1L;

    public ResultPage(String title, int correctAnswersCount, int totalQuestions) {
        super(title);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel(
                "You answered " + correctAnswersCount + " out of " + totalQuestions + " correctly.");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(resultLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Close");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(e -> System.exit(0)); // Close the application on back
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public Question(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
