package com.example.demo.exception;


public class BusinessError extends RuntimeException{
    private final String message;

    public BusinessError(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
