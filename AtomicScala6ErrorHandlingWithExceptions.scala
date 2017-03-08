/**
  * Created by johann on 2017/03/08.
  */

import com.atomicscala.AtomicTest._


object AtomicScala6ErrorHandlingWithExceptions {
  def main(args: Array[String]): Unit = {

    test(0)
    test(1) is "Except1 Reason"
    test(2) is "Except2 11"
    test(3) is "Except3 Wanted: 1.618"

    ExceptionMethod("Testing exceptions") is "Exception thrown: Testing exceptions"

    var x = new q2
    x = null

    try {
      x.f()
    } catch {
      case e: NullPointerException => println(s"Issue with reference, points to nothing : $e")
    }

    val someElements = Vector("This", "is", "a", "test", "Vector")

    try {
      someElements(6)
    } catch {
      case e: IndexOutOfBoundsException => println(s"Issue with index lookup : $e")
    }

    try{
      throw new myException("Testing")
    } catch {
      case e: myException => println(s"$e")
    }

    println(testSubExceptions())

    safeGaurd(true)
    safeGaurd(false)

    val a: Low = new High
    try {
      a.f
    }catch {
      case e: Exception => println(s"$e")
    }



  }

  class myException extends Exception {
    val e = Nil
    def this(arg: String) = {
      this
      val e = new Exception(arg)
      throwException()
    }

    def throwException(): String = {
      s"$e"
    }
  }

  case class sub1(s: String) extends Exception(s)
  case class sub2(s: String) extends Exception(s)
  case class sub3(s: String) extends Exception(s)

  //new q6

  class q6{
    f()
    def f(): Unit = {
      try{
        g()
      } catch {
        case e: Exception => throw new Exception("Other new exception")
      }
    }

    def g(): Unit = {
      throw new Exception("New exception")
    }
  }

  def testSubExceptions(): String = {
    try{
      throw new sub1("Testing1")
      throw new sub2("Testing2")
      throw new sub3("Testing3")
    } catch {
      case e: sub1 => s"$e"
      case e: sub2 => s"$e"
      case e: sub3 => s"$e"
    }
  }

  def test(which: Int) =
    try{
      toss(which)
    } catch {
      case Except1(why) => s"Except1 $why"
      case Except2(n) => s"Except2 $n"
      case Except3(msg, d) => s"Except3 $msg $d"
    }

  def ExceptionMethod(n: String): String = {
    try{
      throw Except1(n)
    } catch {
      case Except1(why) => s"Exception thrown: $why"
    }
  }

  case class Except1(why: String) extends Exception(why)

  case class Except2(n: Int) extends Exception(n.toString)

  case class Except3(msg: String, d: Double) extends Exception(s"$msg $d")

  object toss {
    def apply(which: Int) =
      which match {
        case 1 => throw Except1("Reason")
        case 2 => throw Except2(11)
        case 3 => throw Except3("Wanted:", 1.618)
        case _ => "OK"
      }
  }

  class q2 {
    def f(): Unit = {}
  }

  class baseq7{ throw new Exception("Base class exception")}
  class testingq7 extends baseq7 {
    try{
      this
    } catch {
      case e: Exception => println(s"Caught : $e")
    }
  }

  //new testingq7

  class FailingConstructor(fail: Boolean = false) {
    var result = "Uninitialized"
    if(fail)
      throw new IllegalStateException
    else
      result = "Success"
  }

  def safeGaurd(fail: Boolean) = try{
    println(new FailingConstructor(fail).result)
  } catch {
    case e: IllegalStateException => println(s"Fail: $e")
  }

  class exceptionLow(s: String) extends Exception(s)
  class exceptionMid(s2: String) extends exceptionLow(s2)
  class exceptionHigh(s3: String) extends exceptionMid(s3)

  class Low{
    def f() { throw new exceptionLow("Base exception") }
  }

  class Mid extends Low {
    override def f() { throw new exceptionMid("Mid exception") }
  }

  class High extends Mid {
    override def f() { throw new exceptionHigh("High level exception") }
  }



}
