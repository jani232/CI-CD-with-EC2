<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.login.model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="dashboard-container">

        <h2>
            Welcome, <%= user.getUsername() %>!
        </h2>

        <p>
            You are successfully logged in.
        </p>

        <a href="logout" class="logout-btn">
            Logout
        </a>

    </div>

</body>

</html>