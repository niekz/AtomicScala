/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1EvaluationOrder {
  def main(args: Array[String]): Unit = {
    val sky = "Sunny"
    val temp = 80
    val hotAndSunny = (sky == "Sunny") && (temp > 80)
    val sunnyOrPartlyCloudyAndHot = (sky == "Sunny" || sky == "Partly Cloudy") && (temp > 80)
    val sunnyOrPartlyCloudyAndHotOrCold = (sky == "Sunny" || sky == "Partly Cloudy") && (temp > 80 || temp < 20)
    val farenheit = 86
    val celcius = 30
    val fToC = ((farenheit - 32) * (5.0 / 9.0))
    println(fToC)
    val cToF = (celcius * (9.0 / 5.0) + 32)
    println(cToF)
  }
}
