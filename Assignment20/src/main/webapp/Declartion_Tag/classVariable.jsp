<%@ page import="java.util.Date" %>
<%! 
    private Date currentDate = new Date(); 
%>
<html>
<head>
    <title>Class-Level Variable</title>
</head>
<body>
    <h1>Class-Level Variable</h1>
    <p>
        Current Date and Time: <%= currentDate.toString() %>
    </p>
</body>
</html>
