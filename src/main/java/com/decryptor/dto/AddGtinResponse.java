package com.decryptor.dto;

import com.decryptor.core.requests.Validation.CoreRequestError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddGtinResponse {

    private String gtin;
    private String name;
    private List<CoreRequestError> errors;
}
