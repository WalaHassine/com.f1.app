package state;

import progress.PlayerProfile;
import progress.EconomyManager;

public interface GameState {
    void enter(PlayerProfile profile, EconomyManager economy);
    void handle(PlayerProfile profile, EconomyManager economy);
    void exit(PlayerProfile profile, EconomyManager economy);
}
