
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login {
    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;

    JTextField tf1;
    JPasswordField tf2;
    JButton b1, b2, b3;
    JFrame f;

    public Login() {
        f = new JFrame("Login Screen");
        f.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 440, 440);
        panel.setBorder(new LineBorder(Color.green, 2));
        panel.setBackground(new Color(255, 219, 251));

        JLabel l1 = new JLabel("UserName");
        l1.setBounds(50, 50, 100, 25);
        panel.add(l1);

        tf1 = new JTextField();
        tf1.setBounds(175, 50, 100, 25);
        panel.add(tf1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(50, 125, 100, 25);
        panel.add(l2);

        tf2 = new JPasswordField();
        tf2.setBounds(175, 125, 100, 25);
        panel.add(tf2);

        b1 = new JButton("LOGIN");
        b1.setBounds(25, 275, 90, 25);
        panel.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBounds(125, 275, 90, 25);
        panel.add(b2);

        b3 = new JButton("CANCEL");
        b3.setBounds(225, 275, 98, 25);
        panel.add(b3);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                b1ActionPerformed(ae);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                b2ActionPerformed(ae);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                b3ActionPerformed(ae);
            }
        });

        f.add(panel);
        f.setSize(480, 500);
        f.setLocation(400, 150);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    public void b1ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tf1.getText().equals("") || tf2.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error Message",
                    JOptionPane.OK_OPTION);
            return;
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "oneplus11R");
            System.out.println("Connection Established!!");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM admin");

            boolean loginSuccess = false;
            while (rs.next()) {
                if (tf1.getText().equals(rs.getString("username"))
                        && new String(tf2.getPassword()).equals(rs.getString("password"))) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    f.setVisible(false);
                    loginSuccess = true;
                    break;
                }
            }

            if (!loginSuccess) {
                JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error Message",
                        JOptionPane.OK_OPTION);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            clear();
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void b2ActionPerformed(ActionEvent e) {
        clear();
    }

    public void b3ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void clear() {
        tf1.setText(null);
        tf2.setText(null);
    }
}
