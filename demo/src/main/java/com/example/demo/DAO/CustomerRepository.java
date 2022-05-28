package com.example.demo.DAO;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Primary // marks as primary CustomerRepo implementation
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
