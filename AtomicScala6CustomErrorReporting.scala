/**
  * Created by johann on 2017/03/13.
  */

import java.io.FileNotFoundException

import codelisting.{CodeListing, ExtensionException}
import com.atomicscala.AtomicTest._

import scala.util.{Failure, Success, Try}
import scala.util.control.NoStackTrace

object AtomicScala6CustomErrorReporting {
  def main(args: Array[String]): Unit = {
    test(47) is (47, "OK")
    test(1) is "No good: 1"
    test(2) is "No good: 2"
    test(3) is "No good: 3"

    try{
      throw new FailMsg("Caught in a try block")
    } catch {
      case e: FailMsg => println(e.msg)
    }

    //throw new FailMsg("Uncaught")
    println("Beyond uncaught")

    f(-1) is "Failure(Negative value: -1)"
    f(7) is "Success(7)"
    f(11) is "Failure(Value too large: 11)"

    calc(10, "11", 7) is  "Success(147)"
    calc(15, "11", 7) is "Failure(Value too large: 15)"
    calc(10, "dog", 7) is """Failure(java.lang.NumberFormatException: For input string: "dog")"""
    calc(10, "11", -1) is "Failure(Negative value: -1)"

    def listing(name: String) = {
      try {
        Success(new CodeListing(name))
      } catch {
        case _: FileNotFoundException => Fail(s"File Not Found: $name")
        case _: NullPointerException => Fail(s"Null file name")
        case e: ExtensionException => Fail(e.getMessage)
      }
    }

    def testListing(name: String) = {
      listing(name).recover{
        case e => Vector(e.toString)
      }.get
    }
    var count: Int = 1
    for(i <- testListing("/home/johann/IdeaProjects/AtomicScala/src/AtomicScala6CustomErrorReporting.scala")){
      println(count + "\t: " + i)
      count += 1
    }
  }

  def calc(a: Int, b: String, c: Int) = {
    for {
      x <- f(a)
      y <- Try(b.toInt)
      sum = x + y
      z <- f(c)
    } yield sum * z
  }

  sealed trait Result
  case class Good(x: Int, y: String) extends Result
  case class Bad(errMsg: String) extends Result

  def tossCustom(which: Int) = {
    which match {
      case 1 => Bad("No good: 1")
      case 2 => Bad("No good: 2")
      case 3 => Bad("No good: 3")
      case _ => Good(which, "OK")
    }
  }

  def test(n: Int) = {
    tossCustom(n) match {
      case Bad(errMsg) => errMsg
      case Good(x, y) => (x, y)
    }
  }

  class FailMsg(val msg: String) extends Throwable with NoStackTrace {
    override def toString = msg
  }

  object Fail {
    def apply(msg: String) = Failure(new FailMsg(msg))
  }

  def f(i: Int) = {
    if(i < 0)
      Fail(s"Negative value: $i")
    else if(i > 10)
      Fail(s"Value too large: $i")
    else
      Success(i)
  }


  class Cell {
    var entry = ' '
    def set(e:Char) = {
      if(entry==' ' && (e=='X' || e=='O')) {
        entry = e
        Success("Successful Move")
      } else
        Fail(s"Invalid move")
    }
  }

  class Grid {
    val cells = Vector(
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell)
    )
    def play(e:Char, x:Int, y:Int) = {
      if(x < 0 || x > 2 || y < 0 || y > 2)
        Fail(s"Invalid move")
      else
        cells(x)(y).set(e)
    }
  }










}
