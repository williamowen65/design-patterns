public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private String environment = "development";

    // Private constructor prevents callers from creating another AppConfig.
    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
