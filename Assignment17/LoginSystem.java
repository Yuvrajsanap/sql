
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginSystem() {
        setTitle("Login System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel for holding components
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBackground(Color.LIGHT_GRAY);

        // Username label and text field
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        usernamePanel.add(usernameField);

        // Password label and password field
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);

        // Message label for displaying login status
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setForeground(Color.RED);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new LoginButtonListener());

        // Add all panels to the main panel
        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(loginButton);
        panel.add(messageLabel);

        // Add the main panel to the frame
        add(panel);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // For demonstration purposes, we'll use a simple check.
            // In a real application, you would check the username and password
            // against a database or other secure storage.
            if (username.equals("admin") && password.equals("password")) {
                messageLabel.setText("Login successful!");
                messageLabel.setForeground(Color.GREEN);
            } else {
                messageLabel.setText("Invalid username or password.");
                messageLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginSystem app = new LoginSystem();
                app.setVisible(true);
            }
        });
    }
}
