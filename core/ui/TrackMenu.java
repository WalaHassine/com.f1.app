package ui;

import progress.PlayerProfile;
import services.SelectionService;

public class TrackMenu {

    private final SelectionService selectionService;
    private final PlayerProfile profile;

    public TrackMenu(SelectionService selectionService, PlayerProfile profile) {
        this.selectionService = selectionService;
        this.profile = profile;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=====================  TRACK SELECTION ===================== ");
        System.out.println("Examples: Monza, Spa, Monaco");
        String name = ConsoleUtils.readLine("Track name: ");
        int year = ConsoleUtils.readInt("Layout year (e.g. 2023): ");

        selectionService.selectTrack(profile, name, year);

        System.out.println("Track selected: " + profile.getTrack());
    }
}
