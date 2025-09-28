package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Factservlet")
public class Factservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int no = Integer.parseInt(req.getParameter("txt"));
		int f = 1;

		for (int i = 1; i <= no; i++) {
			f *= i;
		}

		res.setContentType("text/html");

		try (PrintWriter out = res.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Factorial Program...</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"cyan\">");
			out.println("<h2>Factorial of Given Number = " + f + "</h2>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
