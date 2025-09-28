
//2
//Program for JLabel.
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelExample {
    public static void main(String[] args) {
        // Create a new JFrame with a title
        JFrame jframe = new JFrame("JLabel Example");

        // Create JLabels
        JLabel jlabel1 = new JLabel("My First Label.");
        JLabel jlabel2 = new JLabel("My Second Label.");

        // Set positions of the labels
        jlabel1.setBounds(50, 100, 150, 40);
        jlabel2.setBounds(50, 150, 150, 40);

        // Add JLabels to JFrame
        jframe.add(jlabel1);
        jframe.add(jlabel2);

        // Set JFrame properties
        jframe.setSize(480, 300);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}