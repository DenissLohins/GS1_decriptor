package com.decryptor.dto;

import com.decryptor.core.Validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DecryptResponse {


    private Integer ID;
    private List<CoreError> errors;
    private String request;
    private String decryptedInformation;






}
