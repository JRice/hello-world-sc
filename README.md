# Hello World (Scala)

Just learning the language and "documenting" how things are done.

## SOURCES:
* https://docs.scala-lang.org/getting-started/index.html
* https://docs.scala-lang.org/overviews/repl/overview.html
* https://docs.scala-lang.org/tour/tour-of-scala.html
* https://docs.scala-lang.org/overviews/scala-book/introduction.html
* https://data-flair.training/blogs/scala-constructor/ - this has plenty of good stuff, though the formatting is inconsistent. MV found it. I can't seem to find any suitable "home page" for the Scala stuff, so this is just linking to a random subpage.

## Creation

Created the structure with
```bash
sbt new scala/hello-world.g8
```

open the repl-type console by cd'ing to the project dir and then
```bash
sbt
~run
```
NOTE: ... the ~ is optional; it causes it to re-run on every save.

## Main() and Arguments

You normally need a main method, but when you extend App (as
above), things just work. An `extends` implements an abstract class. You
can also have mixins that Scala callas a "trait" (you can only extend one
class, with `extends`, but multiple traits, using `with`). An App does handle
command-line arguments through a special `args` array. It's something like
this:

```scala
object Main {
  def main(args: Array[String]): Unit
}
```

The `Unit` class is Scala's version of a void... because Scala wants to be
functional, it's assumed everything returns *something*, so what this
returns is a meaningless construct that litteally looks like `()`, but is
called Unit.

You *should* be able to compile this with `scalac Main.scala`, but I don't
think sbc encourages you to do that, so I won't try.

## Code

The main code is in [`src/main/scala/Main.scala`](https://github.com/JRice/hello-world-sc/blob/main/src/main/scala/Main.scala) ... I guess this is a typical
place to put it when you're using a "Metals" project. ...at the time of this
writing, I am still not really sure what that means. :D
