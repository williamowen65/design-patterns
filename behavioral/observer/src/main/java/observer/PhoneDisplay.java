package observer;

public class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(double temperature) {
        System.out.printf("Phone display: temperature is %.1f°F%n", temperature);
    }
}
