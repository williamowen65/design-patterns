# Composite Pattern

The **Composite** pattern lets you treat a single object and a group of objects through the same interface.

## A tree structure is not automatically Composite

A parent/child model such as:

```java
class Post {
    Post parent;
    List<Post> children;
}
```

creates a tree-shaped data structure, but that alone is not the Composite pattern.

Composite adds the idea that client code can treat **one object and an entire nested group through the same interface**.

**Tree structure:** objects can contain or reference other objects.

**Composite pattern:** client code can treat a single object and a nested collection in the same way.

## Real-world note: the DOM

You may use Composite without implementing it yourself. The browser DOM already provides a tree of nodes and parent/child operations. In frontend work such as drag-and-drop, APIs like `parentNode`, `childNodes`, `remove()`, and `cloneNode(true)` let you work with that existing composite-like structure.

Learning a design pattern often means recognizing a structure a framework or library already implements, not necessarily writing the whole pattern from scratch.

## Run the demo

```bash
javac *.java
java CompositeDemo
```
