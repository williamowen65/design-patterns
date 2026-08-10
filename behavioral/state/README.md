# State Pattern

## What problem does it solve?

The State pattern is useful when an object's behavior changes depending on its current state and you want to avoid a large collection of `if`, `else if`, or `switch` statements.

This demo uses a media player with three states:

- `StoppedState`
- `PlayingState`
- `PausedState`

The `MediaPlayer` delegates behavior to whichever `PlayerState` object is currently active.

## Without State

A simple implementation might keep a string or enum and branch everywhere:

```java
if (state == PLAYING) {
    // pause
} else if (state == PAUSED) {
    // already paused
} else if (state == STOPPED) {
    // nothing to pause
}
```

As more operations and states are added, these conditionals spread through the class and become harder to maintain.

## With State

The context holds a state object:

```java
public class MediaPlayer {
    private PlayerState state = new StoppedState();

    public void play() {
        state.play(this);
    }
}
```

The current state decides what `play()` means.

For example, `StoppedState` starts playback:

```java
public void play(MediaPlayer player) {
    System.out.println("Starting playback");
    player.setState(new PlayingState());
}
```

But `PlayingState` interprets the same action differently:

```java
public void play(MediaPlayer player) {
    System.out.println("Player is already playing");
}
```

So the same method call can behave differently depending on the object's current state.

## The important idea

The object still has state, but instead of representing that state only with a flag or enum, we represent each meaningful state as an object containing the behavior associated with that state.

```text
MediaPlayer
    |
    +--> PlayerState
            |
            +-- StoppedState
            +-- PlayingState
            +-- PausedState
```

When the state changes, the `MediaPlayer` swaps which state object it references.

## State transitions

The states in this demo also control transitions:

```text
Stopped --play--> Playing
Playing --pause--> Paused
Paused  --play--> Playing
Playing --stop--> Stopped
Paused  --stop--> Stopped
```

This makes the allowed transitions visible in the state classes instead of burying them inside a giant conditional block.

## State vs. Strategy

These patterns can look almost identical structurally because both use composition and delegation:

```java
private SomeInterface implementation;
```

The difference is intent.

**Strategy:** the caller usually chooses a behavior or algorithm because it wants a different way of doing something.

**State:** the object's behavior changes because the object has moved into a different internal state.

A useful shorthand:

> Strategy: "Use this behavior."

> State: "I am currently in this condition, so I behave this way."

## State vs. Memento

These two both involve the word "state," but they solve very different problems.

**State pattern:** organize behavior based on the object's current condition.

**Memento pattern:** save an object's past state so it can be restored later.

So:

> State = what should I do *now* given my current condition?

> Memento = what did I look like *before* so I can go back?

## Real-world use cases

State is useful for things such as:

- media players: stopped, playing, paused
- document workflows: draft, review, approved, published
- orders: pending, paid, shipped, delivered, cancelled
- network connections: disconnected, connecting, connected
- game characters: idle, running, jumping, attacking
- UI controls: enabled, disabled, loading, error
- authentication flows: logged out, authenticating, authenticated, locked

## When not to use it

If there are only two simple states and one tiny conditional, creating several classes may make the code harder rather than easier.

State becomes more valuable when:

- there are several meaningful states,
- behavior differs substantially between states,
- many methods contain repeated state checks,
- transitions have rules of their own.

## Run the demo

From this directory:

```bash
javac *.java
java StateDemo
```

## Recognition rule

Think about State when you notice yourself writing:

> "If we're in state A, do this; if we're in state B, do that; if we're in state C..."

especially when that same branching logic starts appearing across several methods.
