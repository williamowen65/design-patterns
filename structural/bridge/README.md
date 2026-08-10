# Bridge Pattern

## What problem does it solve?

Bridge is useful when you have **two independent dimensions that may both vary**, and you do not want to create a subclass for every combination.

In this demo, the two dimensions are:

- remote controls: `RemoteControl` and `AdvancedRemoteControl`
- devices: `TV` and `Radio`

Without Bridge, you could end up inventing classes like:

```text
TVRemote
RadioRemote
AdvancedTVRemote
AdvancedRadioRemote
```

As you add more remote types and more device types, the number of combinations grows quickly.

Bridge avoids that by using composition.

## The bridge

The remote stores a reference to the `Device` interface:

```java
public class RemoteControl {
    protected final Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }
}
```

The remote handles the higher-level operation:

```java
public void volumeUp() {
    device.setVolume(device.getVolume() + 10);
}
```

but delegates the device-specific work through the `Device` interface.

That reference is the "bridge" between the two sides.

## Two sides can vary independently

```text
Abstraction side                Implementation side

RemoteControl  -----------+----> Device
                          |        |
AdvancedRemoteControl ----+        +-- TV
                                   +-- Radio
```

You can add a new remote type without changing `TV` or `Radio`.

You can add a new device type without changing `RemoteControl` or `AdvancedRemoteControl`.

That independence is the main reason to use Bridge.

## Why composition instead of inheritance?

If `RemoteControl` inherited directly from a concrete device, the two concepts would become tightly coupled.

Bridge instead says:

> A remote **has a device** rather than **is a device**.

That lets the same remote implementation work with different device implementations at runtime:

```java
RemoteControl tvRemote = new RemoteControl(new TV());
RemoteControl radioRemote = new RemoteControl(new Radio());
```

The `RemoteControl` code does not care which concrete `Device` it received.

## A useful way to recognize Bridge

Look for a design where you find yourself combining two class hierarchies.

For example:

```text
Shapes:          Circle, Square
Renderers:       SVG, Canvas, PDF

Notifications:   Alert, Reminder, Report
Delivery:        Email, SMS, Push

Controls:        BasicRemote, AdvancedRemote
Devices:         TV, Radio, Projector
```

If each item on the left can work with each item on the right, inheritance can create a combinatorial explosion.

Bridge lets you compose one from each side instead.

## More real-world examples

### Shapes and rendering engines

A `Shape` abstraction could delegate drawing to a `Renderer` implementation.

```text
Shape
  +-- Circle
  +-- Square

Renderer
  +-- SVGRenderer
  +-- CanvasRenderer
  +-- PDFRenderer
```

Now `Circle` does not need separate subclasses like `SVGCircle`, `CanvasCircle`, and `PDFCircle`.

### Notifications and delivery channels

A notification abstraction might represent *what* is being sent, while a delivery implementation represents *how* it is delivered.

```text
Notification
  +-- Alert
  +-- Reminder
  +-- Report

DeliveryChannel
  +-- Email
  +-- SMS
  +-- PushNotification
```

A `Reminder` can be paired with any delivery channel without creating a new subclass for every combination.

### Database abstraction and drivers

A higher-level repository or database abstraction can delegate lower-level operations to a driver implementation.

```text
Database
  +-- AnalyticsDatabase
  +-- TransactionDatabase

Driver
  +-- PostgresDriver
  +-- MySqlDriver
```

The two concerns can evolve independently.

## Bridge vs. Adapter

These can look similar because both often involve one object holding another object through an interface.

The intent is different.

**Adapter** usually comes in after two existing interfaces do not match. It makes one interface look like another.

**Bridge** is usually designed up front to keep two dimensions independent.

A useful shorthand:

> Adapter: "These two things do not fit. Make them compatible."

> Bridge: "These two things should vary independently. Keep them separate."

## Bridge vs. Strategy

Bridge can also resemble Strategy because both use composition and interfaces.

Strategy usually swaps **one algorithm or behavior** inside a context.

Bridge separates **two larger abstractions/hierarchies** that are expected to evolve independently.

## Run the demo

From this directory:

```bash
javac *.java
java BridgeDemo
```

The demo uses a basic remote with a TV, then an advanced remote with a radio.

## What to notice while reading the code

Start with `RemoteControl.java` and notice this field:

```java
protected final Device device;
```

That single reference is the key to the pattern.

Then notice that `AdvancedRemoteControl` extends the **remote side**, while `TV` and `Radio` implement the **device side**.

Neither hierarchy has to know the concrete classes on the other side.
