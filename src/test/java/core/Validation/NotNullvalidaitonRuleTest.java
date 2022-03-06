package core.Validation;

import dto.DecryptRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotNullvalidaitonRuleTest {

    @Test
    void requestNotNullValidationRequest() {
        NotNullvalidaitonRule victim = new NotNullvalidaitonRule();
        DecryptRequest request = null;
        assertThrowsExactly(ValidationException.class, () -> victim.checkNotNull(request));
        }

        @Test
    void requestStringNotNullValidation(){
        NotNullvalidaitonRule victim = new NotNullvalidaitonRule();
        String requestString = null;
        DecryptRequest request = new DecryptRequest(requestString);
        assertThrowsExactly(ValidationException.class, () -> victim.validate(request));
        }
}