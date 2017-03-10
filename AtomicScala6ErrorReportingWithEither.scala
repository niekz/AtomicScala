/**
  * Created by johann on 2017/03/10.
  */

import java.io.FileNotFoundException

import AtomicScala6ErrorHandlingWithExceptions._
import codelisting._
import com.atomicscala.AtomicTest._
import AtomicScala6ErrorReportingWithEither.CodeListingEither


object AtomicScala6ErrorReportingWithEither {
  class CodeListingEither {
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

  }

  def f(i: Int) =
    if(i == 0)
      Left("Divide by Zero")
    else
      Right(24/i)

  def test(n: Int) =
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

  def listing(name: String) = {
    CodeListingEither(name) match {

    }


  }
}
