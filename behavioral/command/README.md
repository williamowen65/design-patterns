# Command Pattern

## What problem does it solve?

Command turns an action into an object.

Instead of one object directly calling another object's method, the request is wrapped inside a `Command` object with a common interface:

```java
public interface Command {
    void execute();
    void undo();
}
```

That makes requests easy to store, swap, queue, log, combine, and undo.

## Demo structure

```text
RemoteControl (Invoker)
        |
        v
     Command
      /   \
     /     \
LightOn   LightOff
 Command   Command
     \       /
      \     /
       Light (Receiver)
```

The roles are:

- **Command** — the common contract for actions.
- **Concrete Command** — wraps a particular action and usually holds a reference to the object that will perform the real work.
- **Receiver** — the object that actually knows how to do the work. In this demo, that is `Light`.
- **Invoker** — triggers commands without needing to know the receiver's implementation. In this demo, that is `RemoteControl`.

## The key idea

`LightOnCommand` contains a `Light`:

```java
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}
```

The remote only knows about `Command`:

```java
remote.setCommand(new LightOnCommand(light));
remote.pressButton();
```

So the remote is decoupled from the details of turning a light on.

## Why make an action into an object?

Normally you might write:

```java
light.turnOn();
```

That is perfectly fine for simple code.

Command becomes useful when you want to do more with the action itself.

Once the action is an object, you can:

- store it in a history list,
- put it in a queue,
- execute it later,
- retry it,
- log it,
- combine several commands into a macro,
- implement undo/redo.

The object is no longer just *doing* something; the request itself becomes data that the program can manipulate.

## Undo/redo

The demo includes `undo()` because it is one of the clearest practical reasons to use Command.

The remote remembers the last command:

```java
private Command lastCommand;
```

After execution, it can later call:

```java
lastCommand.undo();
```

A real editor might keep two stacks instead:

```text
Undo stack                 Redo stack
-----------                ----------
DeleteTextCommand
MoveShapeCommand
ChangeColorCommand
```

Each command can remember enough state to reverse itself.

This is common in text editors, drawing programs, IDEs, and other applications with undo/redo.

## Real-world use cases

### GUI buttons and menu actions

A Save button, keyboard shortcut, and menu item can all point to the same `SaveCommand`.

The UI element does not need to contain saving logic itself.

### Job queues

A background-worker system can put command-like jobs into a queue:

```text
SendEmailCommand
GenerateReportCommand
ResizeImageCommand
```

The queue decides *when* to execute them.

### Undoable editors

An editor can represent each user operation as a command:

```text
InsertTextCommand
DeleteTextCommand
MoveShapeCommand
ResizeShapeCommand
```

Commands can be stored in history and reversed later.

### Macros

A macro can contain a list of commands:

```text
MorningRoutine
    -> TurnOnLightsCommand
    -> StartCoffeeCommand
    -> RaiseBlindsCommand
```

Executing one macro triggers several requests.

### Transactions and retries

A command can hold all the information needed to retry an operation later, which is useful in distributed systems and unreliable network workflows.

## Command vs. Strategy

These can look similar because both often use an interface plus interchangeable implementations.

The intent is different:

> **Strategy:** "Which algorithm or behavior should this object use?"

> **Command:** "Represent this request/action as an object so I can pass it around and control when or how it executes."

A Strategy usually represents a *way of doing something*.

A Command usually represents *something to be done*.

## Command vs. direct method calls

Do not use Command for every method call.

If this is enough:

```java
light.turnOn();
```

then adding three extra classes just to turn on a light would be unnecessary.

Command pays off when you need the request to have a lifecycle of its own: history, undo, queues, scheduling, macros, logging, retries, or interchangeable invokers.

## Run the demo

From this directory:

```bash
javac *.java
java CommandDemo
```

Expected output:

```text
Light turned on
Light turned off
Light turned off
Light turned on
```

## What to notice while reading the code

Start with `CommandDemo.java` and follow this line:

```java
remote.setCommand(new LightOnCommand(light));
```

There are three separate objects involved:

```text
RemoteControl -> LightOnCommand -> Light
   invoker          command       receiver
```

The remote does not know how to operate a light. The command knows which receiver to call, and the receiver knows how to do the actual work.

That separation is the Command pattern.
