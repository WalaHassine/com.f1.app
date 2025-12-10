package progress;

public class EconomyManager {

    private static EconomyManager instance;

    private int totalPoints;

    private EconomyManager() { }

    public static EconomyManager getInstance() {
        if (instance == null) {
            instance = new EconomyManager();
        }
        return instance;
    }

    public void addPoints(int points) {
        totalPoints += points;
        if (totalPoints < 0) totalPoints = 0;
    }

    public boolean spendPoints(int points) {
        if (points <= totalPoints) {
            totalPoints -= points;
            return true;
        }
        return false;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
