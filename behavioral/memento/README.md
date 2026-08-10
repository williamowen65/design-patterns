# Memento Pattern

## Why learn this one after Command?

Command is a natural fit for undo when an action knows how to reverse itself. **Memento approaches undo from the other direction: save the object's state, then restore an earlier snapshot.**

That makes it especially relevant to editors, drawing tools, form builders, game state, and other applications where users expect undo or checkpoints.

## The core idea

Instead of teaching every operation how to reverse itself, an object can create a snapshot of its current state:

```java
EditorMemento snapshot = editor.save();
```

Later, the object can restore that snapshot:

```java
editor.restore(snapshot);
```

The snapshot is the **memento**.

## The three roles

### Originator: `TextEditor`

The originator owns the state we care about. It knows how to save and restore itself.

```java
public EditorMemento save() {
    return new EditorMemento(text);
}

public void restore(EditorMemento memento) {
    text = memento.getSavedText();
}
```

### Memento: `EditorMemento`

The memento stores a snapshot:

```java
public class EditorMemento {
    private final String savedText;
}
```

### Caretaker: `History`

The caretaker stores snapshots but does not need to understand how the editor's internal state works.

```java
history.push(editor.save());
editor.restore(history.pop());
```

A stack is a natural structure for undo because the most recently saved state is the first one restored.

## What happens in the demo?

```text
Type "Hello"
    |
    +-- save snapshot: "Hello"

Type ", world"
    |
    +-- save snapshot: "Hello, world"

Type "!!!"
    |
    v
"Hello, world!!!"

Undo -> "Hello, world"
Undo -> "Hello"
```

## Memento vs. Command for undo

This is the important comparison.

### Command: reverse the operation

A command can remember enough information to undo what it did:

```text
Execute: AddShape
Undo:    RemoveShape
```

You store **actions** and teach them how to reverse themselves.

### Memento: restore an earlier state

Memento instead stores snapshots:

```text
State A -> State B -> State C
                    |
Undo ---------------+
       restore State B
```

You store **states** and restore an earlier one.

Neither is universally better.

Command can be efficient when reversing an operation is cheap. Memento can be simpler when the object's state is easy to snapshot but individual operations would be difficult to reverse correctly.

Real applications often combine them: commands represent user actions while mementos provide snapshots or checkpoints.

## Where this shows up

- text and code editors
- drawing/design applications
- undoable forms and configuration screens
- game save points and checkpoints
- workflow rollback
- transaction-like state restoration
- version/history systems

## The tradeoff: memory

Snapshots can become expensive.

If an object contains 100 MB of state and you save 100 complete snapshots, a naive Memento implementation could consume a huge amount of memory.

Real systems may instead use techniques such as:

- limiting undo history,
- storing only changed state,
- immutable/persistent data structures,
- periodic full snapshots plus incremental changes,
- combining Command and Memento.

So the pattern gives you the conceptual model; production implementations often optimize how snapshots are represented.

## Memento vs. Prototype

Both can involve copying state, but their intent differs.

**Prototype:** copy an object because you want another object based on an existing one.

**Memento:** capture state because you may need to restore an object to that state later.

Again, the mechanics can look similar while the design intent is different.

## Run the demo

From this directory:

```bash
javac *.java
java MementoDemo
```

Expected output:

```text
Current: Hello, world!!!
Undo 1:  Hello, world
Undo 2:  Hello
```

## Recognition rule

Think of Memento when you hear:

> "I need to be able to put this object back exactly how it was before."

If Command is about remembering **what happened**, Memento is about remembering **what things looked like at a point in time**.
