public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Brewing coffee grounds");
    }

    @Override
    protected void addExtras() {
        System.out.println("Adding milk and sugar");
    }
}
