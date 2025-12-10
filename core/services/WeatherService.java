package services;

import core.weather.WeatherType;
import progress.PlayerProfile;

public class WeatherService {

    public void applyWeatherEffects(PlayerProfile profile) {
        WeatherType w = profile.getWeather();
        if (w == null || profile.getVehicle() == null) return;

        System.out.println("Current weather: " + w);
        switch (w) {
            case HEAVY_RAIN:
            case STORM:
                System.out.println("Grip reduced, race might be more random.");
                break;
            default:
                System.out.println("Normal race conditions.");
        }
    }
}
