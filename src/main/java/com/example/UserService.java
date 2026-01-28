package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    
    private String password = "secret";
    
    // Fixed: Using try-with-resources to automatically close resources
    public void findUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(
                 "SELECT * FROM users WHERE name = '" + username + "'")) {
            
            // Process results if needed
            while (rs.next()) {
                // Handle result set
            }
        }
        // Resources are automatically closed
    }
    
    // Fixed: Using try-with-resources to automatically close resources
    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement()) {
            
            String query = "DELETE FROM users WHERE name = '" + username + "'";
            st.execute(query);
        }
        // Resources are automatically closed
    }
}