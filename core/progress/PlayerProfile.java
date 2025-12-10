package progress;

import core.pilot.Pilot;
import core.team.Team;
import core.vehicle.Vehicle;
import core.track.Track;
import core.weather.WeatherType;
import core.race.Stats;

public class PlayerProfile {
    private String playerName;
    private Pilot pilot;
    private Team team;
    private Vehicle vehicle;
    private Track track;
    private WeatherType weather;
    private Stats stats = new Stats();

    public PlayerProfile(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() { return playerName; }

    public Pilot getPilot() { return pilot; }
    public void setPilot(Pilot pilot) { this.pilot = pilot; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Track getTrack() { return track; }
    public void setTrack(Track track) { this.track = track; }

    public WeatherType getWeather() { return weather; }
    public void setWeather(WeatherType weather) { this.weather = weather; }

    public Stats getStats() { return stats; }
}
