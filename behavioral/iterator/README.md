# Iterator Pattern

## Intent

Provide a way to move through the elements of a collection without exposing how that collection stores its data internally.

## The basic idea

The collection owns the data. The iterator owns the traversal state.

In this demo:

- `BookCollection` stores the books.
- `BookIterator` remembers the current position while walking through them.
- `IteratorDemo` can loop over the collection without knowing that `BookCollection` uses an `ArrayList` internally.

That separation is the point of the pattern: code that consumes the collection depends on a standard traversal interface rather than the collection's internal representation.

## Structure

```text
BookCollection
    |
    | creates
    v
BookIterator ---> Book
```

`BookCollection` implements Java's `Iterable<Book>`, and `BookIterator` implements `Iterator<Book>`. Because of that, Java's enhanced `for` loop can use the custom iterator automatically.

## Run the demo

From this directory:

```bash
javac *.java
java IteratorDemo
```

Expected output:

```text
Clean Code
Design Patterns
The Pragmatic Programmer
```

## Why not just expose the list?

You could return the underlying `List<Book>`, but then callers become coupled to the way the collection is stored. If the internal data structure changes later, more code may need to change with it.

Iterator keeps traversal behind an abstraction. The caller only asks, essentially:

> Is there another item? Give me the next one.

## Where you see this in real software

Iterator is extremely common, but you often use an implementation provided by the language or framework instead of writing one yourself.

Examples include:

- Java's `Iterator` and `Iterable`
- enhanced `for` loops
- database result cursors
- tree traversal APIs
- paginated or streamed collections

## Tradeoffs

### Advantages

- Hides collection internals from callers.
- Moves traversal logic out of the collection consumer.
- Allows different traversal strategies over the same data.
- Gives multiple traversals their own independent position/state.

### Disadvantages

- A custom iterator can be unnecessary for simple collections when the language already provides one.
- More specialized traversal rules mean more iterator classes or iterator logic.

## Key takeaway

**Iterator separates "what is in the collection" from "how do I move through it?"**

The collection manages its contents; the iterator manages the walk through those contents.
