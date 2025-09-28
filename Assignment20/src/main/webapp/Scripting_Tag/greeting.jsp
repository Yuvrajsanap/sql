<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h1>Greeting</h1>
    <p>
        <% 
            String name = request.getParameter("name");
            if (name != null && !name.trim().isEmpty()) {
                out.println("Hello, " + name + "!");
            } else {
                out.println("Hello, Guest!");
            }
        %>
    </p>
</body>
</html>
