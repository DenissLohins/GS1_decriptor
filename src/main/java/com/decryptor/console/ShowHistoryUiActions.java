package com.decryptor.console;

import com.decryptor.core.GetHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@AllArgsConstructor
public class ShowHistoryUiActions implements UiActions {

private final GetHistoryService getHistoryService;




    @Override
    public void execute() {
       var response = getHistoryService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Show history";
    }
}
