package com.decryptor.dto;

import com.decryptor.core.requests.Validation.CoreRequestError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DecryptResponse {


    private Integer ID;
    private List<CoreRequestError> errors;
    private String request;
    private String decryptedInformation;






}
