<%! 
    private static final String WELCOME_MESSAGE = "Welcome to our website!";
    
    public static String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }
%>
<html>
<head>
    <title>Static Field and Method</title>
</head>
<body>
    <h1>Static Field and Method</h1>
    <p>
        <%= getWelcomeMessage() %>
    </p>
</body>
</html>
