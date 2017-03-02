/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4DefiningOperators {
  def main(args: Array[String]): Unit = {
    var m1 = new Molecule
    var m2 = new Molecule
    m1.plus(m2)
    m1.+(m2)

    m1 plus m2
    m1 + m2

    val x = new Swearing
    println(x.#!>%)
    println(x #!>%)

    val someT1 = new SimpleTime(10, 30)
    val someT2 = new SimpleTime(9, 30)
    val someST = someT1-someT2
    someST.hours is 1
    someST.minutes is 0
    val someST2 = new SimpleTime(10, 30) - new SimpleTime(9, 45)
    someST2.hours is 0
    someST2.minutes is 45

    val a1 = new FancyNumber1(2)
    a1.power(3) is 8
    val b1 = new FancyNumber1(10)
    b1.power(2) is 100

    a1^3 is 8
    b1^2 is 100

    a1**3 is 8
    b1**2 is 100
  }

  class Molecule {
    var attached: Molecule = _
    def plus(other: Molecule) =
      attached = other
    def +(other: Molecule) =
      attached = other
  }

  class Swearing {
    def #!>% = "Rowzafrazaca!"
  }

  class SimpleTime(val hours: Int = 0, val minutes: Int){
    def -(time: SimpleTime): SimpleTime = {
      val minutesT1: Int = minutes + (hours*60)
      val minutesT2: Int = time.minutes + (time.hours*60)
      new SimpleTime((minutesT1-minutesT2)/60, (minutesT1-minutesT2)%60)
    }
  }

  class FancyNumber1(num: Int){
    def power(n: Int): Int = {
      math.pow(num.toDouble, n.toDouble).toInt
    }

    def ^(n: Int): Int = {
      power(n)
    }

    def **(n: Int): Int = {
      power(n)
    }
  }
}
