//Program for Frame 1

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameExample

{

    public static void main(String s[])

    {

        JFrame jframe = new JFrame("Example of JFrame");

        JPanel jpanel = new JPanel();

        jpanel.setLayout(new FlowLayout());

        JLabel jlabel = new JLabel("First JFrame Example");

        JButton jbutton = new JButton();

        jbutton.setText(" Click Me ");

        jpanel.add(jlabel);

        jpanel.add(jbutton);

        jframe.add(jpanel);

        jframe.setSize(400, 300);

        jframe.setLocationRelativeTo(null);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setVisible(true);

    }

}