package kinds

/**
  *
  */
object Kinds {

  // kind = type of types
  // level-0 types = types like Int, String can be attached to values
  val aNumber: Int = 42

  // level-1 type = "generic"
  // share the same code regardless of the type you use it with
  class LinkedList[T] { // takes type arguments in the level-0 kind.
    // code
  }

  // We use a level-1 type `LinkedList` with a level-0 `argument` (Long)
  // to create a new level-0 type called `LinkedList[Long]`
  // This mechanism looks similar to a function except in this case we work with types.
  // These generic types (LinkedList[T]) are also called `Type Constructors` because they
  // can create level-0 types.
  val aList: LinkedList[Long] = ???

  // level-2 types: Higher-kinded types

  // Functor takes a type argument which is itself generic.
  // So `Functor` is level-2 type, `F` is level-1 type.
  class Functor[F[_]]

  val functorList = new Functor[List] // here List is a level-1 type.

  // We almost never need level-3 or beyond, but Scala allows it.
  class Meta[F[_[_]]] // level-3 type

  val metaFunctor = new Meta[Functor]

  // examples
  class HashMap[K, V] // level-1
  val anAddressBook = new HashMap[String, String]

  class ComposedFunctor[F[_], G[_]] // level-2
  val aComposedFunctor = new ComposedFunctor[List, Option]

  class Formatter[F[_], T] // level-2...
  val aFormatter = new Formatter[Option, String]

  // why do we care?
  // As you increase with more complex code, you start noticing patterns in your code
  // Embrace the capability of the scala type system.


  def main(args: Array[String]): Unit = {}

}
