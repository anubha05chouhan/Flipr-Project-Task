package com.yourcompany.dao;

import com.yourcompany.models.Cart;
import java.sql.*;

public class CartDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    public void addProductToCart(Cart cart) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cart.getCustomerId());
                stmt.setInt(2, cart.getProductId());
                stmt.setInt(3, cart.getQuantity());
                stmt.executeUpdate();
            }
        }
    }

    public void updateCart(Cart cart) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE cart SET quantity = ? WHERE customer_id = ? AND product_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cart.getQuantity());
                stmt.setInt(2, cart.getCustomerId());
                stmt.setInt(3, cart.getProductId());
                stmt.executeUpdate();
            }
        }
    }

    public void deleteProductFromCart(int customerId, int productId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "DELETE FROM cart WHERE customer_id = ? AND product_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, customerId);
                stmt.setInt(2, productId);
                stmt.executeUpdate();
            }
        }
    }

    public ResultSet getCart(int customerId) throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String sql = "SELECT * FROM cart WHERE customer_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        return stmt.executeQuery();
    }
}
