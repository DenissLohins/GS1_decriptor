package core.Validation;

import dto.DecryptRequest;

public class NotNullvalidaitonRule implements ValidatonRule {
    @Override
    public void validate(DecryptRequest request) {
        if (request.getRequestString() == null) {
            throw new ValidationException("Request string must be not null");
        }
    }
}
