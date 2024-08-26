package com.yourcompany.services;

import com.yourcompany.dao.ProductDAO;
import com.yourcompany.models.Product;
import java.sql.*;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public String addProduct(String name, String description, double price, String category) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setCategory(category);
            productDAO.addProduct(product);
            return "Product added successfully. Product ID: " + product.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while adding the product";
        }
    }

    public String updateProduct(int id, String name, String description, double price, String category) {
        try {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setCategory(category);
            productDAO.updateProduct(product);
            return "Product updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating the product";
        }
    }

    public String deleteProduct(int id) {
        try {
            productDAO.deleteProduct(id);
            return "Product deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while deleting the product";
        }
    }

    public ResultSet getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
