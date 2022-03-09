package com.decryptor.core.Validation;

import com.decryptor.dto.DecryptRequest;
import org.springframework.stereotype.Component;

@Component
public class LengthValidationRule implements ValidatonRule {

    private static final int minimalLength = 6;
    public static final int maximalLength = 71;
    @Override
    public void validate(DecryptRequest request) {
        if (request.getRequestString().length() < minimalLength) {
            throw new ValidationException("Request string is to short");
        }
        if(request.getRequestString().length() > maximalLength){
            throw new ValidationException("Request string is to long");
        }
    }

}
