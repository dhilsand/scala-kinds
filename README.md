# Scala Kinds

## level-0 type
These are types like `Int`, `String` that can be attached to values

## level-1 type: Generics

Also called "Generic".

level-1 type = "generic"

// share the same code regardless of the type you use it with
```scala
  class LinkedList[T] {  // takes type arguments in the level-0 kind.
    // code
  }
```

A higher level type will take arguments of the inferior type. i.e. level-1 type takes arguments of level-0 type.

## level-2 type: Higher-kinded types

Functor takes a type argument which is itself generic.

So `Functor` is level-2 type, `F` is level-1 type.

```scala
  class Functor[F[_]]

  val functorList = new Functor[List] // here List is a level-1 type.
```
