/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3FunctionsAsObjects {
  def main(args: Array[String]): Unit = {
    val v = Vector(1, 2, 3, 4)
    v.foreach(show)
    v.foreach((n: Int) => println("> " + n))

    //n: Int => println("> " + n)

    val duck = "Duck".toVector
    duck.foreach((n: Char) => println("> " + n))

    var s = ""
    val duck2 = "Duck".toVector
    duck2.foreach((n: Char) => s = s + n + ":")
    s is "D:u:c:k:"

    val v2 = Vector(19, 1, 7, 3, 2, 14)
    v2.sorted is Vector(1, 2, 3, 7, 14, 19)
    v2.sortWith((i, j) => j < i) is Vector(19, 14, 7, 3, 2, 1)



  }

  def show(n: Int): Unit = {
    println("> " + n)
  }



}
