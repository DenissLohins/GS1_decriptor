package com.decryptor.core.Validation;

import com.decryptor.dto.DecryptRequest;

public interface ValidatonRule {

    void validate(DecryptRequest request);

    default void checkNotNull(DecryptRequest request) {
        if (request == null) {
            throw new ValidationException("Request must not be null.");
        }
    }
}
