/**
  * Created by johann on 2017/03/01.
  */
import com.atomicscala.AtomicTest._

object AtomicScala4IdiomaticScala {
  def main(args: Array[String]): Unit = {
    new fors()
  }
  class ifs {
    def if4(z: Boolean) =
      if (z)
        println("It's true")
      else
        println("It's false")

    def if5() =
      if (99 > 100) {
        4
      }
      else {
        42
      }

  }

  class fors {
    println((0 to 9).map(_.toString).reduceLeft(_ + " " + _))
    /*
    var result = ""
    for(i <- 0 to 9){
      result += i + " "
    }
    */

    println((0 until 10).map(_.toString).reduceLeft(_ + " " + _))
    /*
    result = ""
    for(i <- 0 until 10)
      result += i + " "
    */

    println(Range(0, 10).map(_.toString).reduceLeft(_ + " " + _)) // map all elements to strings, then add together.
    /*
    result = ""
    for(i <- Range(0, 10))
      result += i + " "
      */

    println(Range(0, 20, 2).sum)
    /*
    result = ""
    for(i <- Range(0, 20, 2))
      result += i + " "
    */
    println(Range(0, 20, 2).sum)
    /*var sum = 0
    for(i <- Range(0, 20, 2)) {
      println("adding " + i + " to " + sum)
      sum += i
    }*/
  }

  class CompoundExpressions{
    val activity = "swimming"
    val hour = 10

    val isOpen = {
      if(activity == "swimming" ||
        activity == "ice skating"){
        val opens = 9
        val closes = 20
        println("Operating hours: " +
          opens + " - " + closes)
        if(hour >= opens && hour <= closes)
          true
        else
          false
      } else
        true

    }

    println(isOpen)
  }

  class Methods{
    def addMultiply(x: Int, y: Double, s: String): Double = {
      println(s)
      (x+y) * 2.1
    }


  }

  class MoreConditionals{
    def CheckTruth(exp1: Boolean, exp2: Boolean): String = {
      if(exp1 && exp2)
        "Both are true"
      else if(!exp1 && !exp2)
        "Both are false"
      else if(exp1)
        "First: true, second: false"
      else
        "First: false, second: true"
    }
  }

  class MethodsInsideClasses{
    class Dog {
      def bark: String = { "Yip!" }
    }

    class Cat {
      def meow: String = { "mew!" }
    }

    class Hamster {
      def speak: String = { "squeak!" }
      def exercise: String = {
        speak + " Running on wheel"
      }
    }
  }

  class VariableClassArgs{
    class ClassArg(a: Int){
      println(f)
      def f: Int = { a * 10 }
    }

    class Sum(args: Int*) {
      def result(): Int = {

        args.sum // sum is built in and already does all this.
        /*
        var total = 0
        for(n <- args) {
          total += n
        }
        total
        */
      }
    }

  }




}
