// Program 3: Displaying the Servlet information.

// Servletinfo.java
package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servletinfo")
public class Servletinfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		try (PrintWriter out = res.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Info</title>");
			out.println("</head>");
			out.println("<body>");

			out.println("Protocol Info : " + req.getProtocol());
			out.println("<br>IP address: " + req.getRemoteAddr());
			out.println("<br>Details Of Client: " + req.getRemoteHost());
			out.println("<br>Server Name: " + req.getServerName());
			out.println("<br>Server Port: " + req.getServerPort());
			out.println("<br>Servlet Path: " + req.getServletPath());

			out.println("</body>");
			out.println("</html>");
		}
	}
}
