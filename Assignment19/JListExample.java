
//5
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class JListExample {

    JListExample() {
        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel();
        String data = "Popular Cities";

        DefaultListModel<String> list = new DefaultListModel<String>();
        list.addElement("Delhi");
        list.addElement("Pune");
        list.addElement("Mumbai");
        list.addElement("Goa");

        JList<String> jList = new JList<String>(list);
        jList.setBounds(100, 100, 75, 75);

        jLabel.setText(data);
        jLabel.setSize(500, 100);

        jFrame.add(jList);
        jFrame.add(jLabel);
        jFrame.setSize(400, 400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public static void main(String args[]) {
        new JListExample();
    }
}