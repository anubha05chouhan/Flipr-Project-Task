package com.yourcompany.services;

import com.yourcompany.dao.CartDAO;
import com.yourcompany.models.Cart;
import java.sql.*;

public class CartService {
    private CartDAO cartDAO = new CartDAO();

    public String addProductToCart(int customerId, int productId, int quantity) {
        try {
            Cart cart = new Cart();
            cart.setCustomerId(customerId);
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            cartDAO.addProductToCart(cart);
            return "Product added to cart successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while adding product to cart";
        }
    }

    public String updateCart(int customerId, int productId, int quantity) {
        try {
            Cart cart = new Cart();
            cart.setCustomerId(customerId);
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            if (quantity == 0) {
                cartDAO.deleteProductFromCart(customerId, productId);
            } else {
                cartDAO.updateCart(cart);
            }
            return "Cart updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating cart";
        }
    }

    public String deleteProductFromCart(int customerId, int productId) {
        try {
            cartDAO.deleteProductFromCart(customerId, productId);
            return "Product removed from cart successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while removing product from cart";
        }
    }

    public ResultSet getCart(int customerId) {
        try {
            return cartDAO.getCart(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
