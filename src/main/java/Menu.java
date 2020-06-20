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
        System.out.println();
        System.out.println("Enter your choice: 1 - trivial example / 2 - advanced example / 3 - execute tests / 0 - quit");
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                clearConsole();
                System.out.print(Color.BLACK_BOLD);
                System.out.println("1 - trivial example");
                System.out.print(Color.RESET);
                trivialExample();
                break;
            case 2:
                clearConsole();
                System.out.print(Color.BLACK_BOLD);
                System.out.println("2 - advanced example");
                System.out.print(Color.RESET);
                advancedExample();
                break;
            case 3:
                clearConsole();
                System.out.print(Color.BLACK_BOLD);
                System.out.println("3 - execute tests");
                System.out.print(Color.RESET);
                execTests();
                break;
            case 0:
                System.out.print(Color.BLACK_BOLD);
                System.out.println("0 - Bye...");
                System.out.print(Color.RESET);
                break;
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void execTests() {

        final Process p;
        String line = null;

//        String cmd = "java -jar junit-platform-console-standalone-1.6.2.jar -cp build/classes/java/test:build/classes/java/main --select-class HashTableTest";
        String cmd = "java -jar HashTableTDD/junit-platform-console-standalone-1.6.2.jar -cp HashTableTDD/build/classes/java/test:HashTableTDD/build/classes/java/main --select-class HashTableTest";

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

    public void trivialExample() {

        HashTable<String, String> hashTable = new HashTable();

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("When you need add [key=>value] to HashTable, you will use this code:");
        System.out.print(Color.RESET);

        System.out.print(Color.BLUE);
        System.out.println("hashTable.add(\"keyOne\", \"Red\");");
        System.out.println("hashTable.add(\"keyTwo\", \"Blue\");");
        System.out.println("hashTable.add(\"keyThree\", \"White\");");
        System.out.print(Color.RESET);

        hashTable.add("keyOne", "Red");
        hashTable.add("keyTwo", "Blue");
        hashTable.add("keyThree", "White");

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("When you need get value for key, you will use this code:");
        System.out.print(Color.RESET);

        System.out.print(Color.BLUE);
        System.out.println("hashTable.get(\"keyTwo\");");
        System.out.print(Color.RESET);
        System.out.println("Result: [\"keyTwo\"] => " + hashTable.get("keyTwo"));
    }

    public void advancedExample() {
        HashTable<String, String> hashTable = new HashTable();

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Init HashTable:");
        System.out.print(Color.RESET);
        System.out.println("size = 0; capacity = 4; factor = 0.75");
        hashTable.printTable();
        System.out.println();

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Add two variable:");
        System.out.print(Color.RESET);
        System.out.print(Color.BLUE);
        System.out.println("hashTable.add(\"keyOne\", \"Red\");");
        System.out.println("hashTable.add(\"keyTwo\", \"Blue\");");
        System.out.print(Color.RESET);
        hashTable.add("keyOne", "Red");
        hashTable.add("keyTwo", "Blue");
        hashTable.printTable();

        System.out.println();
        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Check HashTable size:");
        System.out.print(Color.RESET);
        System.out.print(Color.BLUE);
        System.out.println("hashTable.size();");
        System.out.print(Color.RESET);
        System.out.println("Size HashTable is changed: size = " + hashTable.size());

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Add next variable:");
        System.out.print(Color.RESET);
        System.out.print(Color.BLUE);
        System.out.println("hashTable.add(\"keyThree\", \"White\");");
        System.out.print(Color.RESET);
        hashTable.add("keyThree", "White");

        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Capacity has changed now:");
        System.out.print(Color.RESET);
        hashTable.printTable();

        System.out.println();
        System.out.println();
        System.out.print(Color.BLACK_UNDERLINED);
        System.out.println("Remove variable:");
        System.out.print(Color.RESET);
        System.out.print(Color.BLUE);
        System.out.println("hashTable.remove(\"keyTwo\");");
        System.out.print(Color.RESET);
        hashTable.remove("keyTwo");
        hashTable.printTable();
        System.out.println();
    }
}
