/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1 {
  def main(args: Array[String]): Unit = {
    val x = 5
    //x = 8 //Error : Reassignment to a val (Vals can't change)

    var y:Int = 9
    //y = 10.0 //Typing error - Not the correct type

    val z:Double = 10.0

    val z1:Double = 15 //Works. The integer value is casted to a double

    val multiLineString =
      """
        |This
        |Is
        |a
        |multi
        |line
        |string
      """.stripMargin
    println(multiLineString)

    //val maybe:Boolean = "maybe" //Typing error - Not the correct type

    //val z2: Int = 15.4 //Typing error - Not the correct type

  }
  def getBmi(weight: Double, height: Double): Unit ={
    val bmi = weight / (height*height) * 703.07
    if(bmi < 18.5)
      println("Underweight")
    else if(bmi < 25)
      println("Normal Weight")
    else
      println("Overweight")
  }

  def getIdealWeight(height: Double): Double = {
    22.0 * (height * height) / 703.07
  }
}
