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
