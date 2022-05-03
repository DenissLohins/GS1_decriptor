package com.decryptor.core.requests;

import com.decryptor.core.requests.Validation.RequestValidationService;
import com.decryptor.domain.GTINEntity;
import com.decryptor.domain.RequestEntity;
import com.decryptor.dto.DecryptRequest;
import com.decryptor.dto.DecryptResponse;
import com.decryptor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DecryptService {

    PrefixDatabase prefixDatabase = new PrefixDatabase();

    private GTINEntity gtinEntity;

    @Autowired
    private HibernateRequestHistoryRepository database;

    @Autowired
    private HibernateGTINRepository gtinNames;


    @Autowired
    private RequestValidationService requestValidationService;
    private GetCurrentDateAndTime getCurrentDateAndTime = new GetCurrentDateAndTime();


    public DecryptResponse execute(DecryptRequest request) {
        String output = "";
        ArrayList<String> usedPrefix = new ArrayList<String>();
        int position = 0;
        int finalPosition = 0;
        String input = request.getRequestString();
        var requestEntity = new RequestEntity();
        requestEntity.setRequest(input);
        requestEntity.setDate(getCurrentDateAndTime.getDate());
        requestEntity.setTime(getCurrentDateAndTime.getTime());
        database.save(requestEntity);
        var validationResult = requestValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new DecryptResponse();
            response.setErrors(validationResult);
            return response;
        }
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
                var codeName = prefixDatabase.getName(prefix);
                Integer length = prefixDatabase.find(prefix);
                output = output + codeName;
                if (codeName == "GTIN: ") {
                    var gtinNumber = getGTINFromString(position, inputChars);
                    var gtinEntity = gtinNames.getByGTIN(gtinNumber);
                    if(gtinEntity.isPresent()){
                        output = output + "(" + gtinEntity.get().getName() + ") ";
                        requestEntity.setProductID(gtinEntity.get().getGtin());
                    }
                }
                if (length < 0) {
                    var temporaryLength = -length;
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
            database.update(requestEntity);
        } else {
            database.update(requestEntity);
            System.err.println("Wrong input!");
        }
        var response = new DecryptResponse();
        response.setID(requestEntity.getId());
        response.setRequest(requestEntity.getRequest());
        response.setDecryptedInformation(output);
        return response;
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

    private String getGTINFromString(int position, char[] inputChars) {
        String gtin = "";
        for (int i = position; i < position + 14; i++) {
            gtin = gtin + inputChars[i];
        }
        return gtin;
    }
}
