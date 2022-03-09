package com.decryptor.console;

import org.springframework.stereotype.Component;

@Component
public class ExitUiActions implements UiActions {
    @Override
    public void execute() {
        System.out.println("Bye-bye");
        System.exit(0);
    }

    @Override
    public String getActionName() {
        return "Exit";
    }
}
