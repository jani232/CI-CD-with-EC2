<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register - ci/cd test</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="auth-container">

        <h2>Create Account</h2>

        <p class="subtitle">Register to get started</p>

        <form action="register" method="post">

            <div class="form-group">
                <label>Username</label>
                <input type="text"
                       name="username"
                       placeholder="Enter your username"
                       required>
            </div>

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
                Register
            </button>

        </form>

        <div class="auth-footer">
            Already have an account?
            <a href="login.jsp">Login</a>
        </div>

    </div>

</body>

</html>