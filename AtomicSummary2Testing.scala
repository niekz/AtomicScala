/**
  * Created by johann on 2017/02/23.
  */

import com.atomicscala.AtomicTest._

object AtomicSummary2Testing {
  def main(args: Array[String]): Unit = {

    //TODO: Uncomment block when done with question 5
    /*
    val myValue1 = 20
    val myValue2 = 10

    myValue1 is myValue2 //Fails

    val myValue3 = 10
    val myValue4 = 10

    myValue3 is myValue4 //Succeeds

    myValue2 is myValue3 //Succeeds

    val myValue5 = "10"

    myValue5 is myValue2 //Fails
    */
    squareArea(1) is 1
    squareArea(2) is 4
    squareArea(5) is 25
    rectangleArea(2, 2) is 4
    rectangleArea(5, 4) is 20
    trapezoidArea(2, 2, 4) is 8
    trapezoidArea(3, 4, 1) is 3.5

  }

  def squareArea(x: Int): Int =
    x * x

  def rectangleArea(x: Int, y: Int): Int =
    x * y //Fixed x * x to be x * y

  def trapezoidArea(x: Int, y: Int, h: Int): Double =
    h * (x + y)/2.0 //Changed formula, as well as added .0 for integer math exclusion

  def quadrangle(a: Int, b: Int, c: Int, d: Int, t1: Int, t2: Int): Double = {
    val s = (a+b+c+d)/2.0
    math.sqrt((s-a)*(s-b)*(s-c)*(s-d)-(a*b*c*d*math.pow(2, math.cos((t1+t2)/2.0))))
  }

}
