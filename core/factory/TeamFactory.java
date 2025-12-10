package factory;

import core.team.Team;

public class TeamFactory {

    public Team createTeam(String name) {
        switch (name.toLowerCase()) {
            case "red bull":
                return new Team("Red Bull Racing", "RBPT", 95, 90);
            case "mercedes":
                return new Team("Mercedes", "Mercedes", 93, 92);
            case "ferrari":
                return new Team("Ferrari", "Ferrari", 90, 85);
            default:
                return new Team(name, "Generic", 80, 80);
        }
    }
}
