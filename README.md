# Hello World (Scala)

Just learning the language and "documenting" how things are done.

## SOURCES:
* https://docs.scala-lang.org/getting-started/index.html
* https://docs.scala-lang.org/overviews/repl/overview.html
* https://docs.scala-lang.org/tour/tour-of-scala.html
* https://docs.scala-lang.org/overviews/scala-book/introduction.html
* https://data-flair.training/blogs/scala-constructor/ - this has plenty of good stuff, though the formatting is inconsistent. MV found it. I can't seem to find any suitable "home page" for the Scala stuff, so this is just linking to a random subpage.

## Creation

We created the directory structure with
```bash
sbt new scala/hello-world.g8
```

open the REPL-type console by cd'ing to the project dir and then
```bash
sbt
~run
```
NOTE: ... the ~ is optional; it causes it to re-run on every save. ...which is handy.

## Main() and Arguments

You normally need a main method, but when you extend App (as
above), things just work.

An `extends` implements an `abstract class`. You can also have mixins that Scala
callas a "trait." You can only extend *one* class, with `extends`, but multiple
traits, using `with`. e.g.: (not worth making this part of the code)

```scala
abstract class A {
  val message: String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}
class D extends B with C

val d = new D
println(d.message)  // I'm an instance of class B
println(d.loudMessage)  // I'M AN INSTANCE OF CLASS B
```

By extending App, we handle command-line arguments through a special `args`
array. The implementation of `extends App` ends up being equivalent to something
like this:

```scala
object Main {
  def main(args: Array[String]): Unit
}
```

The `Unit` class is Scala's version of a void... because Scala wants to be
functional, it's assumed everything returns *something*, so what this
returns is a meaningless construct that litteally looks like `()`, but is
called Unit.

## Compiling

You *should* be able to compile this project with `scalac Main.scala` (maybe
with the right path), but I don't think sbc encourages you to do that, so I
won't try.

I'll explain how to do it with sbt once I figure it out. :\

I am still not clear on what Metals *is*. It lives
[here](https://scalameta.org/metals/docs/editors/overview.html)... but the docs
just say it's a "Scala language server with rich IDE features," which seems
completely meaningless to me. :-/

I seem to remember building this with
[Maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html) (or at
least installing it!), but I do not see the requisite `pom.xml` file, so I don't
think I actually did.

## Code

The main code is in [`src/main/scala/Main.scala`](https://github.com/JRice/hello-world-sc/blob/main/src/main/scala/Main.scala) ... I guess this is a typical
place to put it when you're using a "Metals" project. ...at the time of this
writing, I am still not really sure what that means. :D
