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

## Why make User's constructor private?

In this example, the constructor is private so callers are encouraged to construct `User` through the builder. This gives the builder one controlled place to handle defaults, validation, and construction rules.

For example, `build()` could eventually reject an invalid age or require an email under certain conditions.

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

## Run the demo

From the repository root:

```bash
javac -d out creational/builder/*.java
java -cp out creational.builder.BuilderDemo
```
