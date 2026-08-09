public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory = args.length > 0 && args[0].equalsIgnoreCase("windows")
                ? new WindowsFactory()
                : new MacFactory();

        Application app = new Application(factory);
        app.render();
    }
}
