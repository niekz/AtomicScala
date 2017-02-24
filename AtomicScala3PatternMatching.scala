/**
  * Created by johann on 2017/02/24.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3PatternMatching {
  def main(args: Array[String]): Unit = {
    matchColor("white") is "UNKNOWN COLOR: white"
    matchColor("blue") is "BLUE"

    matchColorIf("white") is "UNKNOWN COLOR: white"
    matchColorIf("blue") is "BLUE"

    val v = Vector(1)
    val v2 = Vector(3, 4)

    oneOrTheOther(v == v.reverse) is "True!"
    oneOrTheOther(v2 == v2.reverse) is "It's false"
  }

  def matchColor(color: String): String = {
    color match {
      case "red" => "RED"
      case "blue" => "BLUE"
      case "green" => "GREEN"
      case _ => "UNKNOWN COLOR: " + color
    }
  }

  def matchColorIf(color: String): String = {
    if(color == "red")
      "RED"
    else if(color == "blue")
      "BLUE"
    else if(color == "green")
      "GREEN"
    else
      "UNKNOWN COLOR: " + color
  }

  def oneOrTheOther(exp: Boolean): String = {
    exp match {
      case true => "True!"
      case _ => "It's false"
    }
  }




}
