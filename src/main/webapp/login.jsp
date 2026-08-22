


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="auth-container">

        <h2>Welcome Back</h2>

        <p class="subtitle">Login to your account</p>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (errorMessage != null) {
%>

    <div class="error-message">
        <%= errorMessage %>
    </div>

<%
    }
%>
        <form action="login" method="post">

            <div class="form-group">
                <label>Email</label>
                <input type="email"
                       name="email"
                       placeholder="Enter your email"
                       required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password"
                       name="password"
                       placeholder="Enter your password"
                       required>
            </div>

            <button type="submit" class="btn">
                Login
            </button>

        </form>

        <div class="auth-footer">
            Don't have an account?
            <a href="register.jsp">Register</a>
        </div>

    </div>

</body>

</html>