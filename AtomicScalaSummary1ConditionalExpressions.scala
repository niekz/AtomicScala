/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1ConditionalExpressions {
  def main(args: Array[String]): Unit = {
    val a = 1
    val b = 5

    if (a < b)
      println("a is less than b")
    else
      println("a is not less than b")

    if (a > 2)
      println("a is greater than 2")
    else
      println("a is not greater than 2")

    if (b > 2)
      println("b is greater than 2")
    else
      println("b is not greater than 2")

    val c = 5
    if (a < c)
      println("a is less than c")
    else
      println("a is not less than c")

    if (b < c)
      println("b is less than c")
    else
      println("b is not less than c")
  }
}
