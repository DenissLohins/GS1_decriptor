package com.decryptor.core.requests;

import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.GetHistoryResponse;
import com.decryptor.repository.HibernateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetHistoryService {

    @Autowired
    private final HibernateRepository<RequestEntity> database;

    public GetHistoryResponse findAll() {
        var requests = database.getAll().stream()
                .toList();
        return new GetHistoryResponse(requests);
    }
}
