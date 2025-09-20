package com.example.demo.exception;

public class InvalidApiKeyException extends Exception{
    public InvalidApiKeyException(String value) {
        super(value);
    }
}
