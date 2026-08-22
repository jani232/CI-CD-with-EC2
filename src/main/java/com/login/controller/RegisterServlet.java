package com.login.controller;

import java.io.IOException;

import com.login.dao.UserDAO;
import com.login.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    	
    	
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(username.length() <=4) {
            response.getWriter().println("Username must be longer than 4 characters!");
            return;
        }
        
        if (!username.matches("[a-zA-Z]+")) {
            response.getWriter().println("Username must contain only letters!");
            return;
        }
        

 
        UserDAO userDAO = new UserDAO();

        if(userDAO.emailExists(email)) {
            response.getWriter().println("Email already exists!");
            return;
        }
        
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());       
        User user = new User(username, email, hashedPassword);
        
        boolean registered = userDAO.registerUser(user);



        if (registered) {

            response.sendRedirect("login.jsp");

        } else {

            response.getWriter().println("Registration failed!");

        }
    }
}