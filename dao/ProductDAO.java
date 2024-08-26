package com.yourcompany.dao;

import com.yourcompany.models.Product;
import java.sql.*;

public class ProductDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    public void addProduct(Product product) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO products (name, description, price, category) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getDescription());
                stmt.setDouble(3, product.getPrice());
                stmt.setString(4, product.getCategory());
                stmt.executeUpdate();
            }
        }
    }

    public void updateProduct(Product product) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE products SET name = ?, description = ?, price = ?, category = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getDescription());
                stmt.setDouble(3, product.getPrice());
                stmt.setString(4, product.getCategory());
                stmt.setInt(5, product.getId());
                stmt.executeUpdate();
            }
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "DELETE FROM products WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, productId);
                stmt.executeUpdate();
            }
        }
    }

    public ResultSet getAllProducts() throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String sql = "SELECT * FROM products";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}

