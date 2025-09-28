<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Current Date and Time</title>
</head>
<body>
    <h1>Current Date and Time</h1>
    <p>
        <% 
            Date currentDate = new Date(); 
            out.println("Current Date and Time: " + currentDate.toString());
        %>
    </p>
</body>
</html>
