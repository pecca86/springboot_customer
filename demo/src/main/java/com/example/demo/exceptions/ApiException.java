package com.example.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

// Record gives us:
// private final attributes, getters, setter, constructor, equals, hashcode,toString
public record ApiException(
        String message,
        Throwable throwable,
        HttpStatus httpStatus,
        ZonedDateTime zonedDateTime
) {

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }
}
