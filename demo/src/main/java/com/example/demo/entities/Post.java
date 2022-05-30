package com.example.demo.entities;

import lombok.*;

/**
 * This class uses Lombok to reduce boilerplate code
 */
@Data
public class Post {
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;
}
