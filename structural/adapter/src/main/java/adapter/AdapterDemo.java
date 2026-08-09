package adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        CelsiusWeatherService celsiusService = new CelsiusWeatherService();
        TemperatureProvider provider = new CelsiusWeatherAdapter(celsiusService);
        WeatherDisplay display = new WeatherDisplay(provider);
        display.showTemperature();
    }
}
