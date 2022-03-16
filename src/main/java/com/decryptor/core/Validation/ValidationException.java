package com.decryptor.core.Validation;

import org.springframework.stereotype.Component;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
