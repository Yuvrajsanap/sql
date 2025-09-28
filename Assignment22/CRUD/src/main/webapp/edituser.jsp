<%@ page import="com.javatpoint.dao.UserDao"%>
<jsp:useBean id="u" class="com.javatpoint.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i = UserDao.update(u);
if (i > 0) {
    response.sendRedirect("viewusers.jsp");
} else {
    response.sendRedirect("editform.jsp?id=" + u.getId());
}
%>
