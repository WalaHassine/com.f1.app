package core.vehicle;

import core.engine.Engine;
import core.team.Team;

public class Vehicle {
    protected String model;
    protected int baseSpeed;    // 0–100
    protected int handling;     // 0–100
    protected int year;
    protected Engine engine;
    protected Team team;

    public Vehicle(String model, int baseSpeed, int handling,
                   int year, Engine engine, Team team) {
        this.model = model;
        this.baseSpeed = baseSpeed;
        this.handling = handling;
        this.year = year;
        this.engine = engine;
        this.team = team;
    }

    public String getModel() { return model; }
    public int getBaseSpeed() { return baseSpeed; }
    public int getHandling() { return handling; }
    public int getYear() { return year; }
    public Engine getEngine() { return engine; }
    public Team getTeam() { return team; }

    public int getTotalSpeed() {
        return baseSpeed + (engine != null ? engine.getPower() : 0);
    }

    public String getDescription() {
        return "Car " + model + " (" + year + "), team=" +
                (team != null ? team.getName() : "N/A") +
                ", speed=" + getTotalSpeed() +
                ", handling=" + handling +
                ", engine=" + (engine != null ? engine.getName() : "N/A");
    }
}
