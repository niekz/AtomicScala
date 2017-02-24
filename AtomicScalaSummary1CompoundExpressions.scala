/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1CompoundExpressions {
  def main(args: Array[String]): Unit = {
    val a = 1
    val b = 3
    val c = 5

    if (a <= c && b <= c)
      println("both are!")
    else
      println("one is and one isn't!")
    /* old version
    if(a <= c)
      println("a is less than c")
    else
      println("a is not less than c")

    if(b <= c)
      println("b is less than c")
    else
      println("b is not less than c")
    */
    val temperature = 65
    val goodTemperatureForSwimming = {
      val lowTemp = 60
      val highTemp = 80
      if (temperature > lowTemp && temperature < highTemp) {
        true
      } else
        false
    }
    val goodTemperatureForWalking = {
      val lowTemp = 40
      val highTemp = 60
      if (temperature > lowTemp && temperature < highTemp) {
        true
      } else
        false
    }
    val goodTemperatureForBiking = {
      val lowTemp = 40
      val highTemp = 60
      if (temperature > lowTemp && temperature < highTemp) {
        true
      } else
        false
    }
    val goodTemperatureForCouch = {
      val lowTemp = 80
      val highTemp = 100
      if (temperature > lowTemp && temperature < highTemp) {
        true
      } else
        false
    }
    val activity = "swimming"
    val swimming = "swimming"
    val walking = "walking"
    val biking = "biking"
    val couch = "couch"
    val hour = 4
    val isOpen = {
      if (activity == "swimming" ||
        activity == "ice skating") {
        val opens = 9
        val closes = 20
        println("Operating hours: " +
          opens + " - " + closes)
        if (hour >= opens && hour <= closes) {
          true
        } else {
          false
        }
      } else if (activity == "walking") {
        val opens = 6
        val closes = 20
        if (hour >= opens && hour <= closes) {
          true
        } else
          false
      } else if (activity == "biking") {
        val opens = 4
        val closes = 10
        if (hour >= opens && hour <= closes) {
          true
        } else
          false
      } else {
        true
      }
    }

    println(isOpen)
    val doActivitySwimming = isOpen && goodTemperatureForSwimming
    val doActivityWalking = isOpen && goodTemperatureForWalking
    val doActivityBiking = isOpen && goodTemperatureForBiking
    val doActivityCouch = isOpen && goodTemperatureForCouch
    println(swimming + ":" + isOpen + " && " +
      goodTemperatureForSwimming + " = " + doActivitySwimming)
    println(walking + ":" + isOpen + " && " +
      goodTemperatureForWalking + " = " + doActivityWalking)
    println(biking + ":" + isOpen + " && " +
      goodTemperatureForBiking + " = " + doActivityBiking)
    println(couch + ":" + isOpen + " && " +
      goodTemperatureForCouch + " = " + doActivityCouch)

    //
    var distance = 5
    var activity2 = "running"
    val willDo = {
      if (distance < 20 && activity2 == "biking")
        true
      else if (distance < 6 && distance > 1 && activity2 == "running")
        true
      else if (distance < 1 && activity2 == "swimming")
        true
      else
        false
    }
    println("running: " + willDo)
    activity2 = "walking"
    val willDo2 = {
      if (distance < 20 && activity2 == "biking")
        true
      else if (distance < 6 && distance > 1 && activity2 == "running")
        true
      else if (distance < 1 && activity2 == "swimming")
        true
      else
        false
    }
    println("walking: " + willDo2)
    distance = 14
    activity2 = "biking"
    println("biking: " + willDo)
  }
}
