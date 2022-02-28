package core.Validation;

import dto.DecryptRequest;

public class LengthValidationRule implements ValidatonRule {

    @Override
    public void validate(DecryptRequest request) {
        if (request.getRequestString().length() < 6) {
            throw new ValidationException("Request string is to short");
        }
        if(request.getRequestString().length() > 71){
            throw new ValidationException("Request string is to long");
        }
    }
}
