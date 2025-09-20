package com.example.demo.exception;

public class InvalidQuoteSymbolException extends Exception{
    public InvalidQuoteSymbolException(String value) {
        super(value);
    }
}
