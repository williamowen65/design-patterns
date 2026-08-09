package observer;

public class WindowDisplay implements WeatherObserver {
    @Override
    public void update(double temperature) {
        System.out.printf("Window display: temperature is %.1f°F%n", temperature);
    }
}
