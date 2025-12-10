package core.race;

public class RaceResult {
    private int position;
    private boolean fastestLap;
    private int pointsGained;

    public RaceResult(int position, boolean fastestLap, int pointsGained) {
        this.position = position;
        this.fastestLap = fastestLap;
        this.pointsGained = pointsGained;
    }

    public int getPosition() { return position; }
    public boolean hasFastestLap() { return fastestLap; }
    public int getPointsGained() { return pointsGained; }
}
