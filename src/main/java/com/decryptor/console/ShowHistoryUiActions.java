package com.decryptor.console;

import com.decryptor.core.GetHistoryService;
import com.decryptor.dto.GetHistoryResponse;
import com.decryptor.repository.DataBaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ShowHistoryUiActions implements UiActions {
@Autowired
    public DataBaseInterface database;

    public ShowHistoryUiActions(DataBaseInterface database) {
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
