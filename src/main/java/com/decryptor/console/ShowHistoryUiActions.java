package com.decryptor.console;

import com.decryptor.core.GetHistoryService;
import com.decryptor.dto.GetHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.decryptor.repository.AuditTrailDatabase;
@Order(2)
@Component
public class ShowHistoryUiActions implements UiActions {

    private AuditTrailDatabase database;
@Autowired
    public ShowHistoryUiActions(AuditTrailDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        GetHistoryService service = new GetHistoryService(database);
        GetHistoryResponse response = service.findAll();
        response.printInConsole();
    }

    @Override
    public String getActionName() {
        return "Show history";
    }
}
