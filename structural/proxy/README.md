# Proxy Pattern

## Table of Contents

- [What problem does it solve?](#what-problem-does-it-solve)
- [The structure](#the-structure)
- [What happens in this demo?](#what-happens-in-this-demo)
- [Why share the same interface?](#why-share-the-same-interface)
- [Real-world use cases](#real-world-use-cases)
- [Proxy vs. Decorator](#proxy-vs-decorator)
- [When should I use it?](#when-should-i-use-it)
- [Run the demo](#run-the-demo)

## What problem does it solve?

A Proxy is an object that **stands in front of another object and controls access to it**.

The caller talks to the proxy as though it were talking to the real object. The proxy can decide when or whether to forward the call.

This demo uses lazy loading. Creating a `RealVideo` represents an expensive operation, so `VideoProxy` waits until somebody actually calls `play()` before creating it.

## The structure

Both objects implement the same interface:

```java
public interface Video {
    void play();
}
```

The real object does the actual work:

```java
public class RealVideo implements Video {
    public void play() {
        // actually play the video
    }
}
```

The proxy also looks like a `Video`, but holds or creates the real object:

```java
public class VideoProxy implements Video {
    private RealVideo realVideo;

    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(filename);
        }

        realVideo.play();
    }
}
```

The mental model is:

```text
Caller
  |
  v
Video interface
  |
  v
VideoProxy  ----controls access---->  RealVideo
```

## What happens in this demo?

This line creates only the lightweight proxy:

```java
Video video = new VideoProxy("design-patterns.mp4");
```

No `RealVideo` exists yet.

The first call to:

```java
video.play();
```

causes the proxy to create the expensive `RealVideo` and then delegate `play()` to it.

The second `play()` call reuses that same real object.

So the proxy is not replacing the real behavior. It is deciding **when the real object should become involved**.

## Why share the same interface?

This is the same polymorphism idea you just saw in Abstract Factory.

The caller only needs a `Video`:

```java
Video video = new VideoProxy("design-patterns.mp4");
```

Because both `VideoProxy` and `RealVideo` implement `Video`, client code does not have to change depending on which one it receives.

That substitutability is a major part of the pattern.

## Real-world use cases

### Lazy loading

Delay expensive work until it is actually needed. Examples include loading a large image, video, document, or database-backed object only when somebody accesses it.

### Authorization

A proxy can check permissions before forwarding a request:

```text
Caller -> AuthorizationProxy -> RealService
```

If the caller is authorized, the proxy delegates. Otherwise it refuses access.

### Caching

A proxy can return a cached result instead of repeatedly calling an expensive remote service.

```text
Caller -> CacheProxy -> RemoteAPI
             |
             +-- return cached result when available
```

### Remote services

A local object can act as a proxy for something running on another machine. Calling a normal-looking method may actually serialize a request, send it across the network, wait for a response, and turn that response back into an object.

RPC clients and generated API clients often feel like this from the caller's perspective.

### Logging and metrics

A proxy can record timing, request counts, or audit information before and after delegating to the real service.

## Proxy vs. Decorator

These two can look extremely similar because both wrap another object and usually share its interface.

The difference is mainly **intent**.

A Decorator wraps an object to **add behavior or capabilities**.

A Proxy wraps or stands in for an object to **control access to it**.

Useful shorthand:

> Decorator: "Do the same job, plus something extra."

> Proxy: "You talk to me, and I decide how you reach the real thing."

For example, adding compression to a stream is decorator-like. Delaying creation of that stream, checking permission before opening it, or caching access to it is proxy-like.

## When should I use it?

Proxy becomes useful when callers should use an object normally, but some access concern needs to happen transparently in front of that object.

Ask:

> Do I want the caller to think it is using the real object while another object controls access behind the scenes?

If yes, Proxy may fit.

Do not add a proxy if direct access is already simple and there is no meaningful access concern. Like the other patterns, it is a tool, not a requirement.

## Run the demo

From this directory:

```bash
javac *.java
java ProxyDemo
```

Notice that the expensive load message does not appear when `VideoProxy` is constructed. It appears only on the first call to `play()`.
