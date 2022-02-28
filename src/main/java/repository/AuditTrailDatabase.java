package repository;

import dto.GetHistoryResponse;

import java.time.Instant;
import java.util.ArrayList;

public class AuditTrailDatabase {

    private ArrayList<RepositoryObject> dataBase = new ArrayList<>();
    private SequenceIdGenerator sequenceIdGenerator = new SequenceIdGenerator();

    public void add(String query) {
        GetCurrentDateAndTime clock = new GetCurrentDateAndTime();
        RepositoryObject object = new RepositoryObject(sequenceIdGenerator.generateId(), clock.getDate(), clock.getTime(), query);
        dataBase.add(object);

    }

    public GetHistoryResponse getHistory() {
        GetHistoryResponse response = new GetHistoryResponse();
        for (int i = 0; i < dataBase.size(); i++) {
            response.add(dataBase.get(i));
        }
        return response;
//        for (int i = 0; i < dataBase.size(); i++) {
//            System.out.println(dataBase.get(i));
//        }
    }

}
