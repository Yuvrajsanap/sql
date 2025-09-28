package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNumServlet")
public class AddNumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int num1 = Integer.parseInt(req.getParameter("n1"));
		int num2 = Integer.parseInt(req.getParameter("n2"));
		int add = num1 + num2;

		res.setContentType("text/html");

		try (PrintWriter out = res.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Addition Program</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"cyan\">");
			out.println("<h2> Num1 = " + num1 + "</h2>");
			out.println("<h2> Num2 = " + num2 + "</h2>");
			out.println("<h2> Sum = " + add + "</h2>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
