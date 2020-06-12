import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.clearConsole();
        System.out.println("****** HashTable ******");
        menu.runMenu();
    }

    public void runMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = getInput();
            performAction(choice);
        } while (choice != 0);
    }

    private int getInput() {
        int choice;
        Scanner kb = new Scanner(System.in);
        try {
            choice = kb.nextInt();
        } catch (InputMismatchException e) {
            choice = 4;
        }
        return choice;
    }

    private void printMenu() {
        System.out.println("");
        System.out.println("Enter your choice: 1 - trivial example / 2 - advanced example / 3 - execute tests / 0 - quit");
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                clearConsole();
                System.out.println("Your choice is: 1");
                break;
            case 2:
                clearConsole();
                System.out.println("Your choice is: 2");
                break;
            case 3:
                clearConsole();
                System.out.println("Exec tests:");
                execTests();
                break;
            case 0:
                System.out.println("Bye...");
                break;
        }
    }

    private void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void execTests() {

        final Process p;
        String line = null;

        String cmd = "java -jar junit-platform-console-standalone-1.6.2.jar -cp build/classes/java/test:build/classes/java/main --select-class HashTableTest";
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            try {
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
    }
}
