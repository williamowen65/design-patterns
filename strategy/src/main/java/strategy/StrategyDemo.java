package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardPayment("4242"));
        cart.checkout(49.99);

        // The context stays the same; only its strategy changes.
        cart.setPaymentStrategy(new PayPalPayment("student@example.com"));
        cart.checkout(19.50);
    }
}
