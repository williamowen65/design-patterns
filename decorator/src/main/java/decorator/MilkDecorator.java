package decorator;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage wrappedBeverage) {
        super(wrappedBeverage);
    }

    @Override
    public String getDescription() {
        return wrappedBeverage.getDescription() + ", milk";
    }

    @Override
    public double getCost() {
        return wrappedBeverage.getCost() + 0.50;
    }
}
