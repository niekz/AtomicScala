/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary2ClassesAndObjects {
  def main(args: Array[String]): Unit = {
    // Exercises on page 77 to follow :
    val a = getSquare(3)
    val expectedA = 9
    assert(a == expectedA, "Failed to obtain square. Expected : " + expectedA + ". Got : " + a + " instead.")
    println("3 squared is : " + a)
    val b = getSquare(6)
    val expectedB = 36
    assert(b == expectedB, "Failed to obtain square. Expected : " + expectedB + ". Got : " + b + " instead.")
    println("6 squared is : " + b)
    val c = getSquare(5)
    val expectedC = 25
    assert(c == expectedC, "Failed to obtain square. Expected : " + expectedC + ". Got : " + c + " instead.")
    println("5 squared is : " + c)

    val sd1 = getSquareDouble(1.2)
    val expectedD = 1.44
    assert(sd1 == expectedD, "Failed to obtain square. Expected : " + expectedD + ". Got : " + sd1 + " instead.")
    println("1.44 squared is : " + sd1)
    val sd2 = getSquareDouble(5.7)
    val expectedE = 32.49
    assert(sd2 == expectedE, "Failed to obtain square. Expected : " + expectedE + ". Got : " + sd2 + " instead.")
    println("5.7 squared is : " + sd2)

    val t1 = isArg1GreaterThanArg2(4.1, 4.12)
    //assert(t1, "Arg1 is not greater than Arg2")
    println("4.1 is greater than 4.12")
    val t2 = isArg1GreaterThanArg2(2.1, 1.2)
    assert(t2, "Arg1 is not greater than Arg2")
    println("2.1 is greater than 1.2")

    val g1 = getMe("abraCaDabra")
    assert(g1 == "abracadabra", "Expected : abracadabra. Got : " + g1)
    println(g1)
    val g2 = getMe("zyxwVUT")
    assert(g2 == "zyxwvut", "Expected : zyxwvut. Got : " + g2)
    println(g2)

    val s1 = addStrings("abc", "def")
    assert(s1 == "abcdef", "Expected : abcdef - Got : " + s1)
    println(s1)
    val s2 = addStrings("zyx", "abc")
    assert(s2 == "zyxabc", "Expected : zyxabc - Got : " + s2)
    println(s2)

    val m1 = manyTimesString("abc", 3)
    assert("abcabcabc" == m1, "Expected : abcabcabc. Got : " + m1)
    println(m1)
    val m2 = manyTimesString("123", 2)
    assert("123123" == m2, "Expected : 123123. Got : " + m2)
    println(m2)

    val normal = bmiStatus(160, 68)
    assert(normal.equalsIgnoreCase("Normal Weight"), "Expected : Normal Weight. Got : " + normal)
    println(normal)
    val overweight = bmiStatus(180, 60)
    assert(overweight.equalsIgnoreCase("Overweight"), "Expected : Overweight. Got : " + overweight)
    println(overweight)
    val underweight = bmiStatus(100, 68)
    assert(underweight.equalsIgnoreCase("Underweight"), "Expected : Underweight. Got : " + underweight)
    println(underweight)
  }
  def getSquare(n: Int): Int = {
    n * n
  }

  // Only return type and argument type differs. Can make a generic version
  def getSquareDouble(n: Double): Double = {
    n * n
  }

  def isArg1GreaterThanArg2(d1: Double, d2: Double): Boolean = {
    if(d1 > d2)
      true
    else
      false
  }

  def getMe(input: String): String = {
    input.toLowerCase
  }

  def addStrings(s1: String, s2: String): String = {
    s1 + s2
  }

  def manyTimesString(s: String, n: Int): String = {
    s*n
  }

  def bmiStatus(w: Double, h: Double): String = {
    val bmi = w / (h*h) * 703.07
    if(bmi < 18.5)
      "Underweight"
    else if(bmi < 25)
      "Normal Weight"
    else
      "Overweight"
  }
}
