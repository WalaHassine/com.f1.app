package ui;

import core.weather.WeatherType;
import progress.PlayerProfile;
import services.SelectionService;


public class WeatherMenu {

    private final SelectionService selectionService;
    private final PlayerProfile profile;

    public WeatherMenu(SelectionService selectionService, PlayerProfile profile) {
        this.selectionService = selectionService;
        this.profile = profile;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("=====================  WEATHER SELECTION ===================== ");
        System.out.println("1) Random weather");
        System.out.println("2) Manual selection");
        int choice = ConsoleUtils.readInt("> ");

        switch (choice) {
            case 1 -> {
                selectionService.selectRandomWeather(profile);
                System.out.println("Random weather selected: " + profile.getWeather());
            }
            case 2 -> {
                System.out.println("Weather types:");
                for (WeatherType wt : WeatherType.values()) {
                    System.out.println("- " + wt);
                }
                String w = ConsoleUtils.readLine("Enter weather type: ");
                try {
                    WeatherType type = WeatherType.valueOf(w.trim().toUpperCase());
                    profile.setWeather(type);
                    System.out.println("Weather set to: " + type);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid weather type, keeping previous value: " + profile.getWeather());
                }
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}
