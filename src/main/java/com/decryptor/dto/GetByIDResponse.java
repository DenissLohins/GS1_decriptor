package com.decryptor.dto;

import com.decryptor.domain.RequestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIDResponse {

    private RequestEntity requestDTO;

}
