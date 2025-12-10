package ui;

import java.util.Scanner;


public final class ConsoleUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleUtils() {
        // Utility class, no instances.
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = SCANNER.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, please try again.");
            }
        }
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    public static void printSeparator() {
        System.out.println("----------------------------------------------------");
    }

    public static void pressEnterToContinue() {
        System.out.println("Press ENTER to continue...");
        SCANNER.nextLine();
    }
}
