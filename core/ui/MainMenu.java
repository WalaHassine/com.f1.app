package ui;

import progress.EconomyManager;
import progress.PlayerProfile;
import services.SelectionService;
import services.RaceService;
import services.SeasonService;
import services.StatsService;
import factory.SeasonFactory;
import quiz.QuizManager;

public class MainMenu {

    private final PlayerProfile profile;
    private final EconomyManager economy;
    private final SelectionService selectionService;
    private final RaceService raceService;
    private final SeasonService seasonService;
    private final StatsService statsService;
    private final SeasonFactory seasonFactory;
    private final QuizManager quizManager;

    public MainMenu(PlayerProfile profile,
                    EconomyManager economy,
                    SelectionService selectionService,
                    RaceService raceService,
                    SeasonService seasonService,
                    StatsService statsService,
                    SeasonFactory seasonFactory,
                    QuizManager quizManager) {
        this.profile = profile;
        this.economy = economy;
        this.selectionService = selectionService;
        this.raceService = raceService;
        this.seasonService = seasonService;
        this.statsService = statsService;
        this.seasonFactory = seasonFactory;
        this.quizManager = quizManager;
    }

    public void run() {
        boolean running = true;

        while (running) {
            ConsoleUtils.printSeparator();
            System.out.println("=====================  F1 CONSOLE GAME – MAIN MENU ===================== ");
            System.out.println("Player: " + profile.getPlayerName() +
                    " | Points: " + economy.getTotalPoints());
            System.out.println("1) Pilot selection");
            System.out.println("2) Team & vehicle selection");
            System.out.println("3) Track & weather selection");
            System.out.println("4) Start single race");
            System.out.println("5) Play F1 quiz (earn points)");
            System.out.println("6) Run season simulation");
            System.out.println("7) Unlock content");
            System.out.println("8) View statistics");
            System.out.println("0) Exit");
            int choice = ConsoleUtils.readInt("> ");

            switch (choice) {
                case 1 -> new PilotMenu(selectionService, profile).show();
                case 2 -> new TeamMenu(selectionService, profile).show();
                case 3 -> {
                    new TrackMenu(selectionService, profile).show();
                    new WeatherMenu(selectionService, profile).show();
                }
                case 4 -> new VehicleMenu(raceService, profile, economy).show();
                case 5 -> new QuizMenu(quizManager, economy).show();
                case 6 -> new SeasonMenu(seasonFactory, seasonService, profile, economy).show();
                case 7 -> new UnlockMenu(economy).show();
                case 8 -> statsService.printStats(profile);
                case 0 -> {
                    System.out.println("Exiting the game. Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }

            if (running) {
                ConsoleUtils.pressEnterToContinue();
            }
        }
    }
}
