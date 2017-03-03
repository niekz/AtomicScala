/**
  * Created by johann on 2017/03/03.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4BaseClassInitialization {
  def main(args: Array[String]): Unit  = {
    display(new GreatApe(100, 12)) is "weight: 100.0 age: 12"
    display(new Bonobo(100, 12)) is "weight: 100.0 age: 12)"
    display(new Chimpanzee(100, 12)) is "weight: 100.0 age: 12"
    display(new BonoboB(100, 12)) is "weight: 100.0 age: 12"

    //val h = new Home("888 N. Main St.", "KS", "66632", "Metropolis")
    //h.address is "888 N. Main St."
    //h.state is "KS"
    //h.name is "Metropolis"
    //h is "Metropolis: 888 N. Main St., KS, 66632"

    val v = new VacationHouse("KS", "66632", 6, 8)
    v.state is "KS"
    v.startMonth is 6
    v.endMonth is 8

    val tree = new TreeHouse("Oak", "48104")
    tree.name is "Oak"
    tree.zip is "48104"

    /*
    case class Test(n: Int)
    case class Test2(n: Int, m: Int) extends Test(n: Int)
    class X(n: Int, y: Int) extends Test(n: Int) // Book says this isn't possible anymore?
    println(new X(12, 24))
    */


    val test = new BonoboC(112, 8, "Male")
    test.gender is "Male"
    test.myWords() is Vector("Roar")

    val h = new Home("THIS", "IS", "SPARTAAAAAA", true)

    val v2 = new VacationHouse("MI", "49431", 6, 8)
    v2 is "Rented house in MI for months of June through August"

    val t = new Trip("Detroit", "Houston", "5/1/2012", "6/1/2012")
    val a = new AirplaneTrip("Detroit", "London", "9/1/1939", "10/31/1939", "Superman")
    val cities = Vector("Boston",
      "Albany", "Buffalo", "Cleveland",
      "Columbus", "Indianapolis",
      "St. Louis", "Kansas City",
      "Denver", "Grand Junction",
      "Salt Lake City", "Las Vegas",
      "Bakersfield", "San Francisco")
    val c = new CarTrip(cities, "6/1/2012", "7/1/2012")

    c.origin is "Boston"
    c.destination is "San Francisco"
    c.startDate is "6/1/2012"
    t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
    c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012"
  }

  class GreatApe(val weight: Double, val age: Int)
  class GreatApe2(val weight: Double, val age: Int, val gender: String) {
    def myWords(): Vector[String] = {
      Vector("Roar")
    }
  }

  class Bonobo2(weight: Double, age: Int, gender: String) extends GreatApe2(weight: Double, age: Int, gender: String)
  class BonoboB2(weight: Double, age: Int, gender: String) extends Bonobo2(weight: Double, age: Int, gender: String)
  class BonoboC(weight: Double, age: Int, gender: String) extends BonoboB2(weight: Double, age: Int, gender: String)

  class Bonobo(weight: Double, age: Int) extends GreatApe(weight, age)
  class Chimpanzee(weight: Double, age: Int) extends GreatApe(weight, age)
  class BonoboB(weight: Double, age: Int) extends Bonobo(weight, age)

  def display(ape:GreatApe) = {
    s"weight: ${ape.weight} age: ${ape.age}"
  }

  class House(val address: String, val state: String, val zip: String){
    def this(state: String, zip: String) = {
      this("address?", state, zip)
    }
    def this(zip: String) = {
      this("address?", "state?", zip)
    }
  }

  /*
  class Home(address: String, state: String, zip: String, val name: String)
    extends House(address, state, zip) {
    override def toString = {
      s"$name: $address, $state, $zip"
    }
  }
  */
  class Month(i: Int) {
    override def toString(): String = {
      i match {
        case 1 => "January"
        case 2 => "February"
        case 3 => "March"
        case 4 => "April"
        case 5 => "May"
        case 6 => "June"
        case 7 => "July"
        case 8 => "August"
        case 9 => "September"
        case 10 => "October"
        case 11 => "November"
        case 12 => "December"
      }
    }
  }
  class VacationHouse(state: String, zip: String, val startMonth: Int, val endMonth: Int)
    extends House(state, zip) {
    override def toString(): String = {
      s"Rented house in $state for months of ${new Month(startMonth)} through ${new Month(endMonth)}"
    }
  }

  class TreeHouse(val name: String, zip: String)
    extends House(zip)

  class Home(address: String, state: String, zip: String, heart: Boolean) extends House(address: String, state: String, zip: String)

  class Trip(val origin: String, val destination: String, val startDate: String, val endDate: String){
    override def toString(): String = {
      s"From $origin to $destination: $startDate to $endDate"
    }
  }

  class AirplaneTrip(origin: String, destination: String, startDate: String, endDate: String, movie: String)
    extends Trip(origin: String, destination: String, startDate: String, endDate: String)

  class CarTrip(cities: Vector[String], startDate: String, endDate: String)
    extends Trip(cities.head, cities.last, startDate: String, endDate: String)

  case class Test(val n: Int)
  class Test2(n: Int) extends Test(n: Int) // seems fine??

  // the following is not allowed, but case class -> class is
 // case class Test2(val n: Int)
 // case class TestInherit(n: Int) extends Test2(n)
 // class OtherTest(val n: Int)
  //case class OtherTest2(n: Int) extends OtherTest(n)


}

