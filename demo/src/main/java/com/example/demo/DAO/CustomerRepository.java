package com.example.demo.DAO;

import com.example.demo.entities.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Repository // Not needed if instantiated in our config
//@Primary // marks as primary CustomerRepo implementation
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }
}
