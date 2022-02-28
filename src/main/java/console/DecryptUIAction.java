package console;

import core.DecryptService;
import dto.DecryptRequest;
import repository.AuditTrailDatabase;
import repository.PrefixDatabase;

import java.util.Scanner;


public class DecryptUIAction implements UIAction {

    private AuditTrailDatabase database;

    public DecryptUIAction(AuditTrailDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        DecryptService service = new DecryptService(new PrefixDatabase(), database);
        DecryptRequest request = new DecryptRequest(getInput());
        service.execute(request);
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter code to decrypt: ");
        String input = scanner.nextLine();
        return input;
    }



    @Override
    public String getActionName() {
        return "Decrypt";
    }
}
