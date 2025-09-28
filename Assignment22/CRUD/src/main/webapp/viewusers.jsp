<%@ page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Users</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #007BFF;
        margin-bottom: 20px;
    }
    table {
        width: 90%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #ffffff;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        border: 1px solid #dddddd;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #007BFF;
        color: #ffffff;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .empty-message {
        text-align: center;
        color: #999999;
        margin-top: 20px;
    }
    .add-user-link {
        display: block;
        text-align: center;
        margin-top: 20px;
    }
    .add-user-link a {
        color: #007BFF;
        text-decoration: none;
    }
    .add-user-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<h1>Users List</h1>

<%
List<User> list = UserDao.getAllRecords();
request.setAttribute("list", list);
%>

<c:choose>
    <c:when test="${not empty list}">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Sex</th>
                    <th>Country</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="u">
                    <tr>
                        <td>${u.getId()}</td>
                        <td>${u.getName()}</td>
                        <td>${u.getPassword()}</td>
                        <td>${u.getEmail()}</td>
                        <td>${u.getSex()}</td>
                        <td>${u.getCountry()}</td>
                        <td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
                        <td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p class="empty-message">No users found.</p>
    </c:otherwise>
</c:choose>

<div class="add-user-link">
    <a href="adduserform.jsp">Add New User</a>
</div>

</body>
</html>
