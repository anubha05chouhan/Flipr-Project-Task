package com.yourcompany.services;

import com.yourcompany.dao.OrderDAO;
import com.yourcompany.models.Order;
import java.sql.*;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public String placeOrder(int customerId, String shippingDetails, double totalAmount) {
        try {
            Order order = new Order();
            order.setCustomerId(customerId);
            order.setShippingDetails(shippingDetails);
            order.setTotalAmount(totalAmount);
            orderDAO.placeOrder(order);
            return "Order placed successfully. Order ID: " + order.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while placing the order";
        }
    }

    public ResultSet getAllOrders() {
        try {
            return orderDAO.getAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOrdersByCustomerId(int customerId) {
        try {
            return orderDAO.getOrdersByCustomerId(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
