package adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        // This service gives us Celsius and has an interface our application
        // was not designed to use directly.
        CelsiusWeatherService celsiusService = new CelsiusWeatherService();

        // The adapter makes the existing service look like a TemperatureProvider.
        TemperatureProvider provider = new CelsiusWeatherAdapter(celsiusService);

        // The client never needs to know about Celsius or conversion logic.
        WeatherDisplay display = new WeatherDisplay(provider);
        display.showTemperature();
    }
}
