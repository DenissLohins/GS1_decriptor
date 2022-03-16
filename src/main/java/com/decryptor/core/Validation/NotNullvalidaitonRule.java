package com.decryptor.core.Validation;

import com.decryptor.dto.DecryptRequest;
import org.springframework.stereotype.Component;

@Component
public class NotNullvalidaitonRule implements ValidatonRule {
    @Override
    public void validate(DecryptRequest request) {
        if (request.getRequestString() == null) {
            throw new ValidationException("Request string must be not null");
        }
    }


}
