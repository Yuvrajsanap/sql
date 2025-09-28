import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextFieldExample {
    public static void main(String[] args) {
        // Create a new JFrame with a title
        JFrame jframe = new JFrame("JTextField Example");

        // Create JTextFields
        JTextField jtextfield1 = new JTextField("Welcome to JAVA.");
        JTextField jtextfield2 = new JTextField("Welcome to Swing.");

        // Set positions of the text fields
        jtextfield1.setBounds(58, 100, 200, 30);
        jtextfield2.setBounds(58, 150, 200, 30);

        // Add JTextFields to JFrame
        jframe.add(jtextfield1);
        jframe.add(jtextfield2);

        // Set JFrame properties
        jframe.setSize(400, 400);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}