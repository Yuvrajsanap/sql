package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Sess1")
public class Sess1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(true);
		String uname = req.getParameter("us");
		String pwd = req.getParameter("pd");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		if (uname.equals("tybcs") && pwd.equals("tybcs123")) {
			out.println("<html><body>");
			out.println("<h2>Login Successfully....</h2>");
			hs.setAttribute("LoginID", uname);
			out.println(
					"<a href='http://localhost:8080/servlets-examples/servlet/Sess.html'>Go to Session Example</a>");
			out.println("</body></html>");
			return;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db", "root", "oneplus11R");
			out.println("<html><body>");
			out.println("<h1>Connection Established</h1>");

			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT username, password FROM admin");

			boolean loginSuccess = false;
			while (rs.next()) {
				if (uname.equals(rs.getString("username")) && pwd.equals(rs.getString("password"))) {
					loginSuccess = true;
					break;
				}
			}

			if (loginSuccess) {
				out.println("<h2>Login Successfully....</h2>");
			} else {
				out.println("<h3>NOT! Try Again...</h3>");
			}

			c.close();
		} catch (Exception e) {
			out.println("error: " + e);
		}
		out.println("Successfully JDBC Done...");
		out.println("</body></html>");
	}
}