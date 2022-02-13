package console;

import repository.AuditTrailDatabase;

public class ShowHistoryUIAction implements UIAction{

    private AuditTrailDatabase database;

    public ShowHistoryUIAction(AuditTrailDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.printAuditTrail();
    }

    @Override
    public String getActionName() {
        return "Show history";
    }
}
