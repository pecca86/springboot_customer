package com.example.demo.exceptions;

// What we will throw
public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
