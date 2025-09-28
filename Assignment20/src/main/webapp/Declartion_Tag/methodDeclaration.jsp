<%! 
    public String getGreeting(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello, Aniket!";
        } else {
            return "Hello, " + name + "!";
        }
    }
%>
<html>
<head>
    <title>Method Declaration</title>
</head>
<body>
    <h1>Greeting</h1>
    <p>
        <%= getGreeting(request.getParameter("name")) %>
    </p>
</body>
</html>
