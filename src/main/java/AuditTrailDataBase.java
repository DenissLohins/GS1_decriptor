
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

class AuditTrailDataBase {

    private ArrayList<String> dataBase = new ArrayList<>();
//    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private SequenceIdGenerator sequenceIdGenerator = new SequenceIdGenerator();

    void add(String query) {
        Instant timestamp = Instant.now();
        String resultString = timestamp + " - \"" + query + "\"";
        dataBase.add(sequenceIdGenerator.generateId(), resultString);
    }

    void printAuditTrail() {
        for (int i = 0; i < dataBase.size(); i++) {
            System.out.println(dataBase.get(i));
        }
    }

}
