package state;

import progress.PlayerProfile;
import progress.EconomyManager;

public class SelectionState implements GameState {

    @Override
    public void enter(PlayerProfile profile, EconomyManager economy) {
        System.out.println("=== SELECTION MENU ===");
        System.out.println("Select pilot, team, car, track, weather...");
    }

    @Override
    public void handle(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Selection logic is handled by SelectionService + UI.");
    }

    @Override
    public void exit(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Leaving SELECTION MENU.");
    }
}
