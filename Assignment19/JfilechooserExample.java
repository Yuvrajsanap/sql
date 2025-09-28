
//7
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

class JfilechooserExample extends JFrame implements ActionListener {
    static JLabel jlabel;

    // Default constructor
    JfilechooserExample() {
    }

    public static void main(String args[]) {
        // Frame to contain GUI elements
        JFrame jframe = new JFrame("File Chooser Example");
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jbutton1 = new JButton("OPEN");
        JButton jbutton2 = new JButton("SAVE");

        JfilechooserExample file1 = new JfilechooserExample();

        // Make an object of the class filechooser
        jbutton1.addActionListener(file1);
        jbutton2.addActionListener(file1);

        JPanel jpanel = new JPanel();
        jpanel.add(jbutton1);
        jpanel.add(jbutton2);

        jlabel = new JLabel("File Selected");
        jpanel.add(jlabel);

        jframe.add(jpanel);
        jframe.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String comm = ae.getActionCommand();
        if (comm.equals("SAVE")) {
            JFileChooser jfile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int ro = jfile.showSaveDialog(null);

            if (ro == JFileChooser.APPROVE_OPTION) {
                jlabel.setText(jfile.getSelectedFile().getAbsolutePath());
            } else {
                jlabel.setText("User did not select a file.");
            }
        } else if (comm.equals("OPEN")) {
            JFileChooser jfile1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int ro1 = jfile1.showOpenDialog(null);

            if (ro1 == JFileChooser.APPROVE_OPTION) {
                jlabel.setText(jfile1.getSelectedFile().getAbsolutePath());
            } else {
                jlabel.setText("User did not select a file.");
            }
        }
    }
}