package com.yourcompany.models;

public class Order {
    private int id;
    private int customerId;
    private String shippingDetails;
    private double totalAmount;

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(int id, int customerId, String shippingDetails, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.shippingDetails = shippingDetails;
        this.totalAmount = totalAmount;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for customerId
    public int getCustomerId() {
        return customerId;
    }

    // Setter for customerId
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter for shippingDetails
    public String getShippingDetails() {
        return shippingDetails;
    }

    // Setter for shippingDetails
    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    // Getter for totalAmount
    public double getTotalAmount() {
        return totalAmount;
    }

    // Setter for totalAmount
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", shippingDetails='" + shippingDetails + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
