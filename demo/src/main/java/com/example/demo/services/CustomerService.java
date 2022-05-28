package com.example.demo.services;

import com.example.demo.DAO.CustomerRepo;
import com.example.demo.DAO.CustomerRepository;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    // If we have two repositories implementing the same interface, we cannot
    // Autowire without specifying with the @Qualifier annotation, which implementation
    // we want to use
//    @Autowired
//    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found.");
                    LOGGER.error("getCustomer with id {} failed.", id, notFoundException);
                    return notFoundException;
                });
    }

    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }
}
