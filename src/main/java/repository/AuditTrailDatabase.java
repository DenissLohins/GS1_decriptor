package repository;

import java.time.Instant;
import java.util.ArrayList;

public class AuditTrailDatabase {

    private ArrayList<String> dataBase = new ArrayList<>();
    private SequenceIdGenerator sequenceIdGenerator = new SequenceIdGenerator();

    public void add(String query) {
        Instant timestamp = Instant.now();
        String resultString = timestamp + " - \"" + query + "\"";
        dataBase.add(sequenceIdGenerator.generateId(), resultString);
    }

    public void printAuditTrail() {
        for (int i = 0; i < dataBase.size(); i++) {
            System.out.println(dataBase.get(i));
        }
    }

}
