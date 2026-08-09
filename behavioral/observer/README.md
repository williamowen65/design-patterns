# Observer Pattern

The **Observer** pattern defines a one-to-many relationship so that when one object changes state, its dependents are notified automatically.

This demo models a weather station with `WeatherStation` as the subject and `PhoneDisplay` and `WindowDisplay` as observers.

## How often will you implement Observer yourself?

In day-to-day development, you often **use Observer more frequently than you implement the whole pattern from scratch**. UI listeners, Spring application events, event buses, callbacks, and reactive APIs commonly provide Observer-style behavior for you.

A useful signal is:

> One thing changes, several other things may need to react, and the thing changing should not need to know exactly who those things are.
