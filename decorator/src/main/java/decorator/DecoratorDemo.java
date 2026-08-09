package decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Beverage plainCoffee = new SimpleCoffee();
        printOrder("Plain", plainCoffee);

        Beverage coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        printOrder("With milk", coffeeWithMilk);

        Beverage coffeeWithMilkAndSugar =
                new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        printOrder("With milk and sugar", coffeeWithMilkAndSugar);
    }

    private static void printOrder(String label, Beverage beverage) {
        System.out.printf(
                "%s -> %s: $%.2f%n",
                label,
                beverage.getDescription(),
                beverage.getCost()
        );
    }
}
