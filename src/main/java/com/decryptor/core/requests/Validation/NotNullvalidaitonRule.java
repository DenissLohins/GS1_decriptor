package com.decryptor.core.requests.Validation;

import com.decryptor.dto.DecryptRequest;
import org.springframework.stereotype.Component;

@Component
public class NotNullvalidaitonRule implements RequestValidationRule {
    @Override
    public void validate(DecryptRequest request) {
        if (request.getRequestString() == null) {
            throw new ValidationException("Request string must be not null");
        }
    }


}
