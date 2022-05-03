package com.decryptor.core.requests.Validation;

import com.decryptor.dto.DecryptRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class RequestValidationService {

    private final List<RequestValidationRule> validationRules;

    public RequestValidationService(List<RequestValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreRequestError> validate(DecryptRequest request) {
        List<CoreRequestError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreRequestError("request mut not be null"));
            return errors;
        }
        return validationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreRequestError mapError(RequestValidationRule rule, DecryptRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreRequestError(e.getMessage());
        }
        return null;
    }
}
