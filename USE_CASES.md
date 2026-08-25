# Design Pattern Use-Case Ideas

This guide is meant to spark ideas, not prescribe a pattern. Start with the problem, then consider a pattern when its intent matches what the software needs.

## Creational patterns

### [Abstract Factory](creational/abstract-factory/)

Create compatible families of related objects without naming their concrete classes.

- light-theme and dark-theme families of buttons, cards, dialogs, and icons
- database-specific repositories, queries, and connection objects
- Windows, macOS, and Linux UI component families
- game worlds that produce matching characters, terrain, weapons, and sound sets
- Atlas renderers that create coordinated desktop, mobile, or accessibility-focused graph controls

### [Builder](creational/builder/)

Construct a complicated object one understandable choice at a time.

- HTTP requests with optional headers, query parameters, authentication, and bodies
- search queries containing filters, sorting, pagination, and date ranges
- configuration objects with many optional settings
- emails assembled from recipients, subject, content, attachments, and metadata
- Atlas posts composed from text, images, polls, charts, citations, and relationship blocks

### [Factory Method](creational/factory-method/)

Let subclasses decide which concrete object a creation step returns.

- logistics applications creating truck, ship, or aircraft transports
- document editors creating different document types
- notification services producing email, SMS, or push notifications
- import pipelines creating format-specific parsers
- test frameworks creating platform-specific drivers or fixtures

### [Prototype](creational/prototype/)

Create new objects by copying a configured example.

- duplicating slides, diagrams, shapes, or design elements
- spawning game characters from configured templates
- cloning document or project templates
- copying a complex test setup before changing one variable
- duplicating an Atlas issue or proposal as the starting point for an alternative

### [Singleton](creational/singleton/)

Provide one shared instance when exactly one coordinated instance is genuinely required.

- application-wide configuration loaded once
- a process-level metrics registry
- a centralized hardware or print-spooler controller
- a shared cache coordinator
- a single in-process event registry

Singleton is often overused. Dependency injection can still create one shared instance while making ownership and testing clearer.

## Structural patterns

### [Adapter](structural/adapter/)

Make an existing interface usable where a different interface is expected.

- wrapping a third-party payment API behind the application's payment interface
- converting a legacy data model into a new domain model
- translating Celsius data into an interface that expects Fahrenheit
- presenting different cloud-storage SDKs through one storage interface
- adapting imported graph formats into Atlas nodes and relationships

### [Bridge](structural/bridge/)

Separate two dimensions that need to vary independently.

- remote-control types separated from TV, radio, and streaming-device types
- notifications separated from email, SMS, push, and Slack delivery channels
- shapes separated from raster, SVG, canvas, and PDF renderers
- reports separated from HTML, CSV, spreadsheet, and PDF output
- Atlas graph views separated from D3, WebGL, static-image, and accessible-list renderers

### [Composite](structural/composite/)

Treat individual objects and nested groups through the same interface.

- files and folders
- UI controls and containers
- organization units containing people and smaller units
- menu items and submenus
- Atlas issues containing recursively nested sub-issues

### [Decorator](structural/decorator/)

Add optional behavior by wrapping an object without changing its class.

- adding compression and encryption around a data stream
- adding caching, retries, or logging around a service
- combining coffee add-ons or pizza toppings
- adding borders, scrolling, or shadows to UI elements
- layering permissions, moderation markers, or analytics around Atlas post operations

### [Facade](structural/facade/)

Offer one simple entry point to a complicated subsystem.

- a home-theater controller that coordinates the screen, sound, lights, and player
- a checkout service that coordinates inventory, payment, shipping, and receipts
- a media converter hiding codecs, streams, and file handling
- a deployment API hiding build, upload, release, and health-check steps
- an Atlas publishing facade coordinating validation, persistence, indexing, notifications, and live updates

### [Flyweight](structural/flyweight/)

Share repeated intrinsic data while keeping unique contextual data outside it.

- rendering thousands of trees that share species, texture, and color data
- text editors sharing glyph and font information across characters
- map markers sharing icon and styling definitions
- games sharing meshes and textures across many objects
- Atlas graph nodes sharing visual style definitions instead of duplicating them per node

### [Proxy](structural/proxy/)

Stand in for another object to control or delay access to it.

- lazy-loading a large image or video
- checking permissions before calling a protected service
- caching results from a remote API
- recording calls for logging, metrics, or auditing
- loading Atlas node details only when a user zooms in or opens a card

## Behavioral patterns

### [Chain of Responsibility](behavioral/chain-of-responsibility/)

Pass a request through potential handlers until one handles it or the chain ends.

- customer-support escalation from FAQ to specialist to manager
- HTTP middleware for authentication, validation, logging, and rate limiting
- approval workflows based on cost or risk
- event bubbling through nested UI components
- Atlas moderation checks that escalate questionable content through increasingly expensive rules

### [Command](behavioral/command/)

Represent an action as an object.

- undo and redo in editors
- queueing background jobs
- recording macros or action histories
- scheduling operations for later execution
- Atlas commands for creating, linking, moving, voting on, or deleting graph nodes—with undo support

### [Interpreter](behavioral/interpreter/)

Represent a small language or rule grammar as an object structure that can be evaluated.

- search-filter expressions such as `author:will AND score>10`
- validation and eligibility rules
- spreadsheet-like formulas
- access-control policies
- Atlas queries or community-created rules built from AND, OR, NOT, comparison, and topic expressions

### [Iterator](behavioral/iterator/)

Traverse a collection without exposing how it stores its elements.

- stepping through a playlist without exposing its internal list
- traversing a tree depth-first or breadth-first
- paging through remote API results as if they were one sequence
- scanning database results lazily
- walking visible Atlas nodes differently from the entire underlying graph

### [Mediator](behavioral/mediator/)

Centralize communication among objects so they do not depend directly on one another.

- chat rooms coordinating messages among users
- dialog boxes coordinating fields, buttons, and validation
- air-traffic control coordinating aircraft
- event buses coordinating independent application modules
- Atlas real-time collaboration coordinating users, graph edits, presence, and notifications

### [Memento](behavioral/memento/)

Capture state so it can be restored without exposing the object's internals.

- editor snapshots for undo
- game save points
- restoring a form after navigating away
- transaction checkpoints
- saving an Atlas graph-editing session or returning to a previous exploration state

### [Observer](behavioral/observer/)

Notify interested subscribers automatically when something changes.

- UI components reacting to application-state changes
- price, weather, or inventory alerts
- event listeners in browser applications
- publishing domain events to analytics and notification services
- updating Atlas votes, comments, live-user indicators, and graph views in real time

### [State](behavioral/state/)

Let an object change its behavior as its internal state changes.

- media players that behave differently when stopped, playing, or paused
- orders moving through pending, paid, shipped, delivered, and cancelled states
- connection objects moving through disconnected, connecting, and connected states
- document workflows moving through draft, review, published, and archived states
- Atlas proposals changing available actions as they move through drafting, discussion, voting, and resolution

### [Strategy](behavioral/strategy/)

Make an algorithm replaceable at runtime.

- selecting credit-card, PayPal, or bank-transfer payment
- choosing sorting, routing, compression, or recommendation algorithms
- switching tax or shipping calculations by region
- selecting different authentication methods
- letting Atlas users switch graph layout algorithms or ranking methods

### [Template Method](behavioral/template-method/)

Define the fixed sequence of an algorithm while subclasses customize selected steps.

- importing CSV, JSON, and XML through the same parse-validate-save workflow
- generating reports through shared gather-format-export steps
- processing payments through authorize-capture-receipt steps
- building platform-specific applications through a common build pipeline
- publishing different Atlas content types through a shared validation and indexing lifecycle

### [Visitor](behavioral/visitor/)

Add new operations to a stable set of object types without placing every operation inside those objects.

- exporting an abstract syntax tree to source code, bytecode, or documentation
- calculating area, drawing, and validating a stable set of shape types
- producing reports from a stable domain model
- running accessibility, security, or consistency checks over a document tree
- applying analytics, export, validation, search indexing, or visualization operations to Atlas node types

## Quick problem-to-pattern prompts

- “I need to swap an algorithm.” → **Strategy**
- “I need undoable actions.” → **Command**
- “I have objects nested inside objects.” → **Composite**
- “I need to wrap optional behavior around an object.” → **Decorator**
- “Two dimensions of the design should vary independently.” → **Bridge**
- “Many objects repeat the same heavy data.” → **Flyweight**
- “I need a simpler front door to a complicated subsystem.” → **Facade**
- “I need to translate an incompatible API.” → **Adapter**
- “Behavior depends on the object's current lifecycle stage.” → **State**
- “Many objects need to react to one change.” → **Observer**
- “I want to add operations without changing stable element classes.” → **Visitor**
- “I am implementing a small rules language.” → **Interpreter**

The same code can resemble several patterns. Choose based on the design problem and intent, not just the class diagram.
