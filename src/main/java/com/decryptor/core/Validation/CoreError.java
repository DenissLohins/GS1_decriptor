package com.decryptor.core.Validation;



public class CoreError {

    private final String message;

    public CoreError(String message) {
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
