package com.decryptor.core.gtinList.validation;

import com.decryptor.core.requests.Validation.ValidationException;
import com.decryptor.dto.AddGtinRequest;

public class LengthValidationRule implements GtinValidationRule{

    private static final int GTIN_LENGTH = 15;
    private static final int NAME_MIN_LENGTH = 10;
    private static final int NAME_MAX_LENGTH = 200;

    @Override
    public void validate(AddGtinRequest request) {
        if (request.getGtin().length() != GTIN_LENGTH){
            throw new ValidationException("Wrong length of GTIn number");
        }
        if (request.getName().length() < NAME_MIN_LENGTH) {
            throw new ValidationException("Product name is to short");
        }
        if(request.getName().length() > NAME_MAX_LENGTH){
            throw new ValidationException("Product name is to long");
        }
    }
}
