import console.DecryptUIAction;
import console.ShowHistoryUIAction;
import console.UIAction;
import console.UIMenu;
import repository.AuditTrailDatabase;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var auditTrailDataBase = new AuditTrailDatabase();
        List<UIAction> actions;
        actions = Arrays.asList(
                new DecryptUIAction(auditTrailDataBase),
                new ShowHistoryUIAction(auditTrailDataBase)
                );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }
}
