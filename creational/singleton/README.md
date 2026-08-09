# Singleton Pattern

## What problem does it solve?

Singleton is used when an application wants exactly one shared instance of a class and a single place to access that instance.

In this demo, `AppConfig` represents application-wide configuration. Instead of allowing every caller to create its own configuration object, the class creates one instance and exposes it through `getInstance()`.

## The important implementation details

```java
private static final AppConfig INSTANCE = new AppConfig();

private AppConfig() {
}

public static AppConfig getInstance() {
    return INSTANCE;
}
```

There are three important pieces here:

1. `INSTANCE` stores the one object that will be shared.
2. The constructor is `private`, so outside code cannot call `new AppConfig()`.
3. `getInstance()` gives callers access to the shared object.

So this:

```java
AppConfig first = AppConfig.getInstance();
AppConfig second = AppConfig.getInstance();
```

does not create two `AppConfig` objects. Both variables point at the same object.

The demo proves that with:

```java
first == second
```

and by changing the environment through one reference and reading the changed value through the other.

## Why this pattern is interesting

The mechanics are simple. The more important design question is whether you *should* have one globally shared object.

Singleton can make sense for things that genuinely represent one application-wide resource or service. But it can also turn into disguised global state: code anywhere in the application can reach the same mutable object, which can make dependencies less obvious and tests harder to isolate.

So the useful lesson is not just:

> How do I guarantee one instance?

It is also:

> Does this thing actually need to be globally shared?

## Singleton vs. a normal object

With a normal class, callers control creation:

```java
AppConfig config = new AppConfig();
```

With Singleton, the class controls creation:

```java
AppConfig config = AppConfig.getInstance();
```

That is why Singleton belongs to the **creational** family of patterns.

## Run the demo

From this directory:

```bash
javac AppConfig.java SingletonDemo.java
java SingletonDemo
```

Expected output includes:

```text
Same object? true
First reference:  production
Second reference: production
```

## Rule of thumb

Do not use Singleton merely because there should *usually* be one instance. Use it when enforcing one shared instance is actually part of the design. In modern applications, dependency injection is often preferable because it can provide one shared instance without making the class globally accessible.
