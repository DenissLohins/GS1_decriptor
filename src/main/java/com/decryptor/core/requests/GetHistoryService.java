package com.decryptor.core.requests;

import com.decryptor.dto.GetHistoryResponse;
import com.decryptor.repository.RequestHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetHistoryService {

    @Autowired
    private final RequestHistoryRepository database;

    public GetHistoryResponse findAll() {
        var requests = database.findAll();
        return new GetHistoryResponse(requests);
    }
}
