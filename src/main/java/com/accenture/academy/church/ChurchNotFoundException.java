package com.accenture.academy.church;

public class ChurchNotFoundException extends RuntimeException {
    public ChurchNotFoundException(String s) {
        super(s);
    }

    public ChurchNotFoundException() {
        super();
    }
}
