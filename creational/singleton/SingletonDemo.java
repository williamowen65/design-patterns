public class SingletonDemo {
    public static void main(String[] args) {
        AppConfig firstReference = AppConfig.getInstance();
        AppConfig secondReference = AppConfig.getInstance();

        System.out.println("Same object? " + (firstReference == secondReference));

        firstReference.setEnvironment("production");

        System.out.println("First reference:  " + firstReference.getEnvironment());
        System.out.println("Second reference: " + secondReference.getEnvironment());
    }
}
