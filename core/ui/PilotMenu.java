package ui;

import progress.PlayerProfile;
import services.SelectionService;


public class PilotMenu {

    private final SelectionService selectionService;
    private final PlayerProfile profile;

    public PilotMenu(SelectionService selectionService, PlayerProfile profile) {
        this.selectionService = selectionService;
        this.profile = profile;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=== PILOT SELECTION ===");
        System.out.println("Examples: Max Verstappen, Lewis Hamilton, Charles Leclerc");
        String name = ConsoleUtils.readLine("Enter pilot name: ");

        selectionService.selectPilot(profile, name);
        System.out.println("Pilot selected: " + profile.getPilot());
    }
}
