package com.decryptor.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIDResponse {

    private String gtin;
    private String name;
}
