import java.util.Scanner;

class UI {

    Scanner scanner = new Scanner(System.in);
    DecriptionBuisnesLogic decriptionBuisnesLogic = new DecriptionBuisnesLogic();
    private boolean cycle = true;

    public void startUI() {
        while (cycle) {
            System.out.println("Menu:");
            try {
                System.out.println("1. Decrypt datamtrix");
                System.out.println("2. Show history");
                System.out.println("3. Exit");
                int userChoose = scanner.nextInt();

                switch (userChoose) {
                    case 1:
                        decriptionBuisnesLogic.decrypt();
                        break;
                    case 2:
                        decriptionBuisnesLogic.showHistory();
                    case 3:
                        cycle = false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void main(String[] args) {
        startUI();
    }
}
