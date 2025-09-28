<%@ page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit User Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        max-width: 600px;
        padding: 30px;
        background-color: #ffffff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #007BFF;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table td {
        padding: 10px;
    }
    input[type="text"], input[type="password"], input[type="email"], select {
        width: calc(100% - 20px);
        padding: 10px;
        font-size: 1em;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }
    input[type="radio"] {
        margin-right: 10px;
        vertical-align: middle;
    }
    input[type="submit"] {
        width: 100%;
        padding: 12px;
        color: #fff;
        background-color: #007BFF;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 1em;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<%
String id = request.getParameter("id");
User u = UserDao.getRecordById(Integer.parseInt(id));
%>

<form action="edituser.jsp" method="post">
    <h1>Edit User</h1>
    <input type="hidden" name="id" value="<%=u.getId() %>"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%= u.getName() %>" required/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="<%= u.getPassword() %>" required/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" value="<%= u.getEmail() %>" required/></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td>
                <input type="radio" name="sex" value="male" <%= u.getSex().equals("male") ? "checked" : "" %>> Male 
                <input type="radio" name="sex" value="female" <%= u.getSex().equals("female") ? "checked" : "" %>> Female 
            </td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>
                <select name="country">
                    <option <%= u.getCountry().equals("India") ? "selected" : "" %>>India</option>
                    <option <%= u.getCountry().equals("Pakistan") ? "selected" : "" %>>Pakistan</option>
                    <option <%= u.getCountry().equals("Afghanistan") ? "selected" : "" %>>Afghanistan</option>
                    <option <%= u.getCountry().equals("Burma") ? "selected" : "" %>>Burma</option>
                    <option <%= u.getCountry().equals("Other") ? "selected" : "" %>>Other</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Edit User"></td>
        </tr>
    </table>
</form>

</body>
</html>
