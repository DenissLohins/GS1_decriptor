import java.util.Scanner;

class DecriptorApplication {

    public static void main(String[] args) {
        String output = "";
        int position = 2;
        int serialNumberEdnPosition = 0;
        int batchNumberFinalPosition = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter code to decrypt: ");
        String input = scanner.nextLine();
        var inputChars = input.toCharArray();
        if (inputChars[0] == ']' && inputChars[1] == '2') {
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
                            serialNumberEdnPosition = i;
                            break;
                        }
                    }
                    for (int i = position; i < serialNumberEdnPosition; i++) {
                        output = output + inputChars[i];
                    }
                    output = output + "; ";
                    position = serialNumberEdnPosition;
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
                    for (int i = position; i <batchNumberFinalPosition; i++) {
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
        } else {
            System.err.println("Wrong input!");
        }

        System.out.println(output);
    }
}
