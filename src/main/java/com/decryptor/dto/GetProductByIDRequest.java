package com.decryptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIDRequest {

    @NotNull
    @Length(min = 14, max = 15)
    private String gtin;

}
