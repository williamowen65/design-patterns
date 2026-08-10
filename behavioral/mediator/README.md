# Mediator Pattern

## What problem does it solve?

Mediator is useful when several objects need to communicate with each other, but you do not want every object to hold references to and understand every other object.

Without a mediator, a group of collaborating objects can become tightly coupled:

```text
A <--> B
A <--> C
A <--> D
B <--> C
B <--> D
C <--> D
```

As the number of objects grows, the number of relationships can grow quickly.

Mediator introduces a central coordinator:

```text
        A
        |
B ---- Mediator ---- C
        |
        D
```

The objects communicate through the mediator instead of talking directly to one another.

## The demo

This example uses a chat room.

Each `User` knows only about the `ChatMediator`:

```java
protected final ChatMediator mediator;
```

When a user sends a message:

```java
mediator.sendMessage(message, this);
```

the user does not loop through all other users or need references to them.

`ChatRoom` owns that coordination logic:

```java
public void sendMessage(String message, User sender) {
    for (User user : users) {
        if (user != sender) {
            user.receive(message, sender.name);
        }
    }
}
```

So the mediator decides how communication happens.

## What is actually being decoupled?

Without Mediator, a `User` might need something like:

```java
List<User> otherUsers;
```

and would need to know how to notify every other user itself.

With Mediator, the user only knows:

```java
ChatMediator mediator;
```

That means the communication policy can change without rewriting every participant.

For example, the mediator could later:

- block muted users,
- send only to a specific channel,
- log messages,
- enforce permissions,
- route private messages differently,
- notify bots or integrations.

The `User` objects do not need to know how any of that works.

## Mediator vs. direct object references

Direct references are not inherently bad.

If object A only needs to talk to object B, then simply giving A a reference to B is often clearer.

Mediator becomes useful when there is a **web of many-to-many coordination rules** and the objects are starting to know too much about one another.

A useful smell is:

> "Every time I add a new component, I have to modify several existing components so they know how to interact with it."

That is where a mediator can help.

## Mediator vs. Observer

These two can look related because both reduce direct coupling between objects.

**Observer** is usually about one object broadcasting that something happened to interested subscribers.

```text
Publisher ---> Observer A
          ---> Observer B
          ---> Observer C
```

The publisher does not coordinate a conversation among those observers.

**Mediator** coordinates interactions between multiple peer objects.

```text
User A ---> ChatRoom ---> User B
                    ---> User C
```

A shorthand:

> Observer: "Something happened; whoever cares can react."

> Mediator: "These objects need to communicate, so put the communication rules in one coordinator."

## Mediator vs. Facade

Both introduce an object that sits in front of other objects, but their intent is different.

**Facade** gives outside callers a simpler interface to a complicated subsystem.

**Mediator** manages communication *inside* a group of collaborating objects.

So:

> Facade simplifies access from the outside.

> Mediator organizes interaction on the inside.

## Mediator vs. Chain of Responsibility

Chain of Responsibility routes a request through a sequence of possible handlers:

```text
A -> B -> C -> D
```

Mediator does not require a sequence. Participants send messages to a coordinator, and the coordinator decides who should receive them:

```text
A -> Mediator -> C
B -> Mediator -> A
D -> Mediator -> B
```

Chain asks:

> "Which handler in this sequence should deal with this request?"

Mediator asks:

> "How should these collaborating objects communicate without depending directly on one another?"

## Real-world examples

Mediator-like coordination appears in:

- chat rooms and messaging channels,
- UI dialogs where controls affect one another,
- air traffic control systems,
- workflow coordinators,
- multiplayer game lobbies,
- event orchestration inside a feature,
- form components with cross-field behavior.

A UI dialog is a classic example. Instead of a checkbox directly knowing about a text field, button, dropdown, and label, each control reports changes to the dialog. The dialog decides which other controls should be enabled, disabled, cleared, or updated.

## The tradeoff

Mediator reduces coupling between the participants, but it can concentrate a lot of logic in the mediator itself.

If every interaction rule ends up in one enormous `AppMediator`, you have simply moved the complexity into a giant coordinator class.

The pattern works best when the mediator has a clear, bounded responsibility such as one dialog, one chat room, or one workflow.

## Run the demo

From this directory:

```bash
javac *.java
java MediatorDemo
```

## Recognition rule

Think about Mediator when the problem sounds like:

> "These objects all need to interact, but I do not want them all directly wired to each other."
