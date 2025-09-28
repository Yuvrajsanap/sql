package first;

// Program 2: Program for displaying the Date using Servlet.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyDate")
public class MyDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");

		try (PrintWriter out = res.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Date Program...</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"cyan\">");

			Date d = new Date();
			out.println("<br><br><h1>Date = " + d + "</h1>");

			out.println("</body>");
			out.println("</html>");
		}
	}
}
