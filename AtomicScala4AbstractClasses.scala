/**
  * Created by johann on 2017/03/06.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4AbstractClasses {
  def main(args: Array[String]): Unit = {
    (new Duck).templateMethod is "The Duck goes Quack"
    (new Cow).templateMethod is "The Cow goes Moo"
  }

  abstract class WithValVar{
    val x: Int
    var y: Int
  }

  abstract class WithMethod{
    def f(): Int
    def g(n: Double)
  }

  abstract class Animal{
    def templateMethod = s"The $animal goes $sound"

    def animal: String
    def sound: String
  }

  class Duck extends Animal {
    def animal = "Duck"

    override def sound = "Quack"
  }

  class Cow extends Animal {
    def animal = "Cow"
    override def sound = "Moo"
  }


}
