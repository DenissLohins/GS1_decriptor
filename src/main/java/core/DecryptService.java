package core;

import repository.AuditTrailDatabase;
import repository.PrefixDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class DecryptService {
    PrefixDatabase prefixDatabase;
    ArrayList<String> usedPrefix = new ArrayList<String>();
    private AuditTrailDatabase database;

    public DecryptService(PrefixDatabase prefixDatabase, AuditTrailDatabase database) {
        this.prefixDatabase = prefixDatabase;
        this.database = database;
    }

    public void execute(){
        String output = "";
        int position = 0;
        int finalPosition = 0;
        String input = getInput();
        database.add(input);
        var inputChars = input.toCharArray();
        if (inputChars[position] == ']' && inputChars[position + 1] == '2') {
            position = position + 2;
            boolean work = true;
            while (work) {
                String prefix = "";
                prefix = prefix + inputChars[position];
                prefix = prefix + inputChars[position + 1];
                usedPrefix.add(prefix);
                position = position + 2;
                String codeName = prefixDatabase.getName(prefix);
                int length = prefixDatabase.find(prefix);
                output = output + codeName;
                if (length < 0) {
                    int temporaryLength = -length;
                    finalPosition = getFinalPosition(prefixDatabase, usedPrefix, position, finalPosition, inputChars, temporaryLength);
                    output = output + fillFieldData(position, inputChars, finalPosition);
                    position = finalPosition;
                } else {
                    int endPosition = position + length;
                    output = output + fillFieldData(position, inputChars, endPosition);
                    position = endPosition;
                    if (position == inputChars.length) {
                        work = false;
                    }
                }
            }
        } else {
            System.err.println("Wrong input!");
        }

        System.out.println(output);
    }

    private int getFinalPosition(PrefixDatabase prefixDatabase, ArrayList<String> usedPrefix, int position, int finalPosition, char[] inputChars, int temporaryLength) {
        for (int i = position; i < position + temporaryLength - 1; i++) {
            String findPrefix = "";
            findPrefix = findPrefix + inputChars[i];
            findPrefix = findPrefix + inputChars[i + 1];
            if (prefixDatabase.contains(findPrefix)) {
                if (usedPrefix.contains(findPrefix)) {
                    i++;
                } else {
                    finalPosition = i;
                    break;
                }
            }
        }
        return finalPosition;
    }

    private String fillFieldData(int position, char[] inputChars, int finalposition) {
        String output = "";
        for (int i = position; i < finalposition; i++) {
            output = output + inputChars[i];
        }
        output = output + "; ";
        return output;
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter code to decrypt: ");
        String input = scanner.nextLine();
        return input;
    }

}
