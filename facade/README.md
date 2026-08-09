# Facade Pattern

## What problem does it solve?

A subsystem can contain several classes that a client must coordinate correctly. Even when those classes are individually simple, using all of them directly can make client code complicated and tightly coupled to implementation details.

The **Facade** pattern provides one simpler object that exposes the common operation the client actually wants.

In this example, watching a movie requires coordinating a television, sound system, and streaming player. Instead of making the client operate all three directly, `HomeTheaterFacade` provides `watchMovie()` and `endMovie()` methods.

## Structure

- `Television` — subsystem class
- `SoundSystem` — subsystem class
- `StreamingPlayer` — subsystem class
- `HomeTheaterFacade` — simplified interface to the subsystem
- `FacadeDemo` — client

## Why use it?

Use a Facade when:

- clients should not need to understand all subsystem details
- several objects must usually be used together in the same sequence
- you want to reduce coupling between application code and a complex library or subsystem
- you want a clearer entry point into a package or service

## Important distinction

A Facade does **not** usually change one interface into another compatible interface. That is the job of the **Adapter** pattern.

A Facade instead gives the client a simpler, higher-level interface to several existing classes.

## Tradeoffs

A facade can become too large if every possible subsystem operation gets added to it. Keep it focused on common workflows rather than turning it into a giant class that knows everything.

The underlying subsystem classes can still be used directly when a caller needs more control.

## Run the demo

From the repository root:

```bash
javac facade/*.java
java facade.FacadeDemo
```
