package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	// JDBC URL, username, and password of MySQL server
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "oneplus11R";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String uname = req.getParameter("us");
		String pwd = req.getParameter("pd");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Status</title>");
			out.println("</head>");
			out.println("<body>");

			// 1. Register JDBC driver (not necessary in newer JDBC versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Open a connection
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			out.println("<h1>Connected to MySQL Database</h1>");

			// 3. Create a SQL statement
			String sql = "SELECT * FROM users WHERE username=? AND password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pwd);

			// 4. Execute SQL query
			rs = stmt.executeQuery();

			// 5. Process the result set
			if (rs.next()) {
				out.println("<h2>Login Successful....</h2>");
			} else {
				out.println("<h3>Login Failed! Try Again...</h3>");
			}

		} catch (SQLException e) {
			out.println("Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Close resources in finally block
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				out.println("Error closing resources: " + e.getMessage());
			}

			out.println("</body>");
			out.println("</html>");
			out.close(); // Close PrintWriter
		}
	}
}
