# Adapter Pattern

The **Adapter** pattern is a Gang of Four structural design pattern.

## Intent

Convert the interface of an existing class into an interface that your code expects.

A good mental model is a physical power adapter: you already have a device and a wall outlet, but their plugs do not match. You do not redesign either one—you put an adapter between them.

## Demo

This example imagines that our application expects every temperature source to implement `TemperatureProvider` and return degrees Fahrenheit.

We then receive a third-party/legacy class, `CelsiusWeatherService`, that we cannot or do not want to modify. Its API returns Celsius instead.

`CelsiusWeatherAdapter` implements the interface our application expects while wrapping the incompatible service and converting its result.

```text
Application
    |
    v
TemperatureProvider
    ^
    |
CelsiusWeatherAdapter ----> CelsiusWeatherService
       converts C -> F
```

## Why use it?

Adapter is especially useful when integrating:

- legacy code
- third-party libraries
- external SDKs
- APIs with inconvenient interfaces
- two parts of a system that evolved independently

The important design signal is:

> **I already have something that does the work I need, but its interface does not match the interface my code expects.**

Instead of spreading translation logic throughout the application, put that translation in one adapter.

## Adapter vs Decorator

These two patterns can look similar because both often wrap another object.

The difference is their intent:

- **Adapter changes the interface** so an incompatible object can be used.
- **Decorator keeps the same interface** and adds behavior or responsibilities.

## Tradeoffs

### Advantages

- Keeps compatibility logic in one place
- Avoids modifying stable or third-party code
- Lets the rest of the application depend on the interface it actually wants
- Makes awkward external APIs easier to replace later

### Disadvantages

- Adds another layer/class
- A large mismatch between interfaces can make the adapter complicated
- Too many adapters can indicate inconsistent abstractions in the larger design

## How often will you write one yourself?

Quite often compared with some GoF patterns. Whenever you integrate a library or older component whose API does not fit your application's preferred abstraction, a small adapter can be cleaner than allowing the foreign API to leak throughout your codebase.
