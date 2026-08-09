package decorator;

public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage wrappedBeverage) { super(wrappedBeverage); }
    public String getDescription() { return wrappedBeverage.getDescription() + ", sugar"; }
    public double getCost() { return wrappedBeverage.getCost() + 0.25; }
}
