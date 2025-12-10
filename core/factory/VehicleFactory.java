package factory;

import core.engine.Engine;
import core.team.Team;
import core.vehicle.Vehicle;

public class VehicleFactory {

    public Vehicle createVehicle(String model, int year, Team team, Engine engine) {
        int baseSpeed = 70;
        int handling = 75;

        if (team != null) {
            baseSpeed += team.getPerformance() / 5;
            handling += team.getReliability() / 10;
        }

        return new Vehicle(model, baseSpeed, handling, year, engine, team);
    }
}
