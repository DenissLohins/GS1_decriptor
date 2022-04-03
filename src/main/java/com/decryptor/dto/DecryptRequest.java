package com.decryptor.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecryptRequest {
@NotNull
    private final String requestString;



}
