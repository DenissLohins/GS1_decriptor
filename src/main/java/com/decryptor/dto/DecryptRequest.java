package com.decryptor.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor

public class DecryptRequest {
    @NotNull
    @NotEmpty
    @Length(min = 6, max= 255)
    private String requestString;



}
