<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add User Form</title>
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
        width: 100%;
        max-width: 400px;
        padding: 20px;
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
    label {
        display: block;
        margin-bottom: .5em;
        color: #333333;
        font-weight: bold;
    }
    input[type="text"], input[type="password"], input[type="email"], select {
        width: 100%;
        padding: 10px;
        font-size: 1em;
        border: 1px solid #ccc;
        border-radius: 3px;
        margin-bottom: 1em;
        box-sizing: border-box;
    }
    input[type="radio"] {
        display: inline-block;
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
    .back-button {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007BFF;
        color: #fff;
        text-decoration: none;
        border: none;
        border-radius: 3px;
        transition: background-color 0.3s ease;
        font-size: 1em;
        margin-top: 10px;
    }
    .back-button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<form action="adduser.jsp" method="post">
    <h1>Add User</h1>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <fieldset>
        <legend>Sex:</legend>
        <input type="radio" id="male" name="sex" value="male" required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="sex" value="female" required>
        <label for="female">Female</label>
    </fieldset>

    <label for="country">Country:</label>
    <select id="country" name="country" required>
        <option value="India">India</option>
        <option value="Pakistan">Pakistan</option>
        <option value="Afghanistan">Afghanistan</option>
        <option value="Burma">Burma</option>
        <option value="Other">Other</option>
    </select>

    <input type="submit" value="Add User">
    <a href="index.jsp" class="back-button">Back</a>
</form>

</body>
</html>
