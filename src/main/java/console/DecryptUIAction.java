package console;

import core.DecryptService;
import repository.AuditTrailDatabase;
import repository.PrefixDatabase;


public class DecryptUIAction implements UIAction {

    private AuditTrailDatabase database;

    public DecryptUIAction(AuditTrailDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        DecryptService service = new DecryptService(new PrefixDatabase(), database);
        service.execute();
    }


    @Override
    public String getActionName() {
        return "Decrypt";
    }
}
