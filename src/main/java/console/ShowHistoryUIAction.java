package console;

import core.GetHistoryService;
import dto.GetHistoryResponse;
import repository.AuditTrailDatabase;

public class ShowHistoryUIAction implements UIAction{

    private AuditTrailDatabase database;

    public ShowHistoryUIAction(AuditTrailDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        GetHistoryService service = new GetHistoryService(database);
        GetHistoryResponse response = service.findAll();
        response.printInConsole();
    }

    @Override
    public String getActionName() {
        return "Show history";
    }
}
