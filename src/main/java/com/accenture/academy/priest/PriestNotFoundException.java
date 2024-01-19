package com.accenture.academy.priest;

public class PriestNotFoundException extends RuntimeException{
    public PriestNotFoundException() {
        super();
    }

    public PriestNotFoundException(String message) {
        super(message);
    }
}
