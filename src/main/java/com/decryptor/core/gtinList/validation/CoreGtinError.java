package com.decryptor.core.gtinList.validation;



public class CoreGtinError  {

    private final String message;

    public CoreGtinError(String message) {
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
