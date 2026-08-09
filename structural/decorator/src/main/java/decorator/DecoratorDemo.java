package decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Beverage coffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.printf("%s: $%.2f%n", coffee.getDescription(), coffee.getCost());
    }
}
