package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Addcookie")
public class Addcookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c1 = new Cookie("Cookie1", "1");
		Cookie c2 = new Cookie("Cookie2", "2");
		Cookie c3 = new Cookie("Cookie3", "3");

		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);

		res.setContentType("text/html");

		try (PrintWriter pw = res.getWriter()) {
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Cookie Information</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("Cookie added with value 1<br>");
			pw.println("Cookie added with value 2<br>");
			pw.println("Cookie added with value 3<br>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}
}
