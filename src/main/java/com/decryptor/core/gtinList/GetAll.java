package com.decryptor.core.gtinList;

import com.decryptor.domain.GTINEntity;
import com.decryptor.dto.GetAllGtinResponse;
import com.decryptor.repository.HibernateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetAll {

    @Autowired
    private final HibernateRepository<GTINEntity> database;


    public GetAllGtinResponse findAll() {
        var requests = database.getAll().stream()
                .toList();
        return new GetAllGtinResponse(requests);
    }
}
