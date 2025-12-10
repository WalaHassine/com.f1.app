package state;

import progress.PlayerProfile;
import progress.EconomyManager;

public class MenuState implements GameState {

    @Override
    public void enter(PlayerProfile profile, EconomyManager economy) {
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Selection");
        System.out.println("2. Race");
        System.out.println("3. Quiz");
        System.out.println("4. Exit");
    }

    @Override
    public void handle(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Waiting for user input in UI layer...");
    }

    @Override
    public void exit(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Leaving MAIN MENU.");
    }
}
