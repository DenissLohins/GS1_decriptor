package com.decryptor.dto;

import com.decryptor.domain.GTINEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllGtinResponse {
    private List<GTINEntity> requests;
}
