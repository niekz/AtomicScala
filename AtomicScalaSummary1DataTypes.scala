/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1DataTypes {
  def main(args: Array[String]): Unit = {
    val n: Int = 5
    val someString2: String = "ABC1234"
    val someDouble2: Double = 5.4
    val someBoolean = true // Don't need to spesify type, will infer it as boolean.
    println(someBoolean)
    val multiLineString =
      """This is a multi
        |line
        |string
      """.stripMargin
    println(multiLineString)
    // Prints in multiple lines.
    // val stringBoolean: Boolean = "maybe" // Gives error : Does not conform the the boolean type required
    // val doubleInt: Int = 15.4 // Gives error : Does not conform the the int type required
    val intDouble: Double = 15 // Does not give error. I guess ints are a subtype of doubles?
    println(intDouble) // Prints it as 15.0, so it casted the integer to a double when it was assigned
  }
}
