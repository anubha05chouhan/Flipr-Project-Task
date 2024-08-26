package com.yourcompany.dao;

import com.yourcompany.models.Customer;
import java.sql.*;

public class CustomerDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    // Method to check if email exists
    public boolean emailExists(String email) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM customers WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                }
            }
        }
        return false;
    }

    // Method to add a new customer
    public void addCustomer(Customer customer) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO customers (name, email, password_hash, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, customer.getName());
                stmt.setString(2, customer.getEmail());
                stmt.setString(3, customer.getPasswordHash());
                stmt.setString(4, customer.getAddress());
                stmt.executeUpdate();
            }
        }
    }

    // Method to get customer by email
    public Customer getCustomerByEmail(String email) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM customers WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Customer customer = new Customer();
                        customer.setId(rs.getInt("id"));
                        customer.setName(rs.getString("name"));
                        customer.setEmail(rs.getString("email"));
                        customer.setPasswordHash(rs.getString("password_hash"));
                        customer.setAddress(rs.getString("address"));
                        return customer;
                    }
                }
            }
        }
        return null;
    }
}
