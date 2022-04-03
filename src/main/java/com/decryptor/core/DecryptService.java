package com.decryptor.core;

import com.decryptor.core.Validation.ValidationService;
import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DecryptService {
    PrefixDatabase prefixDatabase;
    ArrayList<String> usedPrefix = new ArrayList<String>();
    @Autowired
    private HibernateRepository database;
    @Autowired
    private final KnownGTINNames gtinNames = new KnownGTINNames();
    @Autowired
    private ValidationService validationService;
    private GetCurrentDateAndTime getCurrentDateAndTime = new GetCurrentDateAndTime();


    public void execute(DecryptRequest request) {
        String output = "";
        int position = 0;
        int finalPosition = 0;
        String input = request.getRequestString();
        var requestEntity = new RequestEntity();
        requestEntity.setRequest(input);
        requestEntity.setDate(getCurrentDateAndTime.getDate());
        requestEntity.setTime(getCurrentDateAndTime.getTime());
        database.add(requestEntity);
//        var validationResult = validationService.validate(request);
//        if (!validationResult.isEmpty()) {
//            System.out.println("Validation failed, errors: " + validationResult);
//            var response = new DecryptResponse();
//            response.setErrors(validationResult);
//            System.out.println(response);
//        }
        var inputChars = input.toCharArray();
        if (inputChars[position] == ']' && inputChars[position + 1] == '2') {
            position = position + 2;
            boolean work = true;
            while (work) {
                String prefix = "";
                prefix = prefix + inputChars[position];
                prefix = prefix + inputChars[position + 1];
                usedPrefix.add(prefix);
                position = position + 2;
                String codeName = prefixDatabase.getName(prefix);
                int length = prefixDatabase.find(prefix);
                output = output + codeName;
                if (codeName == "GTIN: ") {
                    output = output + "(" + fillProductNameByGTIN(position, inputChars) + ") ";
                }
                if (length < 0) {
                    int temporaryLength = -length;
                    finalPosition = getFinalPosition(prefixDatabase, usedPrefix, position, finalPosition, inputChars, temporaryLength);
                    output = output + fillFieldData(position, inputChars, finalPosition);
                    position = finalPosition;
                } else {
                    int endPosition = position + length;
                    output = output + fillFieldData(position, inputChars, endPosition);
                    position = endPosition;
                    if (position == inputChars.length) {
                        work = false;
                    }
                }
            }
        } else {
            System.err.println("Wrong input!");
        }
        System.out.println(output);
    }

    private int getFinalPosition(PrefixDatabase prefixDatabase, ArrayList<String> usedPrefix, int position, int finalPosition, char[] inputChars, int temporaryLength) {
        for (int i = position; i < position + temporaryLength - 1; i++) {
            String findPrefix = "";
            findPrefix = findPrefix + inputChars[i];
            findPrefix = findPrefix + inputChars[i + 1];
            if (prefixDatabase.contains(findPrefix)) {
                if (usedPrefix.contains(findPrefix)) {
                    i++;
                } else {
                    finalPosition = i;
                    break;
                }
            }
        }
        return finalPosition;
    }

    private String fillFieldData(int position, char[] inputChars, int finalposition) {
        String output = "";
        for (int i = position; i < finalposition; i++) {
            output = output + inputChars[i];
        }
        output = output + "; ";
        return output;
    }

    private String fillProductNameByGTIN(int position, char[] inputChars) {
        String gtin = "";
        for (int i = position; i < position + 14; i++) {
            gtin = gtin + inputChars[i];
        }
        String productName = gtinNames.getNameByGTIN(gtin);
        return productName;
    }
}
