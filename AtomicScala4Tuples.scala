/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4Tuples {
  def main(args: Array[String]): Unit = {
    data(7.0) is ReturnBlob(14.0, "High")
    data(4.0) is ReturnBlob(8.0, "Low")

    data2(7.0) is (14.0, "High")
    data2(4.0) is (8.0, "Low")

    data3(7.0) is (14.0, "High", true)
    data3(4.0) is (8.0, "Low", false)

    def f = (1, 3.14, "Mouse", false, "Altitude")

    val (n, d, a, b, h) = f

    (a, b, n, d, h) is ("Mouse", false, 1, 3.14, "Altitude")

    val all = f
    f._1 is 1
    f._2 is 3.14
    f._3 is "Mouse"
    f._4 is false
    f._5 is "Altitude"

    val empA = Employee("Bob", 1130)
    val Employee(nm, id) = empA

    nm is "Bob"
    id is 1130

    val tuple1 = (65, "Sunny", "Stars")
    val (temp1, sky1, view1) = tuple1

    temp1 is 65
    sky1 is "Sunny"
    view1 is "Stars"

    val tuple2 = (78, "Cloudy", "Satellites")
    val (temp2, ski2, view2) = tuple2

    temp2 is 78
    ski2 is "Cloudy"
    view2 is "Satellites"

    val tuple3 = (51, "Blue", "Night")
    val (temp3, ski3, view3) = tuple3

    temp3 is 51
    ski3 is "Blue"
    view3 is "Night"

    val info = (50, 45)
    info._1 is 50
    info._2 is 45

    weather(81, 45) is ("Hot", "Humid")
    weather(50, 45) is ("Temperate", "Humid")

    val (heat1, moisture1) = weather(81, 45)
    heat1 is "Hot"
    moisture1 is "Humid"
    val (heat2, moisture2) = weather(27, 55)
    heat2 is "Cold"
    moisture2 is "Damp"


  }

  case class ReturnBlob(data: Double, info: String)

  def data(input: Double) =
    if(input > 5.0)
      ReturnBlob(input * 2, "High")
    else
      ReturnBlob(input * 2, "Low")

  def data2(input: Double): (Double, String) = {
    if(input > 5.0)
      (input * 2, "High")
    else
      (input * 2, "Low")
  }

  def data3(input: Double) =
    if(input > 5.0)
      (input * 2, "High", true)
    else
      (input * 2, "Low", false)

  case class Employee(name: String, ID: Int)

  def weather(temperature: Int, humidity: Int): (String, String) = {
    (temperature, humidity) match {
      case (t: Int, h: Int) if(t > 80 && h > 40) => ("Hot", "Humid")
      case (t: Int, h: Int) if(t > 80) => ("Hot", "Pleasant")
      case (t: Int, h: Int) if(t < 50) => ("Cold", "Damp")
      case (t: Int, h: Int) if(t >= 50 && t <= 80 && h > 40) => ("Temperate", "Humid")
      case (t: Int, h: Int) if(t >= 50 && t <= 80) => ("Temperate", "Pleasant")
    }
  }

}
