package services;

import core.pilot.Pilot;
import core.team.Team;
import core.vehicle.Vehicle;
import core.engine.Engine;
import core.track.Track;
import core.weather.WeatherType;
import factory.*;
import progress.PlayerProfile;

public class SelectionService {

    private PilotFactory pilotFactory = new PilotFactory();
    private TeamFactory teamFactory = new TeamFactory();
    private EngineFactory engineFactory = new EngineFactory();
    private VehicleFactory vehicleFactory = new VehicleFactory();
    private TrackFactory trackFactory = new TrackFactory();
    private WeatherFactory weatherFactory = new WeatherFactory();

    public SelectionService(PilotFactory pilotFactory2, TeamFactory teamFactory2, VehicleFactory vehicleFactory2,
            EngineFactory engineFactory2, TrackFactory trackFactory2, WeatherFactory weatherFactory2) {
        
    }

    public void selectPilot(PlayerProfile profile, String pilotName) {
        Pilot pilot = pilotFactory.createPilot(pilotName);
        profile.setPilot(pilot);
    }

    public void selectTeamAndVehicle(PlayerProfile profile, String teamName, String carModel, int year) {
        Team team = teamFactory.createTeam(teamName);
        Engine engine = engineFactory.createEngineForTeam(teamName);
        Vehicle vehicle = vehicleFactory.createVehicle(carModel, year, team, engine);

        profile.setTeam(team);
        profile.setVehicle(vehicle);
    }

    public void selectTrack(PlayerProfile profile, String trackName, int year) {
        Track track = trackFactory.createTrack(trackName, year);
        profile.setTrack(track);
    }

    public void selectRandomWeather(PlayerProfile profile) {
        WeatherType weather = weatherFactory.randomWeather();
        profile.setWeather(weather);
    }
}
