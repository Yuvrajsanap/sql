import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class RegistrationForm11 extends JFrame {
    private static final long serialVersionUID = 1L;

    // Form components
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> genderComboBox;
    private JToggleButton termsToggle;
    private JButton nextPageButton, registerButton;
    private JTextArea addressArea;
    private JScrollPane addressScrollPane;
    private JLabel imageLabel;

    // Menu components
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem openMenuItem, saveMenuItem, exitMenuItem, colorMenuItem;
    private JPopupMenu popupMenu;

    public RegistrationForm11() {
        // Setting up the frame
        setTitle("Registration Form");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Form panel
        final JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Custom font
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        // Name
        addLabelAndField(formPanel, "Name:", nameField = new JTextField(), labelFont, fieldFont);

        // Email
        addLabelAndField(formPanel, "Email:", emailField = new JTextField(), labelFont, fieldFont);

        // Password
        addLabelAndField(formPanel, "Password:", passwordField = new JPasswordField(), labelFont, fieldFont);

        // Gender
        addLabelAndField(formPanel, "Gender:",
                genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "Other" }), labelFont, fieldFont);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        formPanel.add(addressLabel);
        addressArea = new JTextArea(5, 20);
        addressArea.setFont(fieldFont);
        addressScrollPane = new JScrollPane(addressArea);
        formPanel.add(addressScrollPane);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Terms and conditions
        termsToggle = new JToggleButton("Accept Terms");
        termsToggle.setFont(fieldFont);
        formPanel.add(termsToggle);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Next Page button
        nextPageButton = new JButton("Next Page");
        nextPageButton.setFont(fieldFont);
        formPanel.add(nextPageButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Register button
        registerButton = new JButton("Register");
        registerButton.setFont(fieldFont);
        formPanel.add(registerButton);

        add(formPanel, BorderLayout.CENTER);

        // Menu bar
        menuBar = new JMenuBar();

        // File menu
        fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Edit menu
        editMenu = new JMenu("Edit");
        colorMenuItem = new JMenuItem("Choose Color");
        editMenu.add(colorMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Popup menu
        popupMenu = new JPopupMenu();
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        addressArea.setComponentPopupMenu(popupMenu);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.SOUTH);

        // Action listeners
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go to the next page
                NextPage nextPage = new NextPage();
                nextPage.setVisible(true);
                RegistrationForm11.this.dispose(); // Close the current form
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print data to the console
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String gender = (String) genderComboBox.getSelectedItem();
                String address = addressArea.getText();
                boolean acceptedTerms = termsToggle.isSelected();

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Gender: " + gender);
                System.out.println("Address: " + address);
                System.out.println("Accepted Terms: " + acceptedTerms);

                JOptionPane.showMessageDialog(RegistrationForm11.this, "Data printed to console.");
            }
        });

        colorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(RegistrationForm11.this, "Choose a color", Color.WHITE);
                if (color != null) {
                    formPanel.setBackground(color);
                }
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(RegistrationForm11.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Image image = ImageIO.read(selectedFile);
                        if (image != null) {
                            imageLabel.setIcon(new ImageIcon(image));
                            setTitle(selectedFile.getName());
                        } else {
                            JOptionPane.showMessageDialog(RegistrationForm11.this,
                                    "The selected file is not a valid image.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(RegistrationForm11.this,
                                "Error opening image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(RegistrationForm11.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(RegistrationForm11.this,
                            "Saved: " + fileChooser.getSelectedFile().getName());
                }
            }
        });
    }

    private void addLabelAndField(JPanel panel, String labelText, JComponent field, Font labelFont, Font fieldFont) {
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        panel.add(label);
        field.setFont(fieldFont);
        panel.add(field);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm11().setVisible(true);
            }
        });
    }
}

class NextPage extends JFrame {
    private static final long serialVersionUID = 1L;

    public NextPage() {
        setTitle("Next Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Welcome to the next page!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the registration form
                RegistrationForm11 registrationForm = new RegistrationForm11();
                registrationForm.setVisible(true);
                NextPage.this.dispose(); // Close the current page
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
    }
}
