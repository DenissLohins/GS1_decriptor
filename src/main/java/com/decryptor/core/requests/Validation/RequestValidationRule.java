package com.decryptor.core.requests.Validation;

import com.decryptor.dto.DecryptRequest;

public interface RequestValidationRule {

    void validate(DecryptRequest request);

    default void checkNotNull(DecryptRequest request) {
        if (request == null) {
            throw new ValidationException("Request must not be null.");
        }
    }
}
