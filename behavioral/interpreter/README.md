# Interpreter Pattern

## Intent

Represent the grammar of a small language as objects, then evaluate a sentence by interpreting the resulting object structure.

## Demo

This example implements a tiny arithmetic language with numbers, addition, and subtraction. The expression `(10 + 5) - 3` becomes a tree of objects:

- `NumberExpression` represents a number.
- `AddExpression` represents addition.
- `SubtractExpression` represents subtraction.
- `Expression.interpret()` evaluates any node in the tree.

Each operation asks its child expressions for their values, so a complex expression is evaluated recursively.

## Key idea

> Turn each grammar rule into a class, then compose those classes into a syntax tree.

The pattern is most useful for small, stable languages such as search filters, validation rules, configuration expressions, and simple query syntax. For a large programming language, a parser generator or dedicated parsing library is usually a better choice.

## Structure

- `Expression` — common interface for every grammar element.
- `NumberExpression` — terminal expression; it has no child expressions.
- `AddExpression` and `SubtractExpression` — nonterminal expressions that combine other expressions.
- `InterpreterDemo` — constructs and evaluates the expression tree.

## Tradeoffs

### Advantages

- grammar rules map directly to focused classes
- new expressions can be added without changing existing expression classes
- the syntax tree is easy to compose and test

### Disadvantages

- a class-heavy design for even a modest grammar
- precedence, parsing, and error reporting can become complicated
- evaluation logic is distributed across many expression classes

## Run

```bash
javac *.java
java InterpreterDemo
```

Expected output:

```text
(10 + 5) - 3 = 12
```
