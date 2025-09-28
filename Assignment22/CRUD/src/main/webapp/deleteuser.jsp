<%@ page import="com.javatpoint.dao.UserDao"%>
<%
String id = request.getParameter("id");
if (id != null && !id.isEmpty()) {
    try {
        int userId = Integer.parseInt(id);
        int result = UserDao.delete(userId);
        response.sendRedirect("viewusers.jsp");
    } catch (NumberFormatException e) {
        out.println("Invalid user ID format.");
    }
} else {
    out.println("User ID is missing.");
}
%>
