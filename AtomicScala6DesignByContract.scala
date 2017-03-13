/**
  * Created by johann on 2017/03/13.
  */

import com.atomicscala.AtomicTest._

import scala.util.Try

object AtomicScala6DesignByContract {

  def main(args: Array[String]): Unit = {
    require(args(0).str == args(0), "Given parameter was not a string")
    val s = args(0).toLowerCase
    val sum = s.map(x => x.toInt).sum
    assume(sum > 0 && sum < (math.pow(26, (args(0).length+1))), "Character values too high for given string")
  }

  class ThreeMethods {
    def a(s: String) = {
      require(s.length >= 4 && s.length <= 10, "Precondition failed!")

      def add(acc: Int, s: String): Int = {
        if (s.isEmpty)
          acc
        else
          add(acc + s.head.toInt, s.tail)
      }

      add(0, s)

    }

    def b(s: String) = {
      def add(acc: Int, s: String): Int = {
        if (s.isEmpty)
          acc
        else
          add(acc + s.head.toInt, s.tail)
      }

      val i = add(0, s)
      assume(i > 0 && i < 100, "PostCondition failed!")
    }

    def c(s: String) = {
      require(s.length >= 4 && s.length <= 10, "Precondition failed!")

      def add(acc: Int, s: String): Int = {
        if (s.isEmpty)
          acc
        else
          add(acc + s.head.toInt, s.tail)
      }

      val i = add(0, s)
      assume(i > 0 && i < 100, "PostCondition failed!")
    }

    class failClass {
      def fail(i: Int) = {
        require(i > 0 && i < 100, "Input is outside bounds")
        println(i * 5 * 5)
        assume(i % 25 == 0, "Cannot be divided by 25")
      }
    }

  }
}
