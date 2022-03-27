package com.decryptor.core;

import com.decryptor.dto.GetHistoryResponse;
import com.decryptor.repository.DataBaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetHistoryService {
    @Autowired
    private final DataBaseInterface database;


    public GetHistoryService(DataBaseInterface database) {
        this.database = database;
    }

    public GetHistoryResponse findAll() {
        return database.getHistory();
    }
}
