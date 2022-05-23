package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(path = {"{customerId}"})
    Customer getCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Getting customer with id: "+ id);
        return customerService.getCustomer(id);
    }

    @GetMapping()
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // @Valid enforces the validation constraints set inside the Customer class
    @PostMapping
    void createCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("Creating a new customer");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Deleting customer with id: " + id);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("Updating customer...");
        System.out.println("Result: " + customer);
    }

}
