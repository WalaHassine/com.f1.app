package ui;

import progress.PlayerProfile;
import services.SelectionService;


public class TeamMenu {

    private final SelectionService selectionService;
    private final PlayerProfile profile;

    public TeamMenu(SelectionService selectionService, PlayerProfile profile) {
        this.selectionService = selectionService;
        this.profile = profile;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=====================  TEAM & VEHICLE SELECTION ===================== ");
        System.out.println("Available examples: Red Bull, Mercedes, Ferrari");
        String teamName = ConsoleUtils.readLine("Team name: ");
        String carModel = ConsoleUtils.readLine("Car model (e.g., RB19, W14, SF-23): ");
        int year = ConsoleUtils.readInt("Season year (e.g., 2023): ");

        selectionService.selectTeamAndVehicle(profile, teamName, carModel, year);

        System.out.println("Team selected: " + profile.getTeam());
        System.out.println("Vehicle selected: " + profile.getVehicle().getDescription());
    }
}
