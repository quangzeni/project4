<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/7/2024
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet"/>
    <title>Login</title>
</head>
<body>
<div class="login-container">
    <form action="#" method="post" class="login-form">
        <h2>Login</h2>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
