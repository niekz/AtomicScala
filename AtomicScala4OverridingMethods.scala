/**
  * Created by johann on 2017/03/03.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4OverridingMethods {
  def main(args: Array[String]): Unit = {
    talk(new GreatApe) is "Hoo!9"
    talk(new Bonobo) is "Eep!22"
    talk(new Chimpanzee) is "Yawp!27"

    val roaringApe = new GreatApe2(112, 9, "Male")
    roaringApe.myWords() is Vector("Roar")
    val chattyBonobo = new Bonobo2(150, 14, "Female")
    chattyBonobo.myWords() is Vector("Roar", "Hello")

    val cities = Vector("Boston",
      "Albany", "Buffalo", "Cleveland",
      "Columbus", "Indianapolis",
      "St. Louis", "Kansas City",
      "Denver", "Grand Junction",
      "Salt Lake City", "Las Vegas",
      "Bakersfield", "San Francisco")

    val t = new Trip("Detroit","Houston",
      "5/1/2012","6/1/2012")
    t is "From Detroit to Houston:" +
      " 5/1/2012 to 6/1/2012"
    val a = new AirplaneTrip("Detroit",
      "London","9/1/1939",
      "10/31/1939", "Superman")
    a is
      "From Detroit to London:" +
        " 9/1/1939 to 10/31/1939" +
        ", we watched Superman"
    val c = new CarTrip(cities,
      "6/1/2012","7/1/2012")
    c.origin is "Boston"
    c.destination is "San Francisco"
    c.startDate is "6/1/2012"
    c is "From Boston to San Francisco:" +
      " 6/1/2012 to 7/1/2012"
  }

  class GreatApe{
    def call = "Hoo!"
    var energy = 3
    def eat() = {
      energy += 10
      energy
    }
    def climb(x: Int) = {
      energy -= x
    }
    def myWords(): Vector[String] = {
      Vector("Roar")
    }
  }

  class Bonobo extends GreatApe{
    override def call = {
      "Eep!"
    }
    energy = 5
    override def eat() = {
      super.eat() * 2
    }

    def run() = {
      "Bonobo runs"
    }
  }

  class Bonobo2(weight: Double, age: Int, gender: String) extends GreatApe2(weight, age, gender){
    override def myWords(): Vector[String] = {
      Vector("Roar", "Hello")
    }
  }

  class Chimpanzee extends GreatApe{
    override def call = {
      "Yawp!"
    }
    override def eat() = {
      super.eat() * 3
    }
    def jump = "Chimp jumps"
    val kind = "Common"
  }

  def talk(ape: GreatApe) = {
    // ape.run() // Not an ape method
    // ape.jump // not an ape method
    ape.climb(4)
    ape.call + ape.eat()
  }

  class GreatApe2(val weight: Double, val age: Int, val gender: String) {
    def myWords(): Vector[String] = {
      Vector("Roar")
    }
  }

  class Trip(val origin: String, val destination: String, val startDate: String, val endDate: String){
    override def toString(): String = {
      s"From $origin to $destination: $startDate to $endDate"
    }
  }

  class AirplaneTrip(origin: String, destination: String, startDate: String, endDate: String, movie: String)
    extends Trip(origin: String, destination: String, startDate: String, endDate: String)

  class CarTrip(cities: Vector[String], startDate: String, endDate: String)
    extends Trip(cities.head, cities.last, startDate: String, endDate: String)


}
