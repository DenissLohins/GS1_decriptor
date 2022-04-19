package com.decryptor.dto;


import com.decryptor.domain.RequestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHistoryResponse {

    private List<RequestEntity> requests;

}
