import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class DecriptionBuisnesLogic {

    private AuditTrailDataBase database = new AuditTrailDataBase();


    void decrypt() {
        Scanner scanner = new Scanner(System.in);
        PrefixDatabase prefixDatabase = new PrefixDatabase();
        ArrayList<String> usedPrefix = new ArrayList<String>();
        String output = "";
        int position = 0;
        int fieldLength = 0;
        System.out.println("Please enter code to decrypt: ");
        String input = scanner.nextLine();
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
                    for (int i = position; i < position + temporaryLength - 1; i++) {
                        String findPrefix = "";
                        findPrefix = findPrefix + inputChars[i];
                        findPrefix = findPrefix + inputChars[i + 1];
                        if (prefixDatabase.contains(findPrefix)) {
                            if (usedPrefix.contains(findPrefix)) {
                                i++;
                            } else {
                                fieldLength = i;
                                break;
                            }
                        }
                    }
                    for (int i = position; i < fieldLength; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + "; ";
                    position = fieldLength;
                } else {
                    for (int i = position; i < position + length; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + "; ";
                    position = position + length;
                    if (position == inputChars.length) {
                        work = false;
                    }
                }
            }



/*
            if (inputChars[position] == '0' && inputChars[position + 1] == '1') {
                output = output + "GTIN: ";
                position = position + 2;
                for (int i = position; i < position + 14; i++) {
                    output = output + inputChars[i];
                }
                output = output + "; ";
                position = position + 14;
                if (inputChars[position] == '2' && inputChars[position + 1] == '1') {
                    output = output + "SN: ";
                    position = position + 2;
                    for (int i = position; i < position + 19; i++) {
                        if (inputChars[i] == '1' && inputChars[i + 1] == '0') {
                            fieldLength = i;
                            break;
                        }
                    }
                    for (int i = position; i < fieldLength; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + "; ";
                    position = fieldLength;
                }
                if (inputChars[position] == '1' && inputChars[position + 1] == '0') {
                    output = output + "Batch No.: ";
                    position = position + 2;
                    for (int i = position; i < position + 7; i++) {
                        if (inputChars[i] == '1' && inputChars[i + 1] == '7') {
                            batchNumberFinalPosition = i;
                            break;
                        }
                    }
                    for (int i = position; i < batchNumberFinalPosition; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + "; ";
                    position = batchNumberFinalPosition;
                }
                if (inputChars[position] == '1' && inputChars[position + 1] == '7') {
                    output = output + "Expiration date (YYMMDD): ";
                    position = position + 2;
                    for (int i = position; i < position + 6; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + ".";
                }
            }
*/
        } else {
            System.err.println("Wrong input!");
        }

        System.out.println(output);
    }

    void showHistory() {
        database.printAuditTrail();
    }
}
