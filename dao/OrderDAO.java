package com.yourcompany.dao;

import com.yourcompany.models.Order;
import java.sql.*;

public class OrderDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    public void placeOrder(Order order) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO orders (customer_id, shipping_details, total_amount) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, order.getCustomerId());
                stmt.setString(2, order.getShippingDetails());
                stmt.setDouble(3, order.getTotalAmount());
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        order.setId(rs.getInt(1));
                    }
                }
            }
        }
    }

    public ResultSet getAllOrders() throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String sql = "SELECT * FROM orders";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public ResultSet getOrdersByCustomerId(int customerId) throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String sql = "SELECT * FROM orders WHERE customer_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        return stmt.executeQuery();
    }
}
