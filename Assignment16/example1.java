
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class example1 {
    public static void main(String a1[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Step 2: Load Driver

            System.out.println("Driver Loaded...");

            // Disable SSL for local development
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db?useSSL=false",
                    "root", "oneplus11R"); // Step 3 create connection

            System.out.println("Connection Established...");

            Statement st = con.createStatement();

            System.out.println("Create statement...");

            ResultSet rs = st.executeQuery("select * from student1");

            System.out.println("Retrieved data");

            System.out.println("Student no \t Student Name \t Student Per");
            while (rs.next()) {
                System.out.print(" " + rs.getInt("student_no"));
                System.out.print("\t\t" + rs.getString("student_name"));
                System.out.print("\t\t" + rs.getFloat("student_per"));
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
