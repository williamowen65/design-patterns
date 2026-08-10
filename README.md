# Design Pattern Demos

A hands-on reference project for learning and demonstrating the classic **Gang of Four (GoF) design patterns**.

The demos are organized under the three GoF categories.

## Repository Layout

```text
creational/
    abstract-factory/
    builder/
    factory-method/
    prototype/
    singleton/

structural/
    adapter/
    bridge/
    composite/
    decorator/
    facade/
    flyweight/
    proxy/

behavioral/
    command/
    memento/
    observer/
    strategy/
```

## The 23 Gang of Four Patterns

### Creational Patterns

Patterns concerned with how objects are created.

1. Abstract Factory — [demo](creational/abstract-factory/)
2. Builder — [demo](creational/builder/)
3. Factory Method — [demo](creational/factory-method/)
4. Prototype — [demo](creational/prototype/)
5. Singleton — [demo](creational/singleton/)

### Structural Patterns

Patterns concerned with how classes and objects are composed into larger structures.

1. Adapter — [demo](structural/adapter/)
2. Bridge — [demo](structural/bridge/)
3. Composite — [demo](structural/composite/)
4. Decorator — [demo](structural/decorator/)
5. Facade — [demo](structural/facade/)
6. Flyweight — [demo](structural/flyweight/)
7. Proxy — [demo](structural/proxy/)

### Behavioral Patterns

Patterns concerned with communication and responsibility between objects.

1. Chain of Responsibility
2. Command — [demo](behavioral/command/)
3. Interpreter
4. Iterator
5. Mediator
6. Memento — [demo](behavioral/memento/)
7. Observer — [demo](behavioral/observer/)
8. State
9. Strategy — [demo](behavioral/strategy/)
10. Template Method
11. Visitor

## A useful realization: many patterns use the same OOP mechanics

The 23 GoF patterns are not 23 completely different programming mechanisms. Many of them are built from the same small set of object-oriented tools:

- interfaces and polymorphism
- composition
- inheritance
- delegation
- encapsulation

Because of that, different patterns can look extremely similar in code or even have nearly identical class diagrams. What usually distinguishes one pattern from another is **the problem the programmer is trying to solve**.

For example, Bridge and Strategy can both contain code shaped roughly like this:

```java
class Thing {
    private SomeInterface implementation;
}
```

In both cases, `Thing` holds another object through an interface and delegates work to it. The mechanics are similar, but the intent is different:

- **Strategy:** "I want to swap the algorithm or behavior this object uses."
- **Bridge:** "I have two dimensions of my design that should evolve independently, so I will connect them through composition."
- **Abstract Factory:** "I need to create compatible families of objects without the caller depending on their concrete types."

This is why identifying a pattern purely from syntax can be misleading. A better question is:

> **What problem was the programmer trying to solve?**

Design patterns are best thought of as **named recipes for applying a relatively small set of OOP principles to recurring design problems**, rather than 23 unrelated language features.

As you learn more patterns, recognizing the underlying primitives is more valuable than memorizing every class diagram. Once composition, polymorphism, delegation, inheritance, and encapsulation become familiar, many patterns start to feel like different arrangements of tools you already know.

## Project Approach

Each pattern gets a small focused demo and README covering what problem it solves, its structure, tradeoffs, and how it appears in real software.
