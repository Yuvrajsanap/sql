
//4 program on check box
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class JCheckBoxExample {

    // Constructor
    JCheckBoxExample() {
        JFrame jframe = new JFrame("My CheckBox Example");

        // Create checkboxes
        JCheckBox jcheckBox1 = new JCheckBox("C");
        jcheckBox1.setBounds(100, 100, 150, 50);

        JCheckBox jcheckBox2 = new JCheckBox("OOP");
        jcheckBox2.setBounds(100, 150, 150, 50);

        JCheckBox jcheckBox3 = new JCheckBox("Java", true);
        jcheckBox3.setBounds(100, 200, 150, 50);

        // Add checkboxes to JFrame
        jframe.add(jcheckBox1);
        jframe.add(jcheckBox2);
        jframe.add(jcheckBox3);

        // Set JFrame properties
        jframe.setSize(400, 400);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public static void main(String args[]) {
        new JCheckBoxExample();
    }
}