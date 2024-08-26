package com.yourcompany.services;

import com.yourcompany.dao.CustomerDAO;
import com.yourcompany.models.Customer;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public String signUp(String name, String email, String password, String address) {
        try {
            if (customerDAO.emailExists(email)) {
                return "Email already registered";
            }
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPasswordHash(hashedPassword);
            customer.setAddress(address);
            customerDAO.addCustomer(customer);
            return "Sign up successful. Customer ID: " + customer.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred during sign up";
        }
    }

    public String signIn(String email, String password) {
        try {
            Customer customer = customerDAO.getCustomerByEmail(email);
            if (customer != null && BCrypt.checkpw(password, customer.getPasswordHash())) {
                // Generate JWT token here
                return "Sign in successful. Token: [JWT Token]";
            } else {
                return "Invalid email or password";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred during sign in";
        }
    }
}

