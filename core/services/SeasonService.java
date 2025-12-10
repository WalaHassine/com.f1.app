package services;

import core.race.RaceResult;
import core.season.Season;
import progress.EconomyManager;
import progress.PlayerProfile;

public class SeasonService {

    private RaceService raceService = new RaceService();

    public SeasonService(RaceService raceService2) {
        
    }

    public void simulateSeason(PlayerProfile profile, Season season, EconomyManager economy) {
        if (season == null) return;
        System.out.println("Simulating season " + season.getYear());

        for (int i = 0; i < season.getCalendar().length; i++) {
            profile.setTrack(season.getCalendar()[i]);
            System.out.println("Round " + (i + 1) + ": " + profile.getTrack());
            RaceResult result = raceService.simulateRace(profile);
            profile.getStats().addResult(result);
            economy.addPoints(result.getPointsGained());
        }

        System.out.println("Season finished. Total points: " + economy.getTotalPoints());
    }
}
