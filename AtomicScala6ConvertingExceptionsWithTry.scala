/**
  * Created by johann on 2017/03/13.
  */
import java.io.FileNotFoundException

import AtomicScala6ErrorHandlingWithExceptions.{Except1, Except2, Except3, toss}
import codelisting.{CodeListing, CodeListingTester, ExtensionException}
import com.atomicscala.AtomicTest._

import util.{Failure, Success, Try}

object AtomicScala6ConvertingExceptionsWithTry {
  def main(args: Array[String]) : Unit = {
    f(0).get is "OK Bob"
    f(1).get is "Reason"
    f(2).get is "11"
    f(3).get is "1.618"

    new CodeListingTester(listing)
  }

  def f(n: Int) = Try(toss(n)).transform(
    i => Success(s"$i Bob"),
    e => e match {
      case Except1(why) => Success(why)
      case Except2(n) => Success(n)
      case Except3(msg, d) => Success(d)
    }
  )

  def listing(name: String) = {
    Try(new CodeListing(name)).recover{
      case _: FileNotFoundException => Vector(s"File not nound: $name")
      case _: NullPointerException => Vector("Error: Null file name")
      case e: ExtensionException => Vector(e.getMessage)
    }.get
  }



}
