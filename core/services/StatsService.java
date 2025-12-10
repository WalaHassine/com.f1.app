package services;

import progress.PlayerProfile;

public class StatsService {

    public void printStats(PlayerProfile profile) {
        var s = profile.getStats();
        System.out.println("=====================  PLAYER STATS ===================== ");
        System.out.println("Races: " + s.getRaces());
        System.out.println("Wins: " + s.getWins());
        System.out.println("Podiums: " + s.getPodiums());
        System.out.println("Championship points: " + s.getTotalPoints());
    }
}
