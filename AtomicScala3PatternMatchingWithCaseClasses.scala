/**
  * Created by johann on 2017/03/01.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3PatternMatchingWithCaseClasses {
  def main(args: Array[String]): Unit = {
    val travelers = Vector(
      Passenger("Harvey", "Rabbit"),
      Passenger("Dorothy", "Gale")
    )

    val trip = Vector(Train(travelers, "Reading"),
      Bus(travelers, 100)
    )

    travel(trip(0)) is "Train line Reading Vector(Passenger(Harvey,Rabbit), Passenger(Dorothy,Gale))"
    travel(trip(1)) is "Bus size 100 Vector(Passenger(Harvey,Rabbit), Passenger(Dorothy,Gale))"

    val trip2 = Vector(Train(travelers, "Reading"),
      Plane(travelers, "B757"),
      Bus(travelers, 100)
    )

    travel(trip2(1)) is "Plane B757 Vector(Passenger(Harvey,Rabbit), Passenger(Dorothy,Gale))"

    travel2(Passenger("Sally", "Marie")) is "Sally is Walking"

    travel2(Kitten("Kitty")) is "Kitten(Kitty) is in limbo!"
  }

  case class Passenger(first: String, last: String)
  case class Train(travelers: Vector[Passenger], line: String)
  case class Bus(passengers: Vector[Passenger], capacity: Int)
  case class Plane(passengers: Vector[Passenger], name: String)
  case class Kitten(name: String)

  def travel(transport: Any): String = {
    transport match {
      case Train(travelers, line) => s"Train line $line $travelers"
      case Bus(travelers, seats) => s"Bus size $seats $travelers"
      case Plane(travelers, name) => s"Plane $name $travelers"
      case Passenger => "Walking along"
      case what => s"$what is in limbo!"
    }
  }

  def travel2(transport: Any): String = {
    transport match {
      case Train(travelers, line) => s"Train line $line $travelers"
      case Bus(travelers, seats) => s"Bus size $seats $travelers"
      case Plane(travelers, name) => s"Plane $name $travelers"
      case p: Passenger => s"${p.first} is Walking"
      case what => s"$what is in limbo!"
    }
  }
}
