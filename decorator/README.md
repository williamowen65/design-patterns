# Decorator Pattern

The **Decorator** pattern is a Gang of Four structural design pattern.

## Intent

Attach additional responsibilities to an object dynamically by wrapping it in another object that implements the same interface.

The key idea is composition: instead of creating lots of subclasses for every combination of behavior, you wrap a base object with one or more decorators.

## Demo

This example models a simple coffee order:

- `Beverage` is the common component interface.
- `SimpleCoffee` is the concrete component.
- `BeverageDecorator` is the abstract decorator base class.
- `MilkDecorator` and `SugarDecorator` add behavior and cost.
- `DecoratorDemo` shows the same coffee being wrapped with different combinations.

## Structure

```text
Beverage
   |
   +-- SimpleCoffee
   |
   +-- BeverageDecorator
          |
          +-- MilkDecorator
          +-- SugarDecorator
```

Each decorator also implements `Beverage`, so decorators can wrap either the original object or another decorator.

## Why use it?

Without Decorator, combinations can lead to a subclass explosion:

```text
Coffee
CoffeeWithMilk
CoffeeWithSugar
CoffeeWithMilkAndSugar
CoffeeWithDoubleMilkAndSugar
...
```

With Decorator, behavior is assembled at runtime:

```java
Beverage coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);
```

## When you might see it in real code

Decorator-style designs show up in Java I/O streams, middleware chains, logging wrappers, HTTP request/response wrappers, and UI components.

For example, Java's stream APIs often wrap one stream in another so each layer adds a responsibility such as buffering or decoding.

## Tradeoffs

### Advantages

- Adds behavior without changing the original class
- Avoids large inheritance hierarchies
- Behaviors can be combined dynamically
- Each decorator has one focused responsibility

### Disadvantages

- Many small wrapper objects can make the object graph harder to inspect
- Order can matter when decorators are stacked
- Debugging through several layers of wrapping can be less obvious than a single class
