package com.decryptor.core.requests.Validation;



public class CoreRequestError {

    private final String message;

    public CoreRequestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Core error message: " + message;
    }
}
