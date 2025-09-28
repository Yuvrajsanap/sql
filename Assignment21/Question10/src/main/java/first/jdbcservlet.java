package first;

// Program 10: Program to displaying the information of Department which store in the database (Servlet and MySQL).

// Jdbcservlet.java
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jdbcservlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            out.println("<html>");
            out.println("<body>");

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("<h1>Driver loaded</h1>");

            // Establish connection to MySQL database
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/serv", "root", "oneplus11R");
            out.println("<br><h1>Connection created</h1>");

            // Create statement and execute query
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM department");

            // Display results in HTML table
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            // Close JDBC objects
            rs.close();
            st.close();
            c.close();

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            out.close(); // Close PrintWriter
        }
    }
}
