# Strategy Pattern Demo

The **Strategy** pattern defines a family of interchangeable algorithms behind the same interface and lets the client choose behavior at runtime.

- `PaymentStrategy` — strategy interface
- `CreditCardPayment` and `PayPalPayment` — concrete strategies
- `ShoppingCart` — context
- `StrategyDemo` — client

## Run the demo

```bash
javac src/main/java/strategy/*.java
java -cp src/main/java strategy.StrategyDemo
```
