package com.decryptor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DecryptResponse {


    private Integer ID;
    private String request;
    private String decryptedInformation;






}
