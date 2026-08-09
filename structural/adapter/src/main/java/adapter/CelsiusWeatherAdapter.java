package adapter;

public class CelsiusWeatherAdapter implements TemperatureProvider {
    private final CelsiusWeatherService weatherService;

    public CelsiusWeatherAdapter(CelsiusWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public double getTemperatureFahrenheit() {
        double celsius = weatherService.readTemperatureCelsius();
        return (celsius * 9.0 / 5.0) + 32.0;
    }
}
