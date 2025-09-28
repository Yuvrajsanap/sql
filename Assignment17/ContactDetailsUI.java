
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ContactDetailsUI extends JFrame {

	private JTextField nameField, emailField, phoneField;
	private JTextArea addressArea;

	public ContactDetailsUI() {
		setTitle("Contact Details");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameField = new JTextField(20);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(JLabel.RIGHT);
		emailField = new JTextField(20);

		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneField = new JTextField(20);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setHorizontalAlignment(JLabel.RIGHT);
		addressArea = new JTextArea(4, 20);
		JScrollPane addressScrollPane = new JScrollPane(addressArea);

		mainPanel.add(nameLabel);
		mainPanel.add(nameField);
		mainPanel.add(emailLabel);
		mainPanel.add(emailField);
		mainPanel.add(phoneLabel);
		mainPanel.add(phoneField);
		mainPanel.add(addressLabel);
		mainPanel.add(addressScrollPane);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveContact();
			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(saveButton);
		buttonPanel.add(clearButton);

		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	private void saveContact() {
		String name = nameField.getText().trim();
		String email = emailField.getText().trim();
		String phone = phoneField.getText().trim();
		String address = addressArea.getText().trim();

		// For demonstration purposes, just print the entered details
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		System.out.println("Address: " + address);

		// You can add your saving logic here (e.g., save to a database)
		JOptionPane.showMessageDialog(this, "Contact Details Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	private void clearFields() {
		nameField.setText("");
		emailField.setText("");
		phoneField.setText("");
		addressArea.setText("");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ContactDetailsUI contactDetailsUI = new ContactDetailsUI();
				contactDetailsUI.setVisible(true);
			}
		});
	}
}
