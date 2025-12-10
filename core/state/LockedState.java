package state;

import progress.EconomyManager;
import progress.PlayerProfile;

public class LockedState implements GameState {

    private String featureName;
    private int requiredPoints;

    public LockedState(String featureName, int requiredPoints) {
        this.featureName = featureName;
        this.requiredPoints = requiredPoints;
    }

    @Override
    public void enter(PlayerProfile profile, EconomyManager economy) {
        System.out.println("=== FEATURE LOCKED ===");
    }

    @Override
    public void handle(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Feature '" + featureName + "' requires " +
                           requiredPoints + " points.");
        System.out.println("You currently have: " + economy.getTotalPoints());
    }

    @Override
    public void exit(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Leaving LOCKED SCREEN.");
    }
}
