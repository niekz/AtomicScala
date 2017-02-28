/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3StringInterpolation {
  def main(args: Array[String]): Unit = {
    i("Hi", 11, 3.14) is "first: Hi, second: 11, third: 3.14"

    def f(n: Int): Int = { n * 11 }

    s"f(7) is ${f(7)}!" is "f(7) is 77!"

    case class Sky(color: String)

    s"""${Sky("Blue")}""" is "Sky(Blue)"

    val gnome = new GardenGnome(20.0, 110.0, false)
    gnome.show() is "height: 20.0 weight: 110.0 happy: false painted: true"
    val bob = new GardenGnome("Bob")
    bob.show() is "height: 15.0 weight: 100.0 happy: true painted: true"


  }

  def i(s: String, n: Int, d: Double): String = {
    s"first: $s, second: $n, third: $d"
  }



  class GardenGnome(val height: Double, val weight: Double, val happy: Boolean){
    //println("Inside primary constructor")
    var painted = true
    def magic(level: Int): String = {
      s"Poof! $level"
      //"Poof! " + level
    }
    def this(height: Double){
      this(height, 100.0, true)
    }
    def this(name: String){
      this(15.0)
      painted is true
    }
    def show(): String = {
      s"height: $height weight: $weight happy: $happy painted: $painted"
      //height + " " + weight + " " + happy + " " + painted
    }

    def show(level: Int): String = {
      s"${magic(level)} $happy $painted"
    }
  }
}
