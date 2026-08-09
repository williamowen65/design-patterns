package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject/publisher in the Observer pattern.
 */
public class WeatherStation {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private double temperature;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
