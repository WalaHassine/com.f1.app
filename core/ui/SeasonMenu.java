package ui;

import core.season.Season;
import factory.SeasonFactory;
import progress.EconomyManager;
import progress.PlayerProfile;
import services.SeasonService;


public class SeasonMenu {

    private final SeasonFactory seasonFactory;
    private final SeasonService seasonService;
    private final PlayerProfile profile;
    private final EconomyManager economy;

    public SeasonMenu(SeasonFactory seasonFactory,
                      SeasonService seasonService,
                      PlayerProfile profile,
                      EconomyManager economy) {
        this.seasonFactory = seasonFactory;
        this.seasonService = seasonService;
        this.profile = profile;
        this.economy = economy;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=====================  SEASON SIMULATION ===================== ");
        int year = ConsoleUtils.readInt("Season year: ");
        Season season = seasonFactory.buildSimpleSeason(year);
        System.out.println("Season created with " + season.getCalendar().length +
                " races. Starting simulation...");
        seasonService.simulateSeason(profile, season, economy);
    }
}
