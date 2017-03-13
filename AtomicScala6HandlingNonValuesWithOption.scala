/**
  * Created by johann on 2017/03/13.
  */

import com.atomicscala.AtomicTest._

object AtomicScala6HandlingNonValuesWithOption {
  def banded(input: Double) =
    if(input > 1.0 || input < 0.0)
      Left("Nothing")
    else
      Right(math.round(input * 100.0))

  def banded2(input: Double) =
    if(input > 1.0 || input < 0.0)
      None
    else
      Some(math.round(input * 100.0))

  def p(s: Option[String]) = s.foreach(println)


  def main(args: Array[String]): Unit = {
    banded(0.555) is Right(56)
    banded(-0.1) is Left("Nothing")
    banded(1.1) is Left("Nothing")

    banded2(0.555) is Some(56)
    banded2(-0.1) is None
    banded2(1.1) is None

    for(x <- banded2(0.1))
      x is 10

    val result = for{
      d <- Vector(-0.1, 0.1, 0.3, 0.9, 1.2)
      n <- banded2(d)
    } yield n
    result is Vector(10, 30, 90)

    p(Some("Hi"))
    p(Option("Hi"))
    p(None)

    def fx(s: Option[String]) = s.map(_ * 2)

    fx(Some("Hi")) is Some("HiHi")
    fx(None) is None

    Option(null) is None

    def f(i: Int): Option[Int]=
      if(i == 0)
        None
      else
        Some(24/i)

    def test(n: Int): Any =
      f(n) match {
        case None => s"Failed"
        case Some(result) => result
      }

    f(4) is Some(6)
    f(5) is Some(4)
    f(6) is Some(4)
    f(0) is None
    f(24) is Some(1)
    f(25) is Some(0)


    class Cell {
      var entry = ' '
      def set(e:Char): Option[String] = {
        if(entry==' ' && (e=='X' || e=='O')) {
          entry = e
          Some("Successful Move")
        } else
          None
      }
    }

    class Grid {
      val cells = Vector(
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell)
      )
      def play(e:Char, x:Int, y:Int): Option[String] = {
        if(x < 0 || x > 2 || y < 0 || y > 2)
          None
        else
          cells(x)(y).set(e)
      }
    }

    def alphanumeric(s: Any): Option[Any] = {
      s match {
        case s: Char if((s >= 97 && s < 123) || (s >= 65 && s < 91)) => Some(s)
        case i: Int => Some(i)
        case _ => None
      }
    }

    alphanumeric(0) is Some(0)
    alphanumeric('a') is Some('a')
    alphanumeric('m') is Some('m')
    alphanumeric('$') is None
    alphanumeric('Z') is Some('Z')


  }


}
