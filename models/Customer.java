package com.yourcompany.models;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    private String address;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int id, String name, String email, String passwordHash, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.address = address;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for passwordHash
    public String getPasswordHash() {
        return passwordHash;
    }

    // Setter for passwordHash
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
