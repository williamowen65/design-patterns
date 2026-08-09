package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardPayment("4242"));
        cart.checkout(49.99);
        cart.setPaymentStrategy(new PayPalPayment("student@example.com"));
        cart.checkout(19.50);
    }
}
