/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3CaseClasses {
  def main(args: Array[String]): Unit = {
    case class Person(first: String, last: String, email: String)

    val p = Person("Jane", "Smile", "jane@smile.com")
    p.first is "Jane"
    p.last is "Smile"
    p.email is "jane@smile.com"

    val p2 = Person("Ron", "House", "ron@house.com")
    val p3 = Person("Sally", "Dove", "sally@dove.com")

    val people = Vector(p, p2, p3)

    people(0) is "Person(Jane,Smile,jane@smile.com)"
    people(1) is "Person(Ron,House,ron@house.com)"
    people(2) is "Person(Sally,Dove,sally@dove.com)"

    case class Dog(name: String, breed: String)

    val dogs = Vector(new Dog("Fido", "Golden Lab"), new Dog("Ruff", "Alaskan Malamute"), new Dog("Fifi", "Miniature Poodle"))

    dogs(0) is "Dog(Fido,Golden Lab)"
    dogs(1) is "Dog(Ruff,Alaskan Malamute)"
    dogs(2) is "Dog(Fifi,Miniature Poodle)"

    case class Dimension(var height: Int, var width: Int)

    val c = new Dimension(5, 7)
    c.height is 5
    c.height = 10
    c.height is 10
    c.width = 19
    c.width is 19

    case class Dimension2(val height: Int, var width: Int)

    c.height is 5
    c.height = 10
    c.height is 10


    case class SimpleTimeDefault(val hours: Int = 0, val minutes: Int = 0){
      def subtract(time: SimpleTimeDefault): SimpleTimeDefault = {
        if(this.minutes - time.minutes > 0)
          new SimpleTimeDefault(minutes = this.minutes - time.minutes, hours = this.hours - time.hours)
        else
          new SimpleTimeDefault(minutes = 60 + this.minutes - time.minutes, hours = this.hours - time.hours)
      }
    }

    val anotherT1 = new SimpleTimeDefault(10, 30)
    val anotherT2 = new SimpleTimeDefault(9)
    val anotherST = anotherT1.subtract(anotherT2)
    anotherST.hours is 1
    anotherST.minutes is 30
    val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
    anotherST2.hours is 0
    anotherST2.minutes is 15
  }
}
