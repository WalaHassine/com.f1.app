package factory;

import core.pilot.Pilot;

public class PilotFactory {

    public Pilot createPilot(String name) {
        switch (name.toLowerCase()) {
            case "max verstappen":
                return new Pilot("Max Verstappen", "Netherlands", 96, 8);
            case "lewis hamilton":
                return new Pilot("Lewis Hamilton", "UK", 95, 15);
            default:
                return new Pilot(name, "Unknown", 80, 1);
        }
    }
}
