<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
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
    .container {
        text-align: center;
    }
    .link {
        display: inline-block;
        text-decoration: none;
        color: #007BFF;
        background-color: #ffffff;
        padding: 15px 30px;
        border-radius: 5px;
        margin: 10px;
        box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }
    .link:hover {
        background-color: #007BFF;
        color: #ffffff;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
    }
</style>
</head>
<body>

<div class="container">
    <a href="adduserform.jsp" class="link">Add User</a>
    <a href="viewusers.jsp" class="link">View Users</a>
</div>

</body>
</html>
