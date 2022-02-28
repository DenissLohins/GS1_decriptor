import console.*;
import repository.AuditTrailDatabase;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var auditTrailDataBase = new AuditTrailDatabase();
        List<UIAction> actions;
        actions = Arrays.asList(
                new DecryptUIAction(auditTrailDataBase),
                new ShowHistoryUIAction(auditTrailDataBase),
                new ExitUIAction()
                );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }
}
