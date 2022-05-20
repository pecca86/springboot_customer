package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping
    Customer getCustomer(Long id) {
        return new Customer("Pekka", "p@p.com", 1L);
    }

}
