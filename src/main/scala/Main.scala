object Main extends App {

  // See the README.md file for top level notes! They are important.

  println("Hello there.")
  println("1 + 1 = " + 1 + 1)
  println("This" + "That") // Note the lack of space
  val two = 1 + 1 // IMMUTABLE!
  val two_typed: Int = 1 + 1 // NOTE the : here
  println("val two = " + two)
  println("val two typed = " + two_typed)
  println("this", "that") // Note LITERAL comma: (this,that)
  // var x = 1 + 1   // NOTE that you don't have to specify a type, but can:
  var x: Int = 1 + 1 // You need the : if you do, though.
  x = 3 // This compiles because "x" is declared with the "var" keyword.
  println("x times x: " + x * x) // 9
  // The syntax here is a little weird, IMO, but you can pass a block and it
  // will just output the value returned by the whole thing.
  println({
    val x = 1 + 1
    x + 1
  }) // 3
  println("x outside of that block: " + x) // so the scope included the global

  // FUNCTIONS
  // Anonymous:
  (x: Int) => x + 1  // NOTE: this causes a WARNING on compile.
  // Named:
  val addOne = (x: Int) => x + 1
  println("addOne(1): " + addOne(1)) // 2

  // METHODS
  def addThem(x: Int, y: Int): Int = x + y
  //  name  ( arguments     ): return type = actual code
  println("addThem(1, 2): " + addThem(1, 2)) // 3

  // Weirdly, you can pass in MULTIPLE lists:
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println("addThenMultiply(1, 2)(3) = " + addThenMultiply(1, 2)(3)) // 9

  // No param list. ...Als this is interesting:
  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  // Multi-line, of course:
  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println("getSquareString(2.5) = " + getSquareString(2.5)) // 6.25

  // CLASSES:
  // names should be CamelCase.

  //    name    named params and their types
  class ClassyGreeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }
  // Instantiate with `new`
  val greeter = new ClassyGreeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer!

  // case classes are a special ... errr... case. :|
  // They are immutable and act like values.
  // The default constructor values (`= 0`) are optional.
  case class Point(x: Int = 0, y: Int = 0) {
    // Because parent classes define toString, you have to `override` it:
    override def toString: String =
      s"P($x, $y)"
  }

  // You can instantiate them without new:
  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  // And you can natively compare them:
  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  }

  // You can use named arguments to constructors and rely on default values:
  val point2 = new Point(y = 2)
  println(point2.y) // and you can also call constructors by name as methods.

  // An Object is a singleton of its own class:
  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }
  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2

  // Traits: ...mentioned at the top of the class. The default implementation
  // here (after the `=`) is optional.
  trait Greeter {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }
  class DefaultGreeter extends Greeter

  // You override default implementations with `override`:
  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

  // NOTE: You can use a constructor without the parens, if it doesn't take args
  val defaultGreeter = new DefaultGreeter
  defaultGreeter.greet("Scala developer") // Hello, Scala developer!

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?

  // TUPLES:
  // a tuple is a value that contains a fixed number of elements, each with its
  // own type. Tuples are immutable. ...handy for returning multiple values fro
  // a method.
  // Consider using a case class instead, as they are more readable. Tuples are
  // best for smaller loops where composition is clear.
  val ingredient = ("Sugar" , 25)
  // They have weird hidden methods:
  println(ingredient._1) // Sugar
  println(ingredient._2) // 25
  // You can "take it apart" too:
  val (name, quantity) = ingredient
  println(name) // Sugar
  println(quantity) // 25
  // Perhaps more common in list comprehension:
  val numPairs = List((2, 5), (3, -7), (20, 56))
  for ((a, b) <- numPairs) {
    println(a * b)
  }

}
