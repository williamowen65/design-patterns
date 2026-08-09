# Abstract Factory Pattern

## What problem does it solve?

Abstract Factory creates **families of related objects** without making the client depend on their concrete classes.

This demo has two product types:

- `Button`
- `Checkbox`

and two matching families:

- macOS: `MacButton` + `MacCheckbox`
- Windows: `WindowsButton` + `WindowsCheckbox`

The client receives a `GUIFactory` and asks it for both products. It does not need to know which concrete family it received.

## The key idea

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

Each concrete factory creates a complete matching family:

```java
public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

`WindowsFactory` does the same thing for the Windows family.

The application can therefore say:

```java
button = factory.createButton();
checkbox = factory.createCheckbox();
```

without containing `new MacButton()`, `new WindowsButton()`, or other platform-specific creation logic.

## Why is it called "Abstract Factory"?

The factory itself is abstracted behind `GUIFactory`. The client knows what *kinds* of related objects it needs, but not which concrete versions it will receive.

Think of it as choosing a **kit** rather than choosing one object.

```text
MacFactory                 WindowsFactory
    |                            |
    +-- MacButton                +-- WindowsButton
    +-- MacCheckbox              +-- WindowsCheckbox
```

Once you choose the factory, the products stay in the same family.

## Abstract Factory vs. Factory Method

This is the most important comparison for this demo.

A Factory Method usually focuses on creating **one product type** while allowing the concrete product to vary.

Abstract Factory focuses on creating **multiple related product types that belong together**.

A useful shorthand is:

> Factory Method: Which implementation of this thing should I create?

> Abstract Factory: Which family of related things should I create?

Abstract Factory often uses factory methods internally, which is why the two patterns can look similar in code.

## Why not just use `if` statements?

You could put platform checks everywhere:

```java
if (isWindows) {
    button = new WindowsButton();
    checkbox = new WindowsCheckbox();
} else {
    button = new MacButton();
    checkbox = new MacCheckbox();
}
```

That works for a small program. The pattern becomes useful when the same family choice affects many related objects and you do not want platform-specific construction logic spread throughout the application.

## Tradeoff

Abstract Factory adds several interfaces and classes. If you only have one or two simple objects, that abstraction can be more complicated than the problem.

It pays off when:

- there are multiple product families,
- each family contains several related products,
- the client should not care which family it is using, and
- you want to swap the entire family in one place.

## Run the demo

From this directory:

```bash
javac *.java
java AbstractFactoryDemo
```

That uses the macOS family by default.

To use Windows:

```bash
java AbstractFactoryDemo windows
```

## What to notice while reading the code

Start with `Application.java`. Notice that it knows only `GUIFactory`, `Button`, and `Checkbox`.

Then look at `MacFactory` and `WindowsFactory`. Those classes are where the concrete family choice lives.

That separation is the pattern.
