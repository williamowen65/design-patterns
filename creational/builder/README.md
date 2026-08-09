# Builder Pattern

Builder is a **creational design pattern** used when constructing an object involves several pieces of configuration, especially when many of them are optional.

## The problem

Imagine a `User` object with several constructor parameters:

```java
User user = new User("Will", "will@example.com", 42, "Seattle", true);
```

As the object grows, it becomes difficult to remember what each argument means. Optional values can also lead to many overloaded constructors.

Builder separates the **construction process** from the finished object.

## What the familiar syntax is doing underneath

The demo can create a user like this:

```java
User user = new User.Builder("Will")
        .email("will@example.com")
        .age(42)
        .location("Seattle")
        .emailNotifications(true)
        .build();
```

The important implementation detail is that each configuration method returns the same `Builder` object:

```java
public Builder email(String email) {
    this.email = email;
    return this;
}
```

That `return this` is what makes the calls chain together:

```text
new Builder("Will")
      |
      v
.email(...)
      |
      v
.age(...)
      |
      v
.location(...)
      |
      v
.build()
```

Until `build()` is called, you are configuring the **Builder**, not the final `User`.

## There are two objects involved

One reason `User.java` can look strange at first is that it contains the finished `User` class and a nested `User.Builder` class.

The builder is a temporary object that collects configuration:

```text
TEMPORARY BUILDER                 FINAL USER
-----------------                 ----------
name = "Will"       --------->    name = "Will"
email = "..."       --------->    email = "..."
age = 42             --------->    age = 42
location = "..."    --------->    location = "..."
```

The flow is:

```text
create User.Builder
        |
        v
collect configuration
        |
        v
call build()
        |
        v
new User(builder)
        |
        v
finished User
```

This also explains why some fields appear twice in `User.java`: the Builder temporarily holds them while the object is being configured, and the final `User` stores them after construction is complete.

## What build() does

Eventually:

```java
public User build() {
    return new User(this);
}
```

The private `User` constructor receives the builder and copies its accumulated values into the finished object:

```java
private User(Builder builder) {
    this.name = builder.name;
    this.email = builder.email;
    this.age = builder.age;
    this.location = builder.location;
    this.emailNotifications = builder.emailNotifications;
}
```

This is the part that is often hidden when you only encounter Builder-style APIs as a user of a library.

## Why `return this`?

A method such as:

```java
public Builder age(int age) {
    this.age = age;
    return this;
}
```

changes the current Builder and then returns that **same Builder object**. Because the returned object also has methods such as `email()`, `location()`, and `build()`, another call can immediately be chained onto it.

So the chained syntax is mostly a convenient interface over repeated calls on the same temporary Builder object.

## Builder is largely about a better construction interface

Builder does not magically give an object capabilities that a normal constructor cannot have. A normal constructor can create the object, validate arguments, assign defaults, and enforce rules.

For example:

```java
public User(String name, int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Invalid age");
    }

    this.name = name;
    this.age = age;
}
```

That is completely valid. If the constructor remains small and obvious, a Builder may add unnecessary complexity.

The Builder becomes valuable when the **interface for constructing the object** starts becoming cumbersome.

Compare:

```java
new User(
    "Will",
    "will@example.com",
    42,
    null,
    true,
    false,
    "Seattle",
    null
);
```

Without looking at the constructor declaration or relying on IntelliSense, it may be difficult to know what `null`, `true`, and `false` represent.

The Builder version documents the choices directly in the calling code:

```java
new User.Builder("Will")
    .email("will@example.com")
    .age(42)
    .location("Seattle")
    .emailNotifications(true)
    .build();
```

Even if you have no IntelliSense, you can inspect the Builder class and see its available configuration methods. You also do not need placeholder values for optional settings you do not want to specify.

A useful summary is:

> **Builder gives you a readable, step-by-step interface for configuring and constructing an object, especially when the object has many optional settings.**

## Validation is not the defining feature

Validation can happen in a normal constructor or in a Builder. Builder is not primarily a validation pattern.

For example, a Builder could validate before construction:

```java
public User build() {
    if (age != null && age < 0) {
        throw new IllegalArgumentException("Invalid age");
    }

    return new User(this);
}
```

But the same rule could also live in a constructor. The main reason to choose Builder is usually that it makes complicated construction easier to understand and use.

## Why make User's constructor private?

In this example, the constructor is private so callers are encouraged to construct `User` through the builder. This gives the builder one controlled construction path for defaults, validation, and configuration rules.

The constructor still exists underneath the pattern. The Builder eventually calls it.

## Builder vs Factory Method

A useful distinction:

**Factory Method:**

> Which kind of object should be created?

**Builder:**

> How should this potentially complicated object be assembled/configured?

A system can even use both patterns together.

## When Builder is useful

Builder is especially helpful when:

- an object has many constructor arguments
- many arguments are optional
- constructor calls become hard to read
- you want readable named configuration methods
- object construction requires validation or multiple steps
- you want the finished object to be immutable

## When it may be overkill

For a tiny object such as:

```java
new Point(10, 20)
```

adding a builder would probably make the code more complicated rather than simpler.

A good design instinct is:

> **If a normal constructor is already clean and understandable, do not add Builder merely because it is a design pattern.**

## Run the demo

From the repository root:

```bash
javac -d out creational/builder/*.java
java -cp out creational.builder.BuilderDemo
```
