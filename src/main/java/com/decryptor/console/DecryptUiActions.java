package com.decryptor.console;

import com.decryptor.core.DecryptService;
import com.decryptor.dto.DecryptRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Order(1)
@Component
@AllArgsConstructor
public class DecryptUiActions implements UiActions {
@Autowired
    private final DecryptService decryptService;


    @Override
    public void execute() {
        DecryptRequest request = new DecryptRequest(getInput());
        decryptService.execute(request);
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter code to decrypt: ");
        String input = scanner.nextLine();
        return input;
    }



    @Override
    public String getActionName() {
        return "Decrypt";
    }
}
