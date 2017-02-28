/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3ParameterizedTypes {
  def main(args: Array[String]): Unit = {
    val v1 = Vector(1, 2, 3)
    val v2 = Vector("one", "two", "three")

    val p1:Vector[Int] = Vector(1, 2, 3)
    val p2:Vector[String] = Vector("one", "two", "three")

    v1 is p1
    v2 is p2

    explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)

    explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
    explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)

    explicitSet(Vector(10.0, 20.0)) is Set(10.0, 20.0)
    explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)

    val weather = Vector(100, 80, 20, 100, 20)
    historicalData(weather) is "Sunny=2, Mostly Sunny=1, Partly Sunny=0, Mostly Cloudy=2, Cloudy=0"


  }

  def inferred(c1: Char, c2: Char, c3: Char) = {
    Vector(c1, c2, c3)
  }

  def explicit(c1: Char, c2: Char, c3: Char): Vector[Char] = {
    Vector(c1, c2, c3)
  }

  def explicitDouble(c1: Double, c2: Double, c3: Double): Vector[Double] = {
    Vector(c1, c2, c3)
  }

  def explicitList(c: Vector[Double]): List[Double] = {
    var list: List[Double] = Nil
    for(s <- c)
      list = s :: list
    list
  }

  def explicitSet(c: Vector[Double]): Set[Double] = {
    var set: Set[Double] = Set.empty
    for(s <- c)
      set += s
    set
  }

  def forecast(n: Int): String = {
    n match {
      case 100 => "Sunny"
      case 80 => "Mostly Sunny"
      case 50 => "Partly Sunny"
      case 20 => "Mostly Cloudy"
      case 0 => "Cloudy"
      case _ => "Unknown"
    }
  }

  def historicalData(data: Vector[Int]): String = {
    var sunny = 0
    var mostlySunny = 0
    var partlySunny = 0
    var mostlyCloudy = 0
    var cloudy = 0

    for(s <- data){
      s match {
        case 100 => sunny += 1
        case 80 => mostlySunny += 1
        case 50 => partlySunny += 1
        case 20 => mostlyCloudy += 1
        case 0 => cloudy += 1
      }
    }
    s"Sunny=$sunny, Mostly Sunny=$mostlySunny, Partly Sunny=$partlySunny, Mostly Cloudy=$mostlyCloudy, Cloudy=$cloudy"
  }


  inferred('a', 'b', 'c') is "Vector(a, b, c)"
  explicit('a', 'b', 'c') is "Vector(a, b, c)"


}
