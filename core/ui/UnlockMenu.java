package ui;

import progress.EconomyManager;


public class UnlockMenu {

    private final EconomyManager economy;

    public UnlockMenu(EconomyManager economy) {
        this.economy = economy;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=====================  UNLOCK MENU ===================== ");
        System.out.println("This is a placeholder for unlockable content.");
        System.out.println("Your current points: " + economy.getTotalPoints());
        System.out.println("In a full version, you would see a list of items to unlock.");
    }
}
