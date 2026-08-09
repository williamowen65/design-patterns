package decorator;

public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage wrappedBeverage) {
        super(wrappedBeverage);
    }

    @Override
    public String getDescription() {
        return wrappedBeverage.getDescription() + ", sugar";
    }

    @Override
    public double getCost() {
        return wrappedBeverage.getCost() + 0.25;
    }
}
