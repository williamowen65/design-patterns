# Chain of Responsibility Pattern

## What problem does it solve?

Chain of Responsibility is useful when several different objects might be able to handle a request, and you do not want the caller to decide which one should receive it.

Instead, the request enters a **chain of handlers**. Each handler either:

1. handles the request, or
2. passes it to the next handler.

This demo models a support system:

```text
PasswordResetHandler
        |
        v
TechnicalSupportHandler
        |
        v
BillingSupportHandler
```

Every support request starts at the beginning of the chain.

## The core idea

The base handler stores a reference to the next handler:

```java
private SupportHandler next;
```

and provides the forwarding behavior:

```java
public void handle(SupportRequest request) {
    if (canHandle(request)) {
        process(request);
    } else if (next != null) {
        next.handle(request);
    }
}
```

That `next` reference is what forms the chain.

Each concrete handler only needs to answer two questions:

```java
protected boolean canHandle(SupportRequest request)
protected void process(SupportRequest request)
```

For example, the billing handler says:

```java
return request.type() == SupportRequest.Type.BILLING;
```

If the request is not billing-related, an earlier handler simply forwards it.

## Why this is different from one giant `if/else`

You could write this in one class:

```java
if (type == PASSWORD_RESET) {
    // password logic
} else if (type == TECHNICAL) {
    // technical logic
} else if (type == BILLING) {
    // billing logic
}
```

That works, especially for small systems.

Chain of Responsibility becomes useful when each branch has enough behavior to deserve its own object, or when you want to reorder, add, or remove handlers without rewriting the caller.

With a chain, the caller just does:

```java
firstHandler.handle(request);
```

It does not need to know which handler will eventually process the request.

## Building the chain

The demo connects the handlers like this:

```java
password.setNext(technical).setNext(billing);
```

Because `setNext()` returns the handler that was just attached, the calls can be chained together.

Conceptually:

```text
password -> technical -> billing -> null
```

A request moves to the right until somebody accepts it.

## A request walking through the chain

Suppose the request is technical:

```text
"The app crashes when I upload a file"
              |
              v
PasswordResetHandler
    cannot handle it
              |
              v
TechnicalSupportHandler
       handles it
              X
```

The billing handler is never called because the technical handler already handled the request.

## What if nobody can handle it?

In this demo, the final handler reaches the end of the chain and prints:

```text
No handler could process: ...
```

Real systems might instead:

- return an error,
- fall back to a default handler,
- log the request,
- send it to a human,
- throw an exception.

## Common real-world examples

Chain of Responsibility shows up naturally in pipelines such as:

- HTTP middleware
- authentication and authorization checks
- request validation
- logging pipelines
- customer support escalation
- approval workflows
- event processing
- exception/error handlers
- spam or content filtering

A web request pipeline is a particularly useful mental model:

```text
Request
  |
  v
Logging
  |
  v
Authentication
  |
  v
Authorization
  |
  v
Validation
  |
  v
Controller
```

Each stage can inspect the request, modify it, stop it, or pass it along.

## Chain of Responsibility vs. Decorator

These can look similar because both often involve one object holding a reference to another object of a compatible type.

The intent is different.

**Decorator:** every layer usually contributes behavior around the same operation.

```text
LoggingDecorator -> CompressionDecorator -> FileWriter
```

The call typically travels through all of them.

**Chain of Responsibility:** each handler gets a chance to handle a request, and the chain may stop as soon as one succeeds.

```text
Password -> Technical -> Billing
              X
          handled here
```

A shorthand:

> Decorator: "Everyone adds something."

> Chain of Responsibility: "Who should handle this?"

## Chain of Responsibility vs. Command

**Command** turns an action into an object so it can be queued, stored, undone, retried, or executed later.

**Chain of Responsibility** routes a request through potential handlers.

They can even be used together: a command could be passed through a chain of validation or authorization handlers before being executed.

## The tradeoff

The decoupling is useful, but it can make control flow less obvious.

When you see:

```java
firstHandler.handle(request);
```

it may take some investigation to discover which handler eventually receives the request.

Also, unless you deliberately provide a fallback, there is no guarantee that any handler will process the request.

## When to use it

Consider Chain of Responsibility when:

- multiple objects might handle the same kind of request,
- the caller should not need to choose the handler,
- handlers should be easy to reorder or replace,
- processing naturally looks like a pipeline,
- large conditional routing logic is growing unwieldy.

## When not to use it

If there are only a couple of simple branches and they are unlikely to change, a normal conditional may be clearer.

Do not turn three obvious `if` statements into eight classes just to say you used a design pattern.

## Run the demo

From this directory:

```bash
javac *.java
java ChainDemo
```

## Recognition rule

Think of Chain of Responsibility when the problem sounds like:

> "Send this request through these possible handlers until somebody can deal with it."
