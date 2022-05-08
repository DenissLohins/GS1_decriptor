package com.decryptor.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class AddProductRequest {

    @NotNull
    @NotEmpty
    @Length (min = 14, max = 15)
    private String gtin;

    @NotNull
    @NotEmpty
    @Length (min = 10, max = 255)
    private  String name;
}
