package com.decryptor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;


@Data
@NoArgsConstructor
public class DecryptResponse {


    private Integer ID;
    private String request;
    private String decryptedInformation;
    private URI uri;






}
