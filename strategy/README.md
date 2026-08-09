# Strategy Pattern Demo

The **Strategy** pattern is a behavioral Gang of Four design pattern that defines a family of interchangeable algorithms, puts each algorithm behind the same interface, and lets the client choose which behavior to use at runtime.

## The problem

Suppose a shopping cart can accept different payment methods. Putting every payment option into one large `if`/`switch` statement makes the cart responsible for details that do not belong to it and makes new payment methods harder to add.

Strategy separates those behaviors.

## Roles in this demo

- `PaymentStrategy` — the strategy interface.
- `CreditCardPayment` and `PayPalPayment` — concrete strategies.
- `ShoppingCart` — the context. It delegates payment behavior to whichever strategy it currently has.
- `StrategyDemo` — demonstrates changing the strategy at runtime.

## Why use Strategy?

Strategy is useful when several implementations perform the same conceptual job but use different algorithms or policies. It favors composition over inheritance and keeps the context from knowing the details of each implementation.

A major benefit is extensibility: another payment strategy can implement `PaymentStrategy` without requiring `ShoppingCart` to change.

## Run the demo

From the `strategy` directory:

```bash
javac src/main/java/strategy/*.java
java -cp src/main/java strategy.StrategyDemo
```

Expected output is similar to:

```text
Paid $49.99 using credit card ending in 4242
Paid $19.50 using PayPal account student@example.com
```

## Tradeoffs

Strategy introduces additional classes and indirection, so it is most valuable when behavior genuinely varies. For very small behavior differences, a separate strategy hierarchy can be unnecessary complexity.
