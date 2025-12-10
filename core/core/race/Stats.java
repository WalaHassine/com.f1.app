package core.race;

public class Stats {
    private int races;
    private int wins;
    private int podiums;
    private int totalPoints;

    public void addResult(RaceResult result) {
        races++;
        totalPoints += result.getPointsGained();
        if (result.getPosition() == 1) wins++;
        if (result.getPosition() <= 3) podiums++;
    }

    public int getRaces() { return races; }
    public int getWins() { return wins; }
    public int getPodiums() { return podiums; }
    public int getTotalPoints() { return totalPoints; }
}
