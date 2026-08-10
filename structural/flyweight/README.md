# Flyweight Pattern

## What problem does it solve?

Flyweight reduces memory usage when an application needs a very large number of objects that contain lots of duplicated data.

Instead of storing the same repeated state inside every object, the repeated part is extracted into a smaller shared object called the **flyweight**.

This demo models a forest containing many trees.

Each individual tree needs its own position:

```text
x, y
```

But many trees can share the same type information:

```text
name, color, texture
```

Rather than storing `"Oak"`, `"green"`, and `"rough-bark.png"` inside every oak tree, all oak trees point to the same `TreeType` object.

## Intrinsic vs. extrinsic state

This distinction is the heart of Flyweight.

### Intrinsic state

State that can safely be shared between many objects.

In this demo:

```text
TreeType
    name
    color
    texture
```

This data is the same for every tree of that type.

### Extrinsic state

State that belongs to one individual object and cannot be shared.

In this demo:

```text
Tree
    x
    y
```

Every tree has its own location.

A useful mental model is:

```text
Tree #1 ----\
Tree #2 -----+----> shared Oak TreeType
Tree #3 ----/

Tree #4 ----\
Tree #5 -----+----> shared Pine TreeType
```

Five `Tree` objects exist, but only two `TreeType` objects are needed.

## Where the sharing happens

`TreeTypeFactory` keeps a cache of previously created types:

```java
private static final Map<String, TreeType> TYPES = new HashMap<>();
```

When code asks for a tree type:

```java
TreeType type = TreeTypeFactory.getTreeType(
    "Oak",
    "green",
    "rough-bark.png"
);
```

The factory first checks whether that type already exists.

If it does, the existing object is returned.

If it does not, one is created and cached.

That means these calls:

```java
getTreeType("Oak", "green", "rough-bark.png");
getTreeType("Oak", "green", "rough-bark.png");
getTreeType("Oak", "green", "rough-bark.png");
```

all return the same shared `TreeType` object.

## Why not just create normal objects?

For five trees, Flyweight is unnecessary.

Imagine instead that a game has 2,000,000 trees. Suppose each tree stored a large texture, model information, animation data, and other properties that were identical for every oak tree.

Repeating all that data millions of times would waste memory.

Flyweight lets the application store the expensive shared data once and keep only small per-instance state on each individual object.

## Real-world use cases

### Video games

Games may render enormous numbers of repeated objects such as:

- trees
- grass
- rocks
- bullets
- particles
- repeated NPC models

Each object needs its own position and maybe rotation, while model and texture data can be shared.

### Text editors

A document may contain millions of characters. Instead of creating a heavyweight object containing font information for every single character, characters can share formatting or glyph data.

### Maps

A map may contain thousands of markers using the same icon. The icon image can be shared while each marker stores only coordinates and its own metadata.

### Browser rendering

Rendering systems can reuse shared style, font, or graphical resources rather than duplicating identical resource data for every visual element.

### Object pools and caches

Flyweight often appears near caching concepts because both involve reusing existing objects, although their goals are different. A general cache avoids recomputing or refetching something; Flyweight specifically focuses on **sharing duplicated state across many simultaneously existing logical objects**.

## Flyweight vs. Prototype

These can almost sound opposite.

**Prototype** says:

> I want another object like this one, so I will copy it.

**Flyweight** says:

> These objects contain the same data, so I will avoid copying that data and share it instead.

Prototype helps create separate objects efficiently. Flyweight helps many objects share common state efficiently.

## Flyweight vs. Singleton

A Singleton guarantees that there is one instance of a particular class.

Flyweight can have **many shared instances**.

For example, this demo might have one shared `TreeType` for oak trees, one for pine trees, one for maple trees, and so on.

The important rule is not "only one object." It is:

> Reuse one object for each repeated set of shared state.

## Tradeoffs

Flyweight can save a lot of memory, but it makes the object model more complicated.

You have to separate state into shared and per-instance pieces, and callers may need to provide the external state when operations occur.

Do not introduce Flyweight just because several objects happen to have identical fields. It is most useful when object count and duplicated data are large enough that memory usage is a real concern.

## Run the demo

From this directory:

```bash
javac *.java
java FlyweightDemo
```

The output should show five trees being drawn but only two shared `TreeType` objects being created.

## What to notice while reading the code

Start with `Tree.java` and `TreeType.java`.

Ask which fields are unique to one tree and which fields are repeated across many trees.

Then look at `TreeTypeFactory.java` and notice that it returns an existing object instead of creating a duplicate when the same type is requested again.

That separation between **unique state** and **shared state** is the Flyweight pattern.
