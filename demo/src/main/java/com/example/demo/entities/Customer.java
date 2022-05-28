package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Uses Spring validation for attributes
 */

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 2, max = 20, message = "Minimum 2 letters, max 20.")
    private String name;
    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email format invalid.") // We can also pass in a regex to the email annotation
    private String email;
    // For Jackson demo purposes
    @NotBlank(message = "Must provide a password.")
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
