/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1Expressions {
  def main(args: Array[String]): Unit = {
    val miles = {
      val feetPerMile = 5280
      val yardsPerMile = feetPerMile / 3.0
      val milesForSwimming2000yards = 2000 / yardsPerMile
      milesForSwimming2000yards
    }
    println(miles)
  }
}
