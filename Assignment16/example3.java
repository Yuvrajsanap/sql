
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class example3

{

    public static void main(String a[]) {
        try

        {

            int eno, esal, lim;

            String ename;

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded ...");

            Connection con = DriverManager.getConnection

            ("jdbc:mysql://localhost:3306/assignment_db", "root", "oneplus11R");

            System.out.println("Connection Established...");

            BufferedReader br = new BufferedReader

            (new InputStreamReader(System.in));

            System.out.println("How many record want to be insert ?");

            lim = Integer.parseInt(br.readLine());

            for (int i = 0; i < lim; i++)

            {

                System.out.println("Enter student1 No =");

                eno = Integer.parseInt(br.readLine());

                System.out.println("Enter student1 Name =");

                ename = br.readLine();

                System.out.println("Enter student1 Salary =");

                esal = Integer.parseInt(br.readLine());

                // insert

                PreparedStatement ps = con.prepareStatement

                ("insert into student1 values(?,?,?)");

                ps.setInt(1, eno);

                ps.setString(2, ename);

                ps.setInt(3, esal);

                int j = ps.executeUpdate();

                System.out.println("j = " + j);

            } // for */

            // Display (select)

            Statement st = con.createStatement();

            System.out.println("Statement Created...");

            ResultSet rs = st.executeQuery("select * from student1");

            System.out.println("* Employee Record * \n");
            System.out.println("Emp No \t Emp Name \t Emp Salary");
            while (rs.next())

            {

                System.out.print(" " + rs.getInt(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t\t " + rs.getInt(3));
                System.out.println();

            }

            // Search by Employee Number
            System.out.println("Enter Employee No to be Search =");
            int no = Integer.parseInt(br.readLine());
            Statement st1 = con.createStatement();
            System.out.println("Statement Created...");
            ResultSet rs1 = st1.executeQuery("select * from student1 where eno+'" + no + "'");

            System.out.println("* Employee Record*** \n");

            System.out.println("Emp No \t Emp Name \t\t Emp Salary");
            while (rs1.next())

            {

                System.out.print(" " + rs1.getInt(1));

                System.out.print("\t" + rs1.getString(2));

                System.out.print("\t\t " + rs1.getInt(3));

                System.out.println();

            }

            // Search by Employee Name

            System.out.println("Enter Employee Name to be Search =");

            String name = br.readLine();

            Statement st2 = con.createStatement();

            System.out.println("Statement Created...");

            ResultSet rs2 = st2.executeQuery

            ("select * from student1 where ename = '" + name + "'");

            System.out.println("* Employee Record * \n");

            System.out.println("Emp No \t Emp Name \t\t Emp Salary");
            while (rs2.next())

            {

                System.out.print(" " + rs2.getInt(1));

                System.out.print("\t" + rs2.getString(2));
                System.out.print("\t\t " + rs2.getInt(3));
                System.out.println();

            }

        } // try

        catch (Exception e)

        {

            System.out.println("Error " + e);
        }

    }

}