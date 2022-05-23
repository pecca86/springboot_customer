package com.example.demo.services;

import com.example.demo.DAO.CustomerRepo;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    // If we have two repositories implementing the same interface, we cannot
    // Autowire without specifying with the @Qualifier annotation, which implementation
    // we want to use
//    @Autowired
//    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getCustomer(Long id) {
        return customerRepo.getCustomers().stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Customer with given id not found!"));
    }

    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }
}
