package core.Validation;

import dto.DecryptRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {

    private final List<ValidatonRule> validationRules;

    public ValidationService(List<ValidatonRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(DecryptRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("request mut not be null"));
            return errors;
        }
        return validationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidatonRule rule, DecryptRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
