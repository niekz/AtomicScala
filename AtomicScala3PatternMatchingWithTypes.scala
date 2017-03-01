/**
  * Created by johann on 2017/03/01.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3PatternMatchingWithTypes {
  def main(args: Array[String]): Unit = {
    acceptAnything(5) is "An Int Less than 20: 5"
    acceptAnything(25) is "Some Other Int: 25"
    acceptAnything("Some text") is "A String: Some text"

    val bob = Person("Bob")
    acceptAnything(bob) is "A person Bob"
    acceptAnything(Vector(1, 2, 5)) is "I don't know what that is!"
  }

  def acceptAnything(x: Any): String = {
    x match {
      case s: String => "A String: " + s
      case i: Int if(i < 20) => s"An Int Less than 20: $i"
      case i: Int => s"Some Other Int: $i"
      case p: Person => s"A person ${p.name}"
      case _ => "I don't know what that is!"
    }
  }

  case class Person(name: String)

}
