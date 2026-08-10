# Template Method Pattern

## Intent

Define the overall steps of an algorithm in a base class, while allowing subclasses to customize selected steps without changing the algorithm's structure.

## Demo

This example models making hot drinks.

`Beverage.prepare()` defines the recipe:

1. boil water
2. brew the drink
3. pour it into a cup
4. add extras

Every drink follows that same sequence. The subclasses only provide the parts that vary:

- `Coffee` brews coffee grounds and adds milk and sugar.
- `Tea` steeps tea leaves and adds lemon.

The important line is the `prepare()` method in `Beverage`. That method is the **template method**. It controls the overall algorithm instead of letting every subclass rewrite the whole process.

## Structure

- `Beverage` — abstract base class containing the template method.
- `prepare()` — the template method that fixes the order of operations.
- `brew()` and `addExtras()` — abstract steps subclasses must implement.
- `Coffee` and `Tea` — concrete subclasses that customize those steps.

## Why use it?

Without Template Method, `Coffee` and `Tea` could each implement their own complete `prepare()` method. That would duplicate the shared steps and make it easier for the processes to drift apart.

Template Method keeps the invariant parts in one place while exposing only the intended extension points.

## Key idea

> The parent class controls **when** the steps happen; subclasses control **how certain steps are performed**.

This is an inheritance-based pattern. The customization happens by overriding methods in subclasses rather than by injecting separate behavior objects.

## Template Method vs Strategy

These two patterns can solve similar problems, but they use different mechanisms:

- **Template Method:** vary parts of an algorithm through inheritance and method overriding.
- **Strategy:** vary an algorithm through composition by supplying another object.

A useful shorthand is:

- Template Method = **inherit and override selected steps**.
- Strategy = **compose and swap behavior objects**.

## Tradeoffs

### Advantages

- removes duplication in algorithms with shared structure
- guarantees that important steps happen in a consistent order
- gives subclasses clearly defined extension points

### Disadvantages

- couples the customization to inheritance
- a base class with too many overridable hooks can become difficult to understand
- subclasses are constrained by the algorithm defined by the parent

## Run

```bash
javac *.java
java TemplateMethodDemo
```

Expected output:

```text
Making coffee:
Boiling water
Brewing coffee grounds
Pouring into cup
Adding milk and sugar

Making tea:
Boiling water
Steeping tea leaves
Pouring into cup
Adding lemon
```
