# Design Pattern Demos

A hands-on reference project for learning and demonstrating the classic **Gang of Four (GoF) design patterns**.

The demos are organized under the three GoF categories.

## Table of Contents

- [Repository Layout](#repository-layout)
- [The 23 Gang of Four Patterns](#the-23-gang-of-four-patterns)
  - [Creational Patterns](#creational-patterns)
  - [Structural Patterns](#structural-patterns)
  - [Behavioral Patterns](#behavioral-patterns)
- [Project Approach](#project-approach)

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
    composite/
    decorator/
    facade/

behavioral/
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
2. Bridge
3. Composite — [demo](structural/composite/)
4. Decorator — [demo](structural/decorator/)
5. Facade — [demo](structural/facade/)
6. Flyweight
7. Proxy

### Behavioral Patterns

Patterns concerned with communication and responsibility between objects.

1. Chain of Responsibility
2. Command
3. Interpreter
4. Iterator
5. Mediator
6. Memento
7. Observer — [demo](behavioral/observer/)
8. State
9. Strategy — [demo](behavioral/strategy/)
10. Template Method
11. Visitor

## Project Approach

Each pattern gets a small focused demo and README covering what problem it solves, its structure, tradeoffs, and how it appears in real software.
