package com.example.demo.configuration;

import com.example.demo.DAO.CustomerFakeRepo;
import com.example.demo.DAO.CustomerRepo;
import com.example.demo.DAO.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    // Takes the value from properties file, if not present default to false
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean // Makes Spring instantiate the class on runtime
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command line runner!");
        };
    }


    // Set which customer repo to instantiate
    @Bean
    CustomerRepo customerRepo() {
        // Since the bean created is a singleton, the created one will be the only one the app uses
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepo();
    }
}
