package factory;

import java.util.Random;
import core.weather.WeatherType;

public class WeatherFactory {

    private Random random = new Random();

    public WeatherType randomWeather() {
        WeatherType[] values = WeatherType.values();
        return values[random.nextInt(values.length)];
    }
}
