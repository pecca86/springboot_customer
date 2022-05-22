package com.example.demo.DAO;

import com.example.demo.entities.Customer;

import java.util.List;

public interface CustomerRepo {

    List<Customer> getCustomers();
}
