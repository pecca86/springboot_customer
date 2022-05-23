package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;


public class Customer {
    private Long id;
    private String name;
    private String email;
    // For Jackson demo purposes
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // So we can send a new password inside JSON payload
    private String password;

    public Customer() {
    }

    public Customer(String name, String email, Long id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = "";
    }

    public Customer(String name, String email, Long id, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Change name of json payload property
    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Jackson will not parse this into the json payload
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
