package adapter;

/**
 * Adapter: presents the interface our application expects while delegating
 * to the incompatible Celsius service.
 */
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
