package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    Customer getCustomer(Long id) {
        return customerService.getCustomer();
    }

    @GetMapping("/customers")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

}
