package com.example.demo.exception;

public class ApiLimitExceeded extends Exception{
    public ApiLimitExceeded(String value){
        super(value);
    }
}
