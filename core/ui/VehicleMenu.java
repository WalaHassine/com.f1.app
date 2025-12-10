package ui;

import core.race.RaceResult;
import core.vehicle.Vehicle;
import core.vehicle.decorator.AeroKit;
import core.vehicle.decorator.EngineUpgrade;
import core.vehicle.decorator.TyrePackage;
import progress.EconomyManager;
import progress.PlayerProfile;
import services.RaceService;

public class VehicleMenu {

    private final RaceService raceService;
    private final PlayerProfile profile;
    private final EconomyManager economy;

    public VehicleMenu(RaceService raceService,
                       PlayerProfile profile,
                       EconomyManager economy) {
        this.raceService = raceService;
        this.profile = profile;
        this.economy = economy;
    }

    public void show() {
        if (profile.getVehicle() == null) {
            System.out.println("No vehicle selected. Please go to Team & Vehicle selection first.");
            return;
        }

        boolean done = false;
        Vehicle current = profile.getVehicle();

        while (!done) {
            ConsoleUtils.printSeparator();
            System.out.println("=====================  VEHICLE MENU ===================== ");
            System.out.println("Current: " + current.getDescription());
            System.out.println("Player points: " + economy.getTotalPoints());
            System.out.println("1) Add Aero Kit (cost: 10 pts)");
            System.out.println("2) Add Engine Upgrade (cost: 15 pts)");
            System.out.println("3) Add Tyre Package (cost: 8 pts)");
            System.out.println("4) Start race with current vehicle");
            System.out.println("0) Return to main menu");

            int choice = ConsoleUtils.readInt("> ");

            switch (choice) {
                case 1 -> {
                    if (economy.spendPoints(10)) {
                        current = new AeroKit(current);
                        System.out.println("Aero Kit applied.");
                    } else {
                        System.out.println("Not enough points.");
                    }
                }
                case 2 -> {
                    if (economy.spendPoints(15)) {
                        current = new EngineUpgrade(current);
                        System.out.println("Engine Upgrade applied.");
                    } else {
                        System.out.println("Not enough points.");
                    }
                }
                case 3 -> {
                    if (economy.spendPoints(8)) {
                        current = new TyrePackage(current);
                        System.out.println("Tyre Package applied.");
                    } else {
                        System.out.println("Not enough points.");
                    }
                }
                case 4 -> {
                    // temporarily assign decorated vehicle to profile
                    profile.setVehicle(current);
                    RaceResult result = raceService.simulateRace(profile);
                    profile.getStats().addResult(result);
                    economy.addPoints(result.getPointsGained());
                    System.out.println("Race finished: position=" + result.getPosition() +
                            ", fastestLap=" + result.hasFastestLap() +
                            ", points gained=" + result.getPointsGained() +
                            ", total points=" + economy.getTotalPoints());
                }
                case 0 -> done = true;
                default -> System.out.println("Invalid choice.");
            }
        }

        // Keep the latest decorated car in the profile
        profile.setVehicle(current);
    }
}
