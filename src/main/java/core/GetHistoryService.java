package core;

import dto.GetHistoryResponse;
import repository.AuditTrailDatabase;

public class GetHistoryService {
    private final AuditTrailDatabase database;

    public GetHistoryService(AuditTrailDatabase database) {
        this.database = database;
    }

    public GetHistoryResponse findAll() {
        return database.getHistory();
    }
}
