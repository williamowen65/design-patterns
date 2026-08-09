package strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String lastFourDigits;

    public CreditCardPayment(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid $%.2f using credit card ending in %s%n", amount, lastFourDigits);
    }
}
