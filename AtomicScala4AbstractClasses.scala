/**
  * Created by johann on 2017/03/06.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4AbstractClasses {
  def main(args: Array[String]): Unit = {
    (new Duck).templateMethod is "The Duck goes Quack"
    (new Cow).templateMethod is "The Cow goes Moo"

    val duck = new Duck
    duck.food is "plants"
    val cow = new Cow
    cow.food is "grass"

    val chicken = new Chicken
    chicken.food is "insects"
    val pig = new Pig
    pig.food is "anything"

    val num = new NumericAdder(5)
    num.add(10) is 15

    val test = new Test
    test.animal
    test.animal(5)
  }

  class Test extends Animal{
    override def food = "Chow"
    override def sound = "Meow"
    def animal = "Test"

    def animal(test: Int): Unit = {
      println("Not so odd behaviour") //uses the function when () are added. Otherwise uses the val
    }
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
    def food: String
  }

  class Duck extends Animal {
    def animal = "Duck"
    override def food = "plants"
    override def sound = "Quack"
  }

  class Cow extends Animal {
    def animal = "Cow"
    override def food = "grass"
    override def sound = "Moo"
  }

  class Chicken extends Animal {
    def animal = "Chicken"
    override def food = "insects"
    override def sound = "cluck"
  }

  class Pig extends Animal {
    def animal = "Pig"
    override def food = "anything"
    override def sound = "oink"
  }

  abstract class Adder(x: Int) {
    def add(y: Int): Int
  }

  class NumericAdder(val x: Int) extends Adder(x) {
    def add(y: Int): Int = {
      x + y
    }
  }

  case class NumsAdder(x: Int) extends Adder(x) { // seems like you can inherit abstract classes from a case class
    def add(y: Int): Int = {
      x + y
    }
  }


}
