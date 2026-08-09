# Observer Pattern

The **Observer** pattern is a Gang of Four behavioral design pattern.

## Intent

Define a one-to-many relationship between objects so that when one object changes state, its dependents are notified automatically.

Think of it like a subscription: observers subscribe to a subject, and the subject publishes updates when something interesting happens.

## Demo

This example models a weather station:

- `WeatherStation` is the **Subject** (publisher).
- `WeatherObserver` defines the **Observer** contract.
- `PhoneDisplay` and `WindowDisplay` are concrete observers.
- `ObserverDemo` subscribes the displays, changes the temperature, then unsubscribes one observer to show that notifications are dynamic.

The important idea is that `WeatherStation` does not need to know the concrete classes that react to its changes. It only knows the `WeatherObserver` interface.

## Structure

```text
WeatherStation (Subject)
       |
       | notifies
       v
WeatherObserver
     /     \
PhoneDisplay  WindowDisplay
```

## Why use it?

Without Observer, the subject might directly call every concrete object that needs an update. That creates tight coupling and makes adding new listeners harder.

With Observer, new listeners can be added without changing the subject.

## Tradeoffs

### Advantages

- Loose coupling between publisher and subscribers
- Observers can be added and removed at runtime
- A single event can trigger many independent reactions

### Disadvantages

- Notification flow can become difficult to follow when there are many observers
- Observers must be unsubscribed appropriately in systems where their lifetime matters
- A change can unexpectedly trigger a large chain of work

## Real-world examples

Observer-style designs appear in UI event listeners, domain events, message/event systems, and reactive programming.
