package com.decryptor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddProductResponse {

    private String gtin;
    private String name;
}
