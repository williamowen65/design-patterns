# Factory Method Pattern

The **Factory Method** pattern is one of the Gang of Four creational design patterns.

Its purpose is to define an interface for creating an object while allowing subclasses (or specialized creators) to decide which concrete object should be instantiated.

## The problem

Suppose an application needs to send notifications. The client should be able to work with a common `Notification` type without directly constructing `EmailNotification` or `SmsNotification` everywhere.

Without a factory method, object creation can become tightly coupled to concrete classes:

```java
Notification notification = new EmailNotification();
```

That works, but it means the client knows exactly which implementation it is creating.

With Factory Method, creation is delegated to creator classes.

## Structure

- `Notification` — product interface
- `EmailNotification` / `SmsNotification` — concrete products
- `NotificationCreator` — abstract creator containing the factory method
- `EmailNotificationCreator` / `SmsNotificationCreator` — concrete creators
- `FactoryMethodDemo` — client/demo

## Why use it?

Factory Method is useful when:

- client code should depend on abstractions instead of concrete classes
- object creation logic may vary
- subclasses should control which object is created
- you expect new product types to be added later

## Tradeoffs

### Advantages

- reduces coupling between client code and concrete products
- supports the Open/Closed Principle
- centralizes creation decisions
- makes new product types easier to introduce

### Disadvantages

- introduces additional classes
- can be unnecessary when construction is very simple and unlikely to change

## Run the demo

From this folder:

```bash
javac *.java
java FactoryMethodDemo
```

Expected output:

```text
Sending EMAIL notification: Your order has shipped.
Sending SMS notification: Your verification code is 123456.
```

## Factory Method vs. "Simple Factory"

A static helper such as `NotificationFactory.create("email")` is often called a **Simple Factory**, but Simple Factory is not one of the original 23 Gang of Four patterns.

This demo intentionally uses the GoF **Factory Method** form, where specialized creator classes override the method responsible for producing objects.
