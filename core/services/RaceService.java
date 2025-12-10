package services;

import java.util.Random;

import core.race.RaceResult;
import progress.PlayerProfile;

public class RaceService {

    private Random random = new Random();

    public RaceResult simulateRace(PlayerProfile profile) {
        int base = 10;
        if (profile.getVehicle() != null) {
            base += profile.getVehicle().getTotalSpeed() / 10;
            base += profile.getVehicle().getHandling() / 10;
        }
        if (profile.getPilot() != null) {
            base += profile.getPilot().getSkill() / 10;
        }

        int randomness = random.nextInt(15);
        int totalScore = base + randomness;

        int position;
        if (totalScore > 35) position = 1;
        else if (totalScore > 30) position = 2;
        else if (totalScore > 25) position = 3;
        else position = random.nextInt(10) + 4;

        int points = 0;
        switch (position) {
            case 1: points = 25; break;
            case 2: points = 18; break;
            case 3: points = 15; break;
            default: points = Math.max(0, 12 - position);
        }

        boolean fastestLap = random.nextBoolean();
        if (fastestLap) points += 1;

        return new RaceResult(position, fastestLap, points);
    }
}
