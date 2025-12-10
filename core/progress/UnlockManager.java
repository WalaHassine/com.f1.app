package progress;

import java.util.HashSet;
import java.util.Set;

public class UnlockManager {
    private Set<String> unlockedIds = new HashSet<>();

    public boolean isUnlocked(Unlockable u) {
        return unlockedIds.contains(u.getId());
    }

    public boolean unlock(Unlockable u, EconomyManager economy) {
        if (isUnlocked(u)) return true;
        if (economy.getTotalPoints() >= u.getCost()) {
            economy.spendPoints(u.getCost());
            unlockedIds.add(u.getId());
            return true;
        }
        return false;
    }
}
