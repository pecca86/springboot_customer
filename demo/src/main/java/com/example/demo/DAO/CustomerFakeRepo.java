package com.example.demo.DAO;

import com.example.demo.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake") // Not needed if instantiated in our config
public class CustomerFakeRepo implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer("p", "p", 1L, "qweerty124"),
                new Customer("pe", "p", 2L),
                new Customer("pek", "p", 3L, "fickenmitmutti"),
                new Customer("pekk", "p", 4L)
        );
    }
}
