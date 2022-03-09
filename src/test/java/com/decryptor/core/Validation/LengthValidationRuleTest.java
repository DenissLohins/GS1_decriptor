package com.decryptor.core.Validation;

import com.decryptor.dto.DecryptRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthValidationRuleTest {

    @Test
    void minimalLength() {
        LengthValidationRule victim = new LengthValidationRule();
        String testString = "asd";
        DecryptRequest request = new DecryptRequest(testString);
        assertThrowsExactly(ValidationException.class, () -> victim.validate(request));
    }

    @Test
    void acceptaleLength() {
        LengthValidationRule victim = new LengthValidationRule();
        String testString = "1234567890";
        DecryptRequest request = new DecryptRequest(testString);
        victim.validate(request);
    }

    @Test
    void tooLongLength() {
        LengthValidationRule victim = new LengthValidationRule();
        String testString = "123456789012345678901234567890123456789012345678901234567890123456789012";
        DecryptRequest request = new DecryptRequest(testString);
        assertThrowsExactly(ValidationException.class, () -> victim.validate(request));
    }
}