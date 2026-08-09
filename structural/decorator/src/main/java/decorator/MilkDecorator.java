package decorator;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage wrappedBeverage) { super(wrappedBeverage); }
    public String getDescription() { return wrappedBeverage.getDescription() + ", milk"; }
    public double getCost() { return wrappedBeverage.getCost() + 0.50; }
}
