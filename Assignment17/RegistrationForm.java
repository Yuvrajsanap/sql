
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationForm extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField nameField;
    private JLabel email;
    private JTextField emailField;
    private JLabel password;
    private JPasswordField passwordField;
    private JLabel confirmPassword;
    private JPasswordField confirmPasswordField;
    private JButton submit;
    private JButton reset;
    private JLabel result;

    // constructor, to initialize the components
    // with default values.
    public RegistrationForm() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        container.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        container.add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(190, 20);
        nameField.setLocation(200, 100);
        container.add(nameField);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 150);
        container.add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setSize(190, 20);
        emailField.setLocation(200, 150);
        container.add(emailField);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 200);
        container.add(password);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(190, 20);
        passwordField.setLocation(200, 200);
        container.add(passwordField);

        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmPassword.setSize(200, 20);
        confirmPassword.setLocation(100, 250);
        container.add(confirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        confirmPasswordField.setSize(190, 20);
        confirmPasswordField.setLocation(300, 250);
        container.add(confirmPasswordField);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(150, 400);
        submit.addActionListener(this);
        container.add(submit);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 400);
        reset.addActionListener(this);
        container.add(reset);

        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(500, 25);
        result.setLocation(100, 450);
        container.add(result);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String nameText = nameField.getText();
            String emailText = emailField.getText();
            String passwordText = new String(passwordField.getPassword());
            String confirmPasswordText = new String(confirmPasswordField.getPassword());

            if (passwordText.equals(confirmPasswordText)) {
                result.setText("Registration Successful!");
            } else {
                result.setText("Passwords do not match!");
            }
        } else if (e.getSource() == reset) {
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
