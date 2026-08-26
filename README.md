# Design Pattern Demos

A hands-on reference project for learning and demonstrating classic **Gang of Four (GoF) design patterns** and larger-scale **architectural design patterns**.

## Explore the patterns

- [Browse practical use-case ideas for all 23 GoF patterns](USE_CASES.md)
- [Study architectural patterns — Part I](architectural/README.md)
- Follow the demo links below for runnable Java examples and deeper explanations.

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
    chain-of-responsibility/
    command/
    interpreter/
    iterator/
    mediator/
    memento/
    observer/
    state/
    strategy/
    template-method/
    visitor/

architectural/
    README.md
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

1. Chain of Responsibility — [demo](behavioral/chain-of-responsibility/)
2. Command — [demo](behavioral/command/)
3. Interpreter — [demo](behavioral/interpreter/)
4. Iterator — [demo](behavioral/iterator/)
5. Mediator — [demo](behavioral/mediator/)
6. Memento — [demo](behavioral/memento/)
7. Observer — [demo](behavioral/observer/)
8. State — [demo](behavioral/state/)
9. Strategy — [demo](behavioral/strategy/)
10. Template Method — [demo](behavioral/template-method/)
11. Visitor — [demo](behavioral/visitor/)

## Architectural Patterns

Architectural patterns operate at a wider zoom level than GoF patterns. They organize major parts of an application or distributed system rather than primarily organizing collaborating objects.

The first architectural guide covers:

1. [Introduction to architectural patterns](architectural/README.md)
2. [Blackboard](architectural/README.md#blackboard-pattern)
3. [Broker](architectural/README.md#broker-pattern)
4. [Client–Server](architectural/README.md#clientserver-pattern)
5. [Event-Driven](architectural/README.md#event-driven-pattern)
6. [Extract–Transform–Load (ETL)](architectural/README.md#extracttransformload-etl-pattern)
7. [Layered](architectural/README.md#layered-pattern)
8. [Leader–Worker and Primary–Replica](architectural/README.md#leadersworkers-and-primaryreplicas)
9. [Microkernel](architectural/README.md#microkernel-pattern)

## A useful realization: many patterns use the same mechanics

The 23 GoF patterns are not 23 completely different programming mechanisms. Many are built from the same small set of object-oriented tools:

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

Design patterns are best thought of as **named recipes for applying a relatively small set of principles to recurring design problems**, rather than unrelated language features.

## Project Approach

Each GoF pattern gets a small focused demo and README covering what problem it solves, its structure, tradeoffs, and how it appears in real software.

Architectural topics begin as conceptual guides with diagrams, comparisons, tradeoffs, and examples. Focused runnable demonstrations can be added as the course progresses.
