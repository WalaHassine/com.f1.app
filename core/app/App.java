package app;
/*
import progress.*;
import services.*;
import factory.*;
import state.*;
import ui.ConsoleUtils;

public class App {

    public static void main(String[] args) {

        EconomyManager economy = EconomyManager.getInstance();
        PlayerProfile profile = new PlayerProfile("Player1");

        SelectionService selectionService = new SelectionService();
        StatsService statsService = new StatsService();
        SeasonService seasonService = new SeasonService();
        SeasonFactory seasonFactory = new SeasonFactory();

        GameState currentState = new MenuState();
        boolean running = true;

        while (running) {
            currentState.enter(profile, economy);

            System.out.println("Choose option:");
            System.out.println("1) Selection");
            System.out.println("2) Race");
            System.out.println("3) Quiz");
            System.out.println("4) Season simulation");
            System.out.println("5) Stats");
            System.out.println("0) Exit");

            int choice = ConsoleUtils.readInt("> ");

            switch (choice) {
                case 1:
                    currentState.exit(profile, economy);
                    currentState = new SelectionState();
                    currentState.enter(profile, economy);
                    String pilotName = ConsoleUtils.readLine("Pilot name (e.g. Max Verstappen): ");
                    selectionService.selectPilot(profile, pilotName);

                    String teamName = ConsoleUtils.readLine("Team (Red Bull/Mercedes/Ferrari): ");
                    String carModel = ConsoleUtils.readLine("Car model name: ");
                    int year = ConsoleUtils.readInt("Season year: ");
                    selectionService.selectTeamAndVehicle(profile, teamName, carModel, year);

                    String trackName = ConsoleUtils.readLine("Track (Monza/Spa/Monaco): ");
                    selectionService.selectTrack(profile, trackName, year);
                    selectionService.selectRandomWeather(profile);

                    System.out.println("Selection done.");
                    currentState.exit(profile, economy);
                    currentState = new MenuState();
                    break;

                case 2:
                    currentState.exit(profile, economy);
                    currentState = new RaceState();
                    currentState.enter(profile, economy);
                    currentState.handle(profile, economy);
                    currentState.exit(profile, economy);
                    currentState = new MenuState();
                    break;

                case 3:
                    currentState.exit(profile, economy);
                    currentState = new QuizState();
                    currentState.enter(profile, economy);
                    currentState.handle(profile, economy);
                    currentState.exit(profile, economy);
                    currentState = new MenuState();
                    break;

                case 4:
                    currentState.exit(profile, economy);
                    var season = seasonFactory.buildSimpleSeason(2024);
                    seasonService.simulateSeason(profile, season, economy);
                    currentState = new MenuState();
                    break;

                case 5:
                    statsService.printStats(profile);
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting game...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
 */



import progress.PlayerProfile;
import progress.EconomyManager;

import services.SelectionService;
import services.RaceService;
import services.SeasonService;
import services.StatsService;

import factory.PilotFactory;
import factory.TeamFactory;
import factory.VehicleFactory;
import factory.EngineFactory;
import factory.TrackFactory;
import factory.WeatherFactory;
import factory.SeasonFactory;

import quiz.QuizManager;
import ui.MainMenu;

/**
 * Application entry point. Initializes all core components,
 * managers, factories, and services, then opens the Main Menu.
 */
public class App {

    public static void main(String[] args) {

        // ======================================================
        // 1. INITIALIZATION OF PLAYER PROFILE & ECONOMY SYSTEM
        // ======================================================
        System.out.println("=== Starting F1 Console Game ===");

        PlayerProfile profile = new PlayerProfile("Player1");
        EconomyManager economy = EconomyManager.getInstance(); // Singleton


        // ======================================================
        // 2. INITIALIZATION OF FACTORIES (ABSTRACT FACTORY PATTERN)
        //    These factories encapsulate object creation logic
        //    for core racing entities.
        // ======================================================
        PilotFactory pilotFactory = new PilotFactory();
        TeamFactory teamFactory = new TeamFactory();
        VehicleFactory vehicleFactory = new VehicleFactory();
        EngineFactory engineFactory = new EngineFactory();
        TrackFactory trackFactory = new TrackFactory();
        WeatherFactory weatherFactory = new WeatherFactory();
        SeasonFactory seasonFactory = new SeasonFactory();


        // ======================================================
        // 3. INITIALIZATION OF SERVICES (APPLICATION LOGIC)
        //    Services encapsulate processes such as selection,
        //    race simulation, season simulation, stats generation.
        // ======================================================
        SelectionService selectionService = new SelectionService(
                pilotFactory,
                teamFactory,
                vehicleFactory,
                engineFactory,
                trackFactory,
                weatherFactory
        );

        RaceService raceService = new RaceService();
        SeasonService seasonService = new SeasonService(raceService);
        StatsService statsService = new StatsService();


        // ======================================================
        // 4. INITIALIZATION OF QUIZ SYSTEM
        //    (question generation, quiz construction)
        // ======================================================
        QuizManager quizManager = new QuizManager();


        // ======================================================
        // 5. INITIALIZATION OF MAIN MENU (UI LAYER)
        //    The main orchestrator of user interactions.
        // ======================================================
        MainMenu menu = new MainMenu(
                profile,
                economy,
                selectionService,
                raceService,
                seasonService,
                statsService,
                seasonFactory,
                quizManager
        );


        // ======================================================
        // 6. START APPLICATION LOOP
        // ======================================================
        menu.run();

        System.out.println("=== Application closed ===");
    }
}
