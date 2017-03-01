/**
  * Created by johann on 2017/03/01.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3Brevity {
  def main(args: Array[String]): Unit = {
    val v = Vector(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17)
    filterWithYield1(v) is Vector(1, 3, 5, 7)

    assignResult(true) is 42
    assignResult(false) is 47
  }
  def filterWithYield1(v: Vector[Int]): Vector[Int] = {
    for{
      n <- v
      if n < 10
      if n % 2 != 0
    } yield n
  }

  def assignResult(arg: Boolean): Int = {
    if(arg) 42 else 47
  }

  def assignResult2(arg: Boolean): Int =
    if(arg) 42 else 47

  def assignResult3(arg: Boolean) =
    if(arg) 42 else 47

  class Coffee(val shots: Int = 2,
               val decaf: Boolean = false,
               val caf: Int = 0,
               val milk: Boolean = false,
               val toGo: Boolean = false,
               val syrup: String = "") {
    var result = ""
    println(shots, decaf, milk, toGo, syrup)

    def getCup() =
      if (toGo)
        result += "ToGoCup "
      else
        result += "HereCup "

    def pourShots(): Unit = {
      var count = 0
      for (s <- 0 until caf)
        if (count < caf) {
          result += "decaf shot "
          count += 1
        }
        else {
          count = 0
          for (s <- 0 until caf)
            if (count < caf) {
              result += "shot "
              count += 1
            }
        }
    }

    def addMilk() =
      if (milk)
        result += "milk "

    def addSyrup(): Unit = {
      result += syrup

      getCup()
      pourShots()
      addMilk()
      addSyrup()
    }

  }


}
