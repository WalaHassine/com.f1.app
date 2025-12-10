package ui;

import core.engine.Engine;
import progress.PlayerProfile;


public class EngineMenu {

    private final PlayerProfile profile;

    public EngineMenu(PlayerProfile profile) {
        this.profile = profile;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("===================== ENGINE INFORMATION ===================== ");

        if (profile.getVehicle() == null || profile.getVehicle().getEngine() == null) {
            System.out.println("No vehicle/engine selected.");
            return;
        }

        Engine e = profile.getVehicle().getEngine();
        System.out.println("Engine: " + e.getName());
        System.out.println("Specs: " + e.getSpecs());
    }
}
