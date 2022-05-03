package com.decryptor.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class AddGtinRequest {

    @NotNull
    private  String gtin;
    @NotNull
    private  String name;
}
