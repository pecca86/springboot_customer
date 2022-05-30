package com.example.demo.customer;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test
 */
@DataJpaTest
public class CustomerServiceTest {

    // If active, the test uses the real repository
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);

    }

    @AfterEach
    void tearDown() {
        // Delete all created data after test is finished
        customerRepository.deleteAll();
    }

    @Test
    void shouldGetAllCustomers() {
        // Given
        Customer customer1 = new Customer("Cust1", "c@c1.com", "password");
        Customer customer2 = new Customer("Cust2", "c@c2.com", "password");
        Customer customer3 = new Customer("Cust3", "c@c3.com", "password");
        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

        // When
        List<Customer> customers = underTest.getCustomers();

        // Then
        assertEquals(3, customers.size());
    }

    @Test
    void shouldGetSingleCustomerWithId() {
        // Given
        Customer customer1 = new Customer("Cust1", "c@c1.com", "password");
        customerRepository.save(customer1);

        // When
        List<Customer> customers = underTest.getCustomers();

        // Then
        assertEquals("Cust1", customers.get(0).getName());
    }

    @Test
    void shouldCreateNewCustomer() {
        // Given
        Customer customer1 = new Customer("Cust1", "c@c1.com", "password");
        underTest.createCustomer(customer1);

        // When
        List<Customer> customers = underTest.getCustomers();

        // Then
        assertEquals("Cust1", customers.get(0).getName());
    }
}
