
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class OnlineTestTimer extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnPrevious, btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	Timer timer;

	// Time duration for each question (2 minutes = 120 seconds)
	int duration = 120;
	JLabel timerLabel;

	OnlineTestTimer(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnPrevious = new JButton("Previous");
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnPrevious);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnPrevious.setBounds(50, 240, 100, 30);
		btnNext.setBounds(200, 240, 100, 30);
		btnBookmark.setBounds(350, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);

		// Timer label setup
		timerLabel = new JLabel("Time left: " + formatTime(duration));
		timerLabel.setBounds(450, 20, 150, 30);
		add(timerLabel);

		// Timer setup
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				duration--;
				if (duration >= 0) {
					timerLabel.setText("Time left: " + formatTime(duration));
				} else {
					timer.stop();
					JOptionPane.showMessageDialog(OnlineTestTimer.this, "Time's up for this question!");
					current++;
					set();
				}
			}
		});
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrevious) {
			if (check())
				count = count - 1;
			current--;
			set();
			if (current == 0) {
				btnPrevious.setText("Result");
			}
		}
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Correct answers= " + count);
			System.exit(0);
		}

		// Reset the timer for each question
		duration = 120;
		timerLabel.setText("Time left: " + formatTime(duration));
		timer.restart();
	}

	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: What is Collection in Java?");
			radioButton[0].setText("A group of objects");
			radioButton[1].setText("A group of classes");
			radioButton[2].setText("A group of interfaces");
			radioButton[3].setText("None of the above");
		}
		if (current == 1) {
			label.setText("Que2:  Which keyword is used by the method to refer to the object that invoked it?");
			radioButton[0].setText("import");
			radioButton[1].setText("catch");
			radioButton[2].setText("abstract");
			radioButton[3].setText("this");
		}
		if (current == 2) {
			label.setText("Que3: Which is faster and uses less memory?");
			radioButton[0].setText("ListEnumeration");
			radioButton[1].setText("Iterator");
			radioButton[2].setText("Enumeration");
			radioButton[3].setText("ListIerator");
		}
		if (current == 3) {
			label.setText("Que4: The default capacity of a ArrayList is:?");
			radioButton[0].setText("12");
			radioButton[1].setText("16");
			radioButton[2].setText("1");
			radioButton[3].setText("10");
		}
		if (current == 4) {
			label.setText("Que5:  Which interface does not allow duplicates elements?");
			radioButton[0].setText(" Set");
			radioButton[1].setText("List");
			radioButton[2].setText("Map");
			radioButton[3].setText("All the ans are true");
		}
		if (current == 5) {
			label.setText("Que6: Which of these classes is a super class of all Exception classes?");
			radioButton[0].setText("RuntimeExceptions");
			radioButton[1].setText("String");
			radioButton[2].setText("throwable");
			radioButton[3].setText("Cachable");
		}
		if (current == 6) {
			label.setText("Que7:  Which block is always executed, regardless of the exception thrown?");
			radioButton[0].setText("throws");
			radioButton[1].setText("finally");
			radioButton[2].setText("catch");
			radioButton[3].setText("throw");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following method is used to get the length of a String object?");
			radioButton[0].setText("getSize()");
			radioButton[1].setText("Sizeof()");
			radioButton[2].setText("len()");
			radioButton[3].setText("length()");
		}
		if (current == 8) {
			label.setText("Que9: Which data type(s) can store 64 bit value?");
			radioButton[0].setText("boolean");
			radioButton[1].setText("int");
			radioButton[2].setText("long");
			radioButton[3].setText("short");
		}
		if (current == 9) {
			label.setText("Que10: What component is used to compile, debug, and run a java program?");
			radioButton[0].setText("JVM");
			radioButton[1].setText("JDK");
			radioButton[2].setText("JIT");
			radioButton[3].setText("JRE");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	// Helper method to format time in mm:ss format
	private String formatTime(int seconds) {
		int min = seconds / 60;
		int sec = seconds % 60;
		return String.format("%02d:%02d", min, sec);
	}

	public static void main(String s[]) {
		new OnlineTestTimer("Online Test App");
	}
}