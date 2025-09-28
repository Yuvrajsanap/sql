
//6
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class JMenuExample {
    JMenu jmenu, jsubmenu;
    JMenuItem i1, i2, i3, i4, i5;

    JMenuExample() {
        JFrame jFrame = new JFrame("Example of Menu");

        JMenuBar jMenuBar = new JMenuBar();

        jmenu = new JMenu("Menu");

        jsubmenu = new JMenu("Sub Menu");

        i1 = new JMenuItem("File");
        i2 = new JMenuItem("Edit");
        i3 = new JMenuItem("Format");
        i4 = new JMenuItem("New");
        i5 = new JMenuItem("Open");

        jmenu.add(i1);
        jmenu.add(i2);
        jmenu.add(i3);

        jsubmenu.add(i4);
        jsubmenu.add(i5);

        jmenu.add(jsubmenu);

        jMenuBar.add(jmenu);

        jFrame.setJMenuBar(jMenuBar);

        jFrame.setSize(400, 400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public static void main(String args[]) {
        new JMenuExample();
    }
}