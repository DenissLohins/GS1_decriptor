import console.*;
import core.Validation.LengthValidationRule;
import core.Validation.NotNullvalidaitonRule;
import core.Validation.ValidatonRule;
import repository.AuditTrailDatabase;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var auditTrailDataBase = new AuditTrailDatabase();
        List<UIAction> actions;
        actions = Arrays.asList(
                new ExitUIAction(),
                new DecryptUIAction(auditTrailDataBase),
                new ShowHistoryUIAction(auditTrailDataBase)

        );
//        List<ValidatonRule> validatonRules;
//        validatonRules = Arrays.asList(
//                new LengthValidationRule(),
//                new NotNullvalidaitonRule()
//        );
        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }
}
