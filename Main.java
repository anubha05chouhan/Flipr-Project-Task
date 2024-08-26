package com.yourcompany;
import com.yourcompany.services.CustomerService;
public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        // Example usage
        String signUpResponse = customerService.signUp("John Doe", "john.doe@example.com", "password123", "123 Main St");
        System.out.println(signUpResponse);
        String signInResponse = customerService.signIn("john.doe@example.com", "password123");
        System.out.println(signInResponse);
    }
}
