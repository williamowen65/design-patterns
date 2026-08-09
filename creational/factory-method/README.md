# Factory Method Pattern

The **Factory Method** pattern is one of the Gang of Four creational design patterns.

Its purpose is to define an interface for creating an object while allowing subclasses (or specialized creators) to decide which concrete object should be instantiated.

## Structure

- `Notification` — product interface
- `EmailNotification` / `SmsNotification` — concrete products
- `NotificationCreator` — abstract creator containing the factory method
- `EmailNotificationCreator` / `SmsNotificationCreator` — concrete creators
- `FactoryMethodDemo` — client/demo

## Run the demo

```bash
javac *.java
java FactoryMethodDemo
```

## Factory Method vs. Simple Factory

A static helper such as `NotificationFactory.create("email")` is often called a **Simple Factory**, but Simple Factory is not one of the original 23 Gang of Four patterns. This demo uses the GoF Factory Method form, where specialized creator classes decide which product to create.
