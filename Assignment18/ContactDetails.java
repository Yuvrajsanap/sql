
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ContactDetails extends JFrame {

	private JTextField nameField;
	private JTextField phoneField;
	private JTextField emailField;
	private JButton submitButton;

	public ContactDetails() {
		setTitle("Contact Details Form");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Create input panel with border and padding
		JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		inputPanel.setBackground(Color.LIGHT_GRAY);

		// Set font
		Font font = new Font("Arial", Font.PLAIN, 14);

		// Add components to input panel
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(font);
		inputPanel.add(nameLabel);
		nameField = new JTextField();
		nameField.setFont(font);
		inputPanel.add(nameField);

		JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setFont(font);
		inputPanel.add(phoneLabel);
		phoneField = new JTextField();
		phoneField.setFont(font);
		inputPanel.add(phoneField);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(font);
		inputPanel.add(emailLabel);
		emailField = new JTextField();
		emailField.setFont(font);
		inputPanel.add(emailField);

		// Add submit button
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.BOLD, 14));
		submitButton.addActionListener(new SubmitButtonListener());
		inputPanel.add(submitButton);

		// Add input panel to frame
		add(inputPanel, BorderLayout.CENTER);
	}

	private class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String phoneNumber = phoneField.getText();
			String email = emailField.getText();

			if (isValidEmail(email)) {
				// Print to console
				System.out.println("Contact Details:");
				System.out.println("Name: " + name);
				System.out.println("Phone Number: " + phoneNumber);
				System.out.println("Email: " + email);

				// Show in a message dialog
				JOptionPane.showMessageDialog(ContactDetails.this,
						"Contact Details:\nName: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email);
			} else {
				JOptionPane.showMessageDialog(ContactDetails.this, "Invalid email format. Please try again.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		private boolean isValidEmail(String email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ContactDetails frame = new ContactDetails();
			frame.setVisible(true);
		});
	}
}
