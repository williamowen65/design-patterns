package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver phone = new PhoneDisplay();
        WeatherObserver window = new WindowDisplay();

        station.addObserver(phone);
        station.addObserver(window);

        System.out.println("First weather update:");
        station.setTemperature(72.5);

        System.out.println("\nPhone unsubscribes...");
        station.removeObserver(phone);

        System.out.println("\nSecond weather update:");
        station.setTemperature(68.0);
    }
}
