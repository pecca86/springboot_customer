package com.example.demo.configuration;

import com.example.demo.jsonplaceholder.JSONPlaceHolderClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {

    // Validate that we can get data from the specified endpoint
    @Bean("jsonplaceholderr")
    CommandLineRunner commandLineRunner(JSONPlaceHolderClient jsonPlaceHolderClient) {
        return args -> {
            System.out.println("Fetching data from jsonplaceholder.typicode.com");
            System.out.println(jsonPlaceHolderClient.getPosts().size());
            System.out.println("Testing fetching with post id 1");
            System.out.println(jsonPlaceHolderClient.getPost(1));
        };
    }
}
