package state;

import core.race.RaceResult;
import progress.EconomyManager;
import progress.PlayerProfile;
import services.RaceService;

public class RaceState implements GameState {

    private RaceService raceService = new RaceService();

    @Override
    public void enter(PlayerProfile profile, EconomyManager economy) {
        System.out.println("=== RACE START ===");
    }

    @Override
    public void handle(PlayerProfile profile, EconomyManager economy) {
        RaceResult result = raceService.simulateRace(profile);
        profile.getStats().addResult(result);
        economy.addPoints(result.getPointsGained());
        System.out.println("Race finished, gained " + result.getPointsGained() +
                           " points. Total=" + economy.getTotalPoints());
    }

    @Override
    public void exit(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Leaving RACE.");
    }
}
