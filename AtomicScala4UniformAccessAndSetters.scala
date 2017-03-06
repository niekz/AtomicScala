/**
  * Created by johann on 2017/03/06.
  */

import AtomicScala4Traits.Base
import com.atomicscala.AtomicTest._

object AtomicScala4UniformAccessAndSetters {
  def main(args: Array[String]): Unit = {
    val d = new Derived
    d.d3 is 1
    d.d3 = 42
    d.d3 is 42

  }

  abstract trait Base {
    def f1: Int
    def f2: Int
    val d1: Int
    val d2: Int
    var d3: Int
    var n = 1
  }
/*
  trait ConcreteBase{
    def f1 = 1
    val f2 = 1
    val d1 = 1
    val d2 = 1
    def d3 =
    def d3_= (newVal: Int) =  = newVal
  }
*/
  class Derived extends Base {
    def f1 = 1
    val f2 = 1
    val d1 = 1
    val d2 = 1
    def d3 = n
    def d3_= (newVal: Int) = n = newVal
  }

  class Derived2 extends Base {
    def f1 = 1
    val f2 = 1
    val d1 = 1
    val d2 = 1
    def d3 = n
    def d3_= (newVal: Int) = n = newVal

    var internal: Int = 5

    def x = internal
    def x_= (newVal: Int) = internal = newVal
  }




}
