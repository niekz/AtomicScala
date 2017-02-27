/**
  * Created by johann on 2017/02/27.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3Overloading {
  def main(args: Array[String]): Unit = {
    val mo1 = new Overloading1
    val mo2 = new Overloading2

    mo1.f() is 88
    mo1.f(11) is 13
    mo2.f() is 99
    mo2.f(11) is 14
  }

  class Overloading1 {
    def f(): Int = { 88 }
    def f(n: Int): Int = { n + 2 }
  }

  class Overloading2 {
    def f(): Int = { 99 }
    def f(n: Int): Int = { n + 3 }
  }

  class OverloadingExercises{
    def f(): Int = { 0 }
    def f(n: Int) = { n }
    def f(n: Int, m: Int) = { f(n) + f(m) }
    def f(n: Int, m: Int, o: Int) = { o + f(n, m)}
    def f(n: Int, m: Int, o: Int, p: Int) = { p + f(n, m, o) }
  }



}
