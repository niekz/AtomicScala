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

    plus1("car") is "cars"
    plus1(67) is 68
    plus1(Person("Joanna")) is "Person(Joanna) + guest"

    convertToSize(45) is 45
    convertToSize("car") is 3
    convertToSize("truck") is 5
    convertToSize(Person("Joanna")) is 1
    convertToSize(45.6F) is 45.6F
    convertToSize(Vector(1, 2, 3)) is 0

    convertToSize2(45) is 45
    convertToSize2("car") is 3
    convertToSize2("truck") is 5
    convertToSize2(Person("Joanna")) is 1
    convertToSize2(45.6F) is 46
    convertToSize2(Vector(1, 2, 3)) is 0

    quantify(100) is "medium"
    quantify(20.56) is "small"
    quantify(100000) is "large"
    quantify(-15999) is "small"

    forecast(100) is "Sunny"
    forecast(81) is "Sunny"
    forecast(80) is "Mostly Sunny"
    forecast(51) is "Mostly Sunny"
    forecast(50) is "Partly Sunny"
    forecast(21) is "Partly Sunny"
    forecast(20) is "Mostly Cloudy"
    forecast(1) is "Mostly Cloudy"
    forecast(0) is "Cloudy"
    forecast(-1) is "Unknown"
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

  def plus1(x: Any): Any = {
    x match {
      case s: String => s + "s"
      case i: Int => i + 1
      case p: Person => s"$p + guest"
      case _ => ""
    }
  }

  def convertToSize(x: Any): Any = {
    x match {
      case s: String => s.length
      case i: Int => i
      case d: Double => d
      case f: Float => f
      case p: Person => 1
      case _ => 0
    }
  }

  def convertToSize2(x: Any): Int = {
    x match {
      case s: String => s.length
      case i: Int => i
      case d: Double => math.round(d).toInt
      case f: Float => math.round(f)
      case p: Person => 1
      case _ => 0
    }
  }

  def quantify(x: Any): String = {
    x match {
      case iS: Int if(iS < 100) => "small"
      case iM: Int if(iM < 1000 && iM >= 100) => "medium"
      case iL: Int if(iL > 1000) => "large"
      case dS: Double if(dS < 100) => "small"
      case dM: Double if(dM < 1000 && dM >= 100) => "medium"
      case dL: Double if(dL > 1000) => "large"
    }
  }

  def forecast(n: Int): String = {
    n match {
      case i if(i > 80) => "Sunny"
      case i if(i <= 80 && i > 50) => "Mostly Sunny"
      case i if(i <= 50 && i > 20) => "Partly Sunny"
      case i if(i <= 20 && i > 0) => "Mostly Cloudy"
      case 0 => "Cloudy"
      case _ => "Unknown"
    }
  }

}
