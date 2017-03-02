/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4CompanionObjects {
  def main(args: Array[String]) = {
    val x1 = new X(1)
    val x2 = new X(2)

    x1.f is 10
    x2.f is 20

    X.n is 2
    X.f is 20
    X.g is 40
  }

  class X(val n: Int) {
    def f = this.n * 10
  }

  object X{
    val n = 2
    def f = n * 10
    def g = this.n * 20
  }
}
