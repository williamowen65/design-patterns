# Abstract Factory Pattern

## What problem does it solve?

Abstract Factory creates **families of related objects** without making the client depend on their concrete classes.

This demo has two product types:

- `Button`
- `Checkbox`

and two matching families:

- macOS: `MacButton` + `MacCheckbox`
- Windows: `WindowsButton` + `WindowsCheckbox`

The client receives a `GUIFactory` and asks it for both products. It does not need to know which concrete family it received.

## The key idea

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

Each concrete factory creates a complete matching family:

```java
public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

`WindowsFactory` does the same thing for the Windows family.

The application can therefore say:

```java
button = factory.createButton();
checkbox = factory.createCheckbox();
```

without containing `new MacButton()`, `new WindowsButton()`, or other platform-specific creation logic.

## Why is it called "Abstract Factory"?

The factory itself is abstracted behind `GUIFactory`. The client knows what *kinds* of related objects it needs, but not which concrete versions it will receive.

Think of it as choosing a **kit** rather than choosing one object.

```text
MacFactory                 WindowsFactory
    |                            |
    +-- MacButton                +-- WindowsButton
    +-- MacCheckbox              +-- WindowsCheckbox
```

Once you choose the factory, the products stay in the same family.

## Real-world use cases

The operating-system UI example is easy to visualize, but the pattern is not specifically about operating systems. The important clue is that you need to swap **a coordinated family of related implementations**, not just one object.

### Cloud providers

An application that can run on multiple cloud providers might define a family of infrastructure services:

```text
CloudFactory
    +-- createStorage()
    +-- createQueue()
    +-- createDatabase()

AWSFactory
    +-- S3Storage
    +-- SQSQueue
    +-- DynamoDatabase

AzureFactory
    +-- AzureBlobStorage
    +-- AzureQueue
    +-- CosmosDatabase
```

Business logic can depend on `Storage`, `Queue`, and `Database` interfaces. Selecting one factory swaps the whole cloud family instead of spreading `if (aws)` / `if (azure)` checks throughout the application.

### Database families

A data-access layer might need several related database-specific objects:

```text
DatabaseFactory
    +-- createConnection()
    +-- createCommand()
    +-- createQueryBuilder()

PostgresFactory
SQLServerFactory
```

Choosing the PostgreSQL factory gives you PostgreSQL-compatible implementations of all three. Choosing SQL Server gives you the matching SQL Server family.

### Payment providers

Suppose an application supports several payment platforms and each platform requires several related services:

```text
PaymentFactory
    +-- createPaymentProcessor()
    +-- createRefundProcessor()
    +-- createSubscriptionManager()

StripeFactory
OtherPaymentProviderFactory
```

The rest of the checkout system can work against the common interfaces without knowing which provider's SDK is underneath.

### Game themes or worlds

A game could swap an entire family of objects based on its current world or theme:

```text
GameFactory
    +-- createEnemy()
    +-- createWeapon()
    +-- createBuilding()

MedievalFactory
    +-- Knight
    +-- Sword
    +-- Castle

SciFiFactory
    +-- Robot
    +-- LaserGun
    +-- SpaceStation
```

The game rules can operate on `Enemy`, `Weapon`, and `Building` while the factory keeps each world's objects consistent.

### Production vs. test dependencies

This is an especially practical use case.

A production application may need several real external services:

```text
ServiceFactory
    +-- createDatabase()
    +-- createEmailService()
    +-- createStorage()
```

A `ProductionFactory` could create the real database, email provider, and cloud storage clients. A `TestFactory` could create an in-memory database, fake email sender, and fake storage service.

```text
ProductionFactory             TestFactory
      |                            |
      +-- RealDatabase             +-- InMemoryDatabase
      +-- RealEmailService         +-- FakeEmailService
      +-- CloudStorage             +-- FakeStorage
```

One factory choice swaps the application's entire dependency family for testing.

Modern dependency-injection frameworks can accomplish this in other ways, but the underlying design idea is very similar: the application depends on abstractions while something outside the application chooses the concrete family.

### API versions

An application that supports substantially different versions of an external API could group version-specific components together:

```text
ApiFactory
    +-- createRequestBuilder()
    +-- createResponseParser()
    +-- createSerializer()

ApiV1Factory
ApiV2Factory
```

This helps keep V1 components paired with V1 components and V2 components paired with V2 components.

### The common thread

All of these examples have the same shape:

```text
                 Family A          Family B
                    |                 |
Product type 1  -> A1                B1
Product type 2  -> A2                B2
Product type 3  -> A3                B3
```

If you only need to swap **one** implementation, Abstract Factory is probably more machinery than you need.

If changing one implementation usually means several other related implementations must change with it, Abstract Factory starts to become useful.

A useful question to ask is:

> Am I choosing one object, or am I choosing a whole compatible set of objects?

The second case is where Abstract Factory fits.

## Abstract Factory vs. Factory Method

This is the most important comparison for this demo.

A Factory Method usually focuses on creating **one product type** while allowing the concrete product to vary.

Abstract Factory focuses on creating **multiple related product types that belong together**.

A useful shorthand is:

> Factory Method: Which implementation of this thing should I create?

> Abstract Factory: Which family of related things should I create?

Abstract Factory often uses factory methods internally, which is why the two patterns can look similar in code.

## Why not just use `if` statements?

You could put platform checks everywhere:

```java
if (isWindows) {
    button = new WindowsButton();
    checkbox = new WindowsCheckbox();
} else {
    button = new MacButton();
    checkbox = new MacCheckbox();
}
```

That works for a small program. The pattern becomes useful when the same family choice affects many related objects and you do not want platform-specific construction logic spread throughout the application.

## Tradeoff

Abstract Factory adds several interfaces and classes. If you only have one or two simple objects, that abstraction can be more complicated than the problem.

It pays off when:

- there are multiple product families,
- each family contains several related products,
- the client should not care which family it is using, and
- you want to swap the entire family in one place.

## Run the demo

From this directory:

```bash
javac *.java
java AbstractFactoryDemo
```

That uses the macOS family by default.

To use Windows:

```bash
java AbstractFactoryDemo windows
```

## What to notice while reading the code

Start with `Application.java`. Notice that it knows only `GUIFactory`, `Button`, and `Checkbox`.

Then look at `MacFactory` and `WindowsFactory`. Those classes are where the concrete family choice lives.

That separation is the pattern.
