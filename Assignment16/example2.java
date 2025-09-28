
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class example2 {
    public static void main(String a[]) {
        try {
            // Set default values or use provided arguments
            int sno = (a.length > 0) ? Integer.parseInt(a[0]) : 1;
            String sname = (a.length > 1) ? a[1] : "Default Name";
            float sper = (a.length > 2) ? Float.parseFloat(a[2]) : 0.0f;
            int no = (a.length > 3) ? Integer.parseInt(a[3]) : 1;

            System.out.println("Student No = " + sno);
            System.out.println("Student Name = " + sname);
            System.out.println("Student Percentage = " + sper);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded ...");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db?useSSL=false",
                    "root", "oneplus11R");
            System.out.println("Connection Established");

            // Check if sno already exists and find a unique sno if it does
            while (true) {
                PreparedStatement checkStmt = con
                        .prepareStatement("SELECT COUNT(*) FROM student1 WHERE student_no = ?");
                checkStmt.setInt(1, sno);
                ResultSet checkRs = checkStmt.executeQuery();
                checkRs.next();
                if (checkRs.getInt(1) == 0) {
                    break;
                }
                sno++; // Increment sno to find a unique one
            }

            PreparedStatement ps = con.prepareStatement("insert into student1 values(?,?,?)");
            ps.setInt(1, sno);
            ps.setString(2, sname);
            ps.setFloat(3, sper);
            int i = ps.executeUpdate();
            System.out.println("Value = " + i);
            System.out.println("Insert Data Successfully ...");

            Statement st = con.createStatement();
            System.out.println("Statement Created...");

            ResultSet rs = st.executeQuery("select * from student1");
            System.out.println("Student No \t Student Name \t Student Per ");
            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print("\t\t" + rs.getString(2));
                System.out.print("\t\t" + rs.getFloat(3));
                System.out.println();
            }

            PreparedStatement ps1 = con.prepareStatement("select * from student1 where student_no = ?");
            ps1.setInt(1, 7);
            ResultSet rs1 = ps1.executeQuery();
            System.out.println("FOUND...");
            System.out.println("Student No \t Student Name \t Student Per");
            while (rs1.next()) {
                System.out.print(rs1.getInt(1));
                System.out.print("\t\t" + rs1.getString(2));
                System.out.print("\t\t" + rs1.getFloat(3));
                System.out.println();
            }

            PreparedStatement ps2 = con.prepareStatement("select * from student1 where student_no = ?");
            ps2.setInt(1, no);
            ResultSet rs2 = ps2.executeQuery();
            System.out.println("FOUND...");
            System.out.println("Student No \t Student Name \t Student Per ");
            while (rs2.next()) {
                System.out.print(rs2.getInt(1));
                System.out.print("\t\t" + rs2.getString(2));
                System.out.print("\t\t" + rs2.getFloat(3));
                System.out.println();
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
