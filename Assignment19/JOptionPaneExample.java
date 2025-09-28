//Program 8: Program to display the message using JOptionPane.

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneExample {
    JFrame jframe;

    JOptionPaneExample() {
        jframe = new JFrame();
        JOptionPane.showMessageDialog(jframe, "Welcome JAVA World...");
    }

    public static void main(String[] args) {
        new JOptionPaneExample();
    }
}