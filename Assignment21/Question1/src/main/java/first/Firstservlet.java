package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class Firstservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>MyServlet</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"cyan\">");
		out.println("<h1> My First Servlet Program...</h1>");
		out.println("<h2>Welcome to Servlet World...</h2>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
