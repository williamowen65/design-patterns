# Composite Pattern

The **Composite** pattern lets you treat a single object and a group of objects through the same interface.

This is especially useful for tree-like structures such as:

- folders containing files and other folders
- menus containing menu items and submenus
- UI components containing other UI components
- organization charts
- comment threads

## The idea

Suppose we want to represent a file system. A file is a single object, but a folder can contain many files and even other folders.

Without Composite, client code often has to ask:

> Is this a file or a folder?

and then handle each case differently.

With Composite, both `FileItem` and `Folder` implement the same `FileSystemItem` interface. That means the client can call the same method on either one.

## Roles in this demo

- `FileSystemItem` — the common component interface
- `FileItem` — a leaf object with no children
- `Folder` — a composite object that can contain other `FileSystemItem` objects
- `CompositeDemo` — the client

## Key idea

The client can treat this:

```text
notes.txt
```

and this:

```text
Documents/
    notes.txt
    Photos/
        vacation.jpg
```

as the same general type: `FileSystemItem`.

## A tree structure is not automatically the Composite pattern

A useful distinction is that **having parent/child relationships does not by itself mean an application is using the Composite design pattern**.

For example, imagine a mind-map or discussion application where every post can reference a parent and its children:

```java
class Post {
    Post parent;
    List<Post> children;
}
```

That creates a perfectly valid tree:

```text
             Post A
            /      \
        Post B     Post C
        /   \
    Post D  Post E
```

This is a **tree-shaped data structure**. The references describe relationships between posts, but that alone is not the Composite pattern.

Composite adds another idea: client code should be able to treat **one object and an entire nested group of objects through the same interface**.

For example:

```java
interface MindMapItem {
    void display();
}

class Post implements MindMapItem {
    public void display() {
        // display this one post
    }
}

class PostGroup implements MindMapItem {
    List<MindMapItem> children;

    public void display() {
        for (MindMapItem child : children) {
            child.display();
        }
    }
}
```

Now client code could call `display()` on either one individual `Post` or a `PostGroup` representing a whole branch of the mind map.

So a useful way to remember the distinction is:

**Tree structure:**

> Objects can contain or reference other objects.

**Composite pattern:**

> Client code can treat a single object and a whole nested collection of objects in the same way.

If a parent/child model already solves the application's problem, there is no reason to introduce Composite merely because the data forms a tree. Composite becomes useful when treating leaves and groups uniformly actually simplifies the application's behavior.

## When Composite is useful

Use Composite when:

- your objects naturally form a tree
- containers and individual objects should be used in similar ways
- you want recursive behavior without lots of type checks

## Tradeoffs

Composite simplifies client code, but it can make the common interface very general. Sometimes leaf objects end up implementing methods that only really make sense for containers.

## Composite vs Decorator

Both patterns can wrap or contain objects that share an interface, but their goals differ:

- **Composite** represents part-whole tree structures.
- **Decorator** adds behavior to an object dynamically.

## Run the demo

From this directory:

```bash
javac *.java
java CompositeDemo
```
