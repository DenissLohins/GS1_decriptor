package com.decryptor.repository;

import com.decryptor.dto.GetHistoryResponse;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
//@Repository
public class ArrayListDataBase implements DataBaseInterface{

    private ArrayList<RepositoryObject> dataBase = new ArrayList<>();
    private SequenceIdGenerator sequenceIdGenerator = new SequenceIdGenerator();

    public void add(String query) {
        GetCurrentDateAndTime clock = new GetCurrentDateAndTime();
        RepositoryObject object = new RepositoryObject(sequenceIdGenerator.generateId(), clock.getDate(), clock.getTime(), query);
        dataBase.add(object);

    }

    public GetHistoryResponse getHistory() {
        ArrayList<String> interimResponse = prepareResponse();
        GetHistoryResponse response = new GetHistoryResponse(interimResponse);
        return response;
    }

    private ArrayList<String> prepareResponse(){
        ArrayList<String> interimResponse = new ArrayList<>();
        for (int i = 0; i < dataBase.size(); i++) {
            interimResponse.add(dataBase.get(i).toString());
            }
        return interimResponse;
    }


}
