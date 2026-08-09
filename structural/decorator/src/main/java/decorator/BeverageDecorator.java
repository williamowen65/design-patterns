package decorator;

public abstract class BeverageDecorator implements Beverage {
    protected final Beverage wrappedBeverage;

    protected BeverageDecorator(Beverage wrappedBeverage) {
        this.wrappedBeverage = wrappedBeverage;
    }
}
