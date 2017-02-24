/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1Values {
  def main(args: Array[String]): Unit = {
    val descriptiveValueName = 17
    //descriptiveValueName = 20 // Gives error : Reassignment to val
    val someString = "ABC1234"
    //someString = "DEF1234" // Gives error : Reassignment to val
    val someDouble = 15.56
    println(someDouble)
  }
}
