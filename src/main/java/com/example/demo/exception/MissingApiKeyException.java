package com.example.demo.exception;

public class MissingApiKeyException extends Exception{
    public MissingApiKeyException(String value){
        super(value);
    }
}
