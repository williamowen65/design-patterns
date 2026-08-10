public class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Steeping tea leaves");
    }

    @Override
    protected void addExtras() {
        System.out.println("Adding lemon");
    }
}
