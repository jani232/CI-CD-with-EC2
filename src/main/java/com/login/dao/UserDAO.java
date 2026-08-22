package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.model.User;
import com.login.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;


public class UserDAO {

    // Register a new user
public boolean registerUser(User user) {

    String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

    try {

        
        Connection con = DBConnection.getConnection();

       
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());

      

        int result = ps.executeUpdate();

      
        ps.close();
        con.close();

    

        return result > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}

public boolean emailExists(String email) {

    String sql = "SELECT email FROM users WHERE email = ?";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        boolean exists = rs.next();

        rs.close();
        ps.close();
        con.close();

        return exists;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // Authenticate user
public User loginUser(String email, String password) {

    String sql = "SELECT * FROM users WHERE email = ?";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("User found: " + rs.getString("email"));

            String storedHash = rs.getString("password");

            System.out.println("Stored hash: " + storedHash);
            System.out.println("Entered password: " + password);

            boolean passwordMatch = BCrypt.checkpw(password, storedHash);

            System.out.println("Password match: " + passwordMatch);

            if (passwordMatch) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(storedHash);

                rs.close();
                ps.close();
                con.close();

                return user;
            }

        } else {

            System.out.println("No user found with email: " + email);

        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}