/**
  * Created by johann on 2017/03/10.
  */

import java.io.FileNotFoundException

import AtomicScala6ErrorHandlingWithExceptions._
import codelisting._
import com.atomicscala.AtomicTest._
//import AtomicScala6ErrorReportingWithEither.CodeListingEither


object AtomicScala6ErrorReportingWithEither {
  object CodeListingEither {
    def apply(name: String) = {
      try{
        Right(new CodeListing(name))
      } catch {
        case _: FileNotFoundException => Left(s"File Not Found: $name")
        case _: NullPointerException => Left("Error: Null file name")
        case e: ExtensionException => Left(e.getMessage)
      }
    }

  }

  def listing(name: String) = {
    CodeListingEither(name) match {
      case Right(lines) => lines
      case Left(error) => Vector(error)
    }
  }

  def main(args: Array[String]): Unit  = {
    test(4) is 6
    test(5) is 4
    test(6) is 4
    //test(0) is "Failed: Divide by Zero"
    test(24) is 1
    test(25) is 0

    test2(0) is "OK"
    test2(1) is "Except1 Reason"
    test2(2) is "Except2 11"
    test2(3) is "Except3 Wanted: 1.618"

    //new CodeListingEither(listing)

    val evens = Range(0, 10) map {
      case x if x % 2 == 0 => Right(x)
      case x => Left(x)
    }

    evens is Vector(Right(0), Left(1),
      Right(2), Left(3), Right(4), Left(5),
      Right(6), Left(7), Right(8), Left(9))

    evens map {
      case Right(x) => s"Even: $x"
      case Left(x) => s"Odd: $x"
    } is "Vector(Even: 0, Odd: 1, Even: 2, " +
      "Odd: 3, Even: 4, Odd: 5, Even: 6, " +
      "Odd: 7, Even: 8, Odd: 9)"

    val grid = new Grid
    grid.play('X', 1, 1) is Right("Successful Move")
    grid.play('X', 1, 1) is Left("Invalid Move")
    grid.play('O', 1, 3) is Left("Invalid Move")

    /*
    var letters: Vector[Either[String, String]] =
    for(i <- Range('a', 'z'+1)) {
      if(i == 97 || i == 101 || i == 105 || i == 111 || i == 117){
        Left(i)
      } else {
        Right(i)
      }
    }
    */

    def divideLetters(letters: Vector[Either[String, String]], lettersLeft: String): Vector[Either[String, String]] = {
      if(lettersLeft.isEmpty)
        letters
      else
        if(lettersLeft.head == 97 || lettersLeft.head == 101 || lettersLeft.head == 105 || lettersLeft.head == 111 || lettersLeft.head == 117)
          divideLetters(letters :+ Left((lettersLeft.head).toString), lettersLeft.tail)
        else
          divideLetters(letters :+ Right((lettersLeft.head).toString), lettersLeft.tail)
    }

    val stuff = "abcdefghijklmnopqrstuvwxyz"
    val letterz = divideLetters(Vector(), stuff)
    letterz is "Vector(Left(a), Right(b), " +
      "Right(c), Right(d), Left(e), Right(f), " +
      "Right(g), Right(h), Left(i), Right(j), " +
      "Right(k), Right(l), Right(m), Right(n), " +
      "Left(o), Right(p), Right(q), Right(r), " +
      "Right(s), Right(t), Left(u), Right(v), " +
      "Right(w), Right(x), Right(y), Right(z))"

    def testLetters(n:Int) = {
      letterz(n) match {
        case Left(letter) => s"Vowel: $letter"
        case Right(letter) => s"Consonant: $letter"
        case _ => "Unknown"
      }
    }

    testLetters(0) is "Vowel: a"
    testLetters(4) is "Vowel: e"
    testLetters(13) is "Consonant: n"
  }

  def f(i: Int): Either[String, Int]=
    if(i == 0)
      Left("Divide by Zero")
    else
      Right(24/i)

  def test(n: Int): Any =
    f(n) match {
      case Left(why) => s"Failed: $why"
      case Right(result) => result
    }

  def tossEither(which: Int) = {
    which match {
      case 1 => Left(Except1("Reason"))
      case 2 => Left(Except2(11))
      case 3 => Left(Except3("Wanted:", 1.618))
      case _ => Right("OK")
    }
  }

  def test2(n: Int) = {
    tossEither(n) match {
      case Left(err) => err match {
        case Except1(why) => s"Except1 $why"
        case Except2(n) => s"Except2 $n"
        case Except3(msg, d) => s"Except3 $msg $d"
      }
      case Right(x) => x
    }
  }

  // TicTacToe.scala

  class Cell {
    var entry = ' '
    def set(e:Char): Either[String, String] = {
      if(entry==' ' && (e=='X' || e=='O')) {
        entry = e
        Right("Successful Move")
      } else
        Left("Invalid Move")
    }
  }

  class Grid {
    val cells = Vector(
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell)
    )
    def play(e:Char, x:Int, y:Int):Either[String, String] = {
      if(x < 0 || x > 2 || y < 0 || y > 2)
        Left("Invalid Move")
      else
        cells(x)(y).set(e)
    }
  }





}
