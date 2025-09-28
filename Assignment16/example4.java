
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class example4 {

    public static void main(String[] args) {
        int choice;

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "oneplus11R");
            sm = con.createStatement();

            do {
                System.out.println("1.Insert");
                System.out.println("2.Modify");
                System.out.println("3.Delete");
                System.out.println("4.Search");
                System.out.println("5. View All");
                System.out.println("6.Exit");
                System.out.println("Enter Your Choice:\t");

                choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        // Insert Record
                        System.out.println("Enter Roll No:\t");
                        int r = Integer.parseInt(br.readLine());

                        System.out.println("Enter Name: \t");
                        String name = br.readLine();

                        System.out.println("Enter Percentage:\t");
                        float f = Float.parseFloat(br.readLine());

                        PreparedStatement psInsert = con
                                .prepareStatement("INSERT INTO student3 (sno, sname, per) VALUES (?, ?, ?)");
                        psInsert.setInt(1, r);
                        psInsert.setString(2, name);
                        psInsert.setFloat(3, f);

                        int result = psInsert.executeUpdate();
                        if (result > 0) {
                            System.out.println("Insert Successfully");
                        } else {
                            System.out.println("Error");
                        }
                        psInsert.close();
                        break;

                    case 2:
                        // Modify Record
                        System.out.println("Enter Roll No:\t");
                        r = Integer.parseInt(br.readLine());
                        System.out.println("1.Name");
                        System.out.println("2.Percentage");
                        System.out.println("Enter Your Choice:\t");
                        choice = Integer.parseInt(br.readLine());

                        switch (choice) {
                            case 1:
                                System.out.println("Enter Name: \t");
                                name = br.readLine();

                                PreparedStatement psUpdateName = con
                                        .prepareStatement("UPDATE student3 SET sname=? WHERE sno=?");
                                psUpdateName.setString(1, name);
                                psUpdateName.setInt(2, r);

                                result = psUpdateName.executeUpdate();
                                if (result > 0) {
                                    System.out.println("Update Successfully");
                                } else {
                                    System.out.println("Error");
                                }
                                psUpdateName.close();
                                break;

                            case 2:
                                System.out.println("Enter Percentage:\t");
                                f = Float.parseFloat(br.readLine());

                                PreparedStatement psUpdatePer = con
                                        .prepareStatement("UPDATE student3 SET per=? WHERE sno=?");
                                psUpdatePer.setFloat(1, f);
                                psUpdatePer.setInt(2, r);

                                result = psUpdatePer.executeUpdate();
                                if (result > 0) {
                                    System.out.println("Update Successfully");
                                } else {
                                    System.out.println("Error");
                                }
                                psUpdatePer.close();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                        break;

                    case 3:
                        // Delete Record
                        System.out.println("Enter Roll No: \t");
                        r = Integer.parseInt(br.readLine());

                        PreparedStatement psDelete = con.prepareStatement("DELETE FROM student3 WHERE sno=?");
                        psDelete.setInt(1, r);

                        result = psDelete.executeUpdate();
                        if (result > 0) {
                            System.out.println("Deleted Successfully");
                        } else {
                            System.out.println("Error");
                        }
                        psDelete.close();
                        break;

                    case 4:
                        // Search Record
                        System.out.println("Enter Roll No:\t");
                        r = Integer.parseInt(br.readLine());

                        PreparedStatement psSearch = con.prepareStatement("SELECT * FROM student3 WHERE sno=?");
                        psSearch.setInt(1, r);

                        rs = psSearch.executeQuery();

                        ResultSetMetaData rsmd = rs.getMetaData();
                        int col = rsmd.getColumnCount();

                        for (int i = 1; i <= col; i++) {
                            System.out.print(rsmd.getColumnLabel(i) + "\t");
                        }
                        System.out.println();

                        while (rs.next()) {
                            for (int i = 1; i <= col; i++) {
                                System.out.print(rs.getString(i) + "\t");
                            }
                            System.out.println();
                        }

                        rs.close();
                        psSearch.close();
                        break;

                    case 5:
                        // View All Records
                        rs = sm.executeQuery("SELECT * FROM student3");

                        rsmd = rs.getMetaData();
                        col = rsmd.getColumnCount();

                        for (int i = 1; i <= col; i++) {
                            System.out.print(rsmd.getColumnLabel(i) + "\t");
                        }
                        System.out.println();

                        while (rs.next()) {
                            for (int i = 1; i <= col; i++) {
                                System.out.print(rs.getString(i) + "\t");
                            }
                            System.out.println();
                        }

                        rs.close();
                        break;

                    case 6:
                        // Exit
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (true);

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (sm != null)
                    sm.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}