/**
  * Created by johann on 2017/03/06.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4UniformAccessAndSetters {
  def main(args: Array[String]): Unit = {
    val d = new Derived
    d.d3 is 1
    d.d3 = 42
    d.d3 is 42

  }

  trait Base {
    def f1: Int
    def f2: Int
    val d1: Int
    val d2: Int
    var d3: Int
    var n = 1
  }

  class Derived extends Base {
    def f1 = 1
    val f2 = 1
    val d1 = 1
    val d2 = 1
    def d3 = n
    def d3_= (newVal: Int) = n = newVal
  }




}
