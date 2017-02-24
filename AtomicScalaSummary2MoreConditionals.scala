/**
  * Created by johann on 2017/02/23.
  */

import com.atomicscala.AtomicTest._

object AtomicScalaSummary2MoreConditionals {
  def main(args: Array[String]): Unit = {
    val b = 1
    trueOrFalse(b < 3) is "It's true!"
    trueOrFalse(b > 3) is "It's false"

    val v = Vector(1)
    val v2 = Vector(3, 4)
    oneOrTheOther(v == v.reverse) is "True!"
    oneOrTheOther(v2 == v2.reverse) is "It's false"

    println(isPalidrome("This is not a palidrome"))
    println(isPalidrome("Abba"))

    isPalidrome("mom") is true
    isPalidrome("dad") is true
    isPalidrome("street") is false

    isPalIgnoreSpecial("This123321sihT") is true

  }

  def trueOrFalse(exp: Boolean): String = {
    if(exp)
      return "It's true!"
    "It's false"
  }

  def oneOrTheOther(exp: Boolean): String = {
    if(exp)
      "True!"
    else
      "It's false"
  }

  def isPalidrome(s: String): Boolean = {
    s.equals(s.reverse)
  }

  def isPalIgnoreCase(s: String): Boolean = {
    s.equalsIgnoreCase(s.reverse)
  }

  def isPalIgnoreSpecial(s: String): Boolean = {
    var createdStr = ""
    for (c <- s){
      val theValue = c.toInt
      if((theValue > 64 && theValue < 92) || (theValue > 96 || theValue < 123))
        createdStr += c
      else if(theValue > 47 && theValue < 58)
        createdStr += c
    }
    isPalIgnoreCase(createdStr)
  }

  def checkTruth(exp1:Boolean, exp2:Boolean):String = {
    if(exp1 && exp2) {
      "Both are true"
    }
    else if(!exp1 && !exp2) {
      "Both are false"
    }
    else if(exp1) {
      "First: true, second: false"
    }
    else {
      "First: false, second: true"
    }
  }
}
