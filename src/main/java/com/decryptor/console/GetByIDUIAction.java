package com.decryptor.console;

import com.decryptor.core.GetByIDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class GetByIDUIAction implements UiActions{

    private final GetByIDService getByIDService;

    @Override
    public void execute() {
        System.out.println("Please enter todo id:");
        var scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        var result = getByIDService.getByID(id);
        System.out.println("Result: " + result);

    }

    @Override
    public String getActionName() {
        return "Find By ID";
    }
}
