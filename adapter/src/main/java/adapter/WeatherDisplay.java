package adapter;

/**
 * Client code depends only on the interface it wants.
 */
public class WeatherDisplay {
    private final TemperatureProvider temperatureProvider;

    public WeatherDisplay(TemperatureProvider temperatureProvider) {
        this.temperatureProvider = temperatureProvider;
    }

    public void showTemperature() {
        System.out.printf(
                "Current temperature: %.1f°F%n",
                temperatureProvider.getTemperatureFahrenheit());
    }
}
