package observer;

/**
 * Observer contract. Any object interested in weather changes implements this.
 */
public interface WeatherObserver {
    void update(double temperature);
}
