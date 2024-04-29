package com.example.demo.exception;

public class NotFoundError extends BusinessError{
    public NotFoundError(String message) {
        super(message);
    }
}