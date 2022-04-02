package com.decryptor.console;

import com.decryptor.core.DecryptService;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.repository.DataBaseInterface;
import com.decryptor.repository.HibernateRepository;
import com.decryptor.repository.HibernateRequestHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.decryptor.repository.PrefixDatabase;

import java.util.Scanner;
@Order(1)
@Component
public class DecryptUiActions implements UiActions {
@Autowired
    public HibernateRequestHistoryRepository database;
@Autowired
    public DecryptUiActions(HibernateRequestHistoryRepository database) {
        this.database = database;
    }

    @Override
    public void execute() {
        DecryptService service = new DecryptService(new PrefixDatabase(), database);
        DecryptRequest request = new DecryptRequest(getInput());
        service.execute(request);
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
