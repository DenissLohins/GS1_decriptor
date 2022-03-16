package com.decryptor.core;

import com.decryptor.dto.GetHistoryResponse;
import org.springframework.stereotype.Component;
import com.decryptor.repository.AuditTrailDatabase;
@Component
public class GetHistoryService {
    private final AuditTrailDatabase database;

    public GetHistoryService(AuditTrailDatabase database) {
        this.database = database;
    }

    public GetHistoryResponse findAll() {
        return database.getHistory();
    }
}
