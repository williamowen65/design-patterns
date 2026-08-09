package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherObserver phone = new PhoneDisplay();
        WeatherObserver window = new WindowDisplay();
        station.addObserver(phone);
        station.addObserver(window);
        station.setTemperature(72.5);
        station.removeObserver(phone);
        station.setTemperature(68.0);
    }
}
