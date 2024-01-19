package com.accenture.academy.priest;

public class NoSuchPriestsFoundException extends RuntimeException{
    public NoSuchPriestsFoundException() {
        super();
    }

    public NoSuchPriestsFoundException(String message) {
        super(message);
    }
}
