# Prototype Pattern

## Intent

Prototype creates new objects by copying an existing object instead of constructing each new object from scratch.

A simple mental model is:

> Start with a configured example, copy it, then customize the copy.

This is useful when object creation is expensive, complicated, or when you already have a good template object that you want to reuse as a starting point.

## Demo

This demo uses a `Document` as the prototype.

```java
Document original = new Document(
        "Project Proposal",
        "This is the standard proposal template."
);

Document copy = original.copy();
copy.setTitle("Client A Proposal");
copy.setBody("Customized proposal for Client A.");
```

The important point is that `copy()` returns a new `Document` with the same starting state as the original.

```java
@Override
public Document copy() {
    return new Document(this);
}
```

The private copy constructor performs the actual copying:

```java
private Document(Document source) {
    this.title = source.title;
    this.body = source.body;
}
```

After copying, the two objects are independent. Changing the copy's title does not change the original document.

## Structure

```text
Prototype<T>
    copy()
       ^
       |
   Document
       |
       +-- original
       +-- copied Document
```

The `Prototype<T>` interface is just a contract saying that an object knows how to produce a copy of itself.

## Why not just call a constructor?

You often can.

Prototype becomes useful when the existing object already contains meaningful configuration or when reconstructing that state manually would be inconvenient.

Instead of repeating all of this:

```java
Document copy = new Document(
        original.getTitle(),
        original.getBody()
        // imagine many more fields here
);
```

the object owns its copying logic:

```java
Document copy = original.copy();
```

This also keeps the client from needing to know every detail required to reconstruct the object.

## Shallow copy vs. deep copy

This is the most important issue to understand with Prototype.

This demo only contains `String` fields, so copying the field values is straightforward because Strings are immutable.

If a prototype contains mutable nested objects, however, you have to decide whether the copy should share them or duplicate them.

### Shallow copy

A shallow copy creates a new outer object but keeps references to the same nested objects.

```text
Original -----\
               -> shared Address object
Copy ---------/
```

Changing the shared nested object may appear to change both prototypes.

### Deep copy

A deep copy creates copies of the nested mutable objects too.

```text
Original -> Address A
Copy     -> Address B
```

The two object graphs are then independent.

That decision is part of implementing Prototype correctly.

## Prototype vs. Builder

These two creational patterns solve different construction problems.

**Builder** says:

> Configure a new object step by step, then build it.

**Prototype** says:

> I already have an object close to what I want. Copy it and modify the copy.

## When to use it

Prototype is a good fit when:

- creating an object from scratch is expensive or complicated,
- you frequently create objects that begin with similar state,
- runtime objects can serve as templates,
- you want the object itself to own the logic for copying its state.

It is probably unnecessary when normal construction is already simple and clear.

## Run the demo

From this directory:

```bash
javac Prototype.java Document.java PrototypeDemo.java
java PrototypeDemo
```

Expected output will show that the original document remains unchanged while the copied document is customized.
