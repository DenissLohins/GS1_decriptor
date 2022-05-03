package com.decryptor.core.gtinList.validation;

import com.decryptor.core.requests.Validation.ValidationException;
import com.decryptor.dto.AddGtinRequest;

public interface GtinValidationRule {

    void validate(AddGtinRequest request);
}
