/**
  * Created by johann on 2017/02/21.
  */
object AtomicScala1 {
  def main(args: Array[String]): Unit = {
    /*
    val whole = 11
    val fractional = 1.4
    val words = "A value"

    println(whole, fractional, words)
  */

    // Exercises on page 46 to follow :
    val descriptiveValueName = 17
    //descriptiveValueName = 20 // Gives error : Reassignment to val
    val someString = "ABC1234"
    //someString = "DEF1234" // Gives error : Reassignment to val
    val someDouble = 15.56
    println(someDouble)

    // Exercises on page 50 to follow :
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

    // Exercises on page 52 to follow :
    val someNumber = 5
    // someNumber = 10 // Gives error : Reassignment to val
    var v1 = 5
    v1 = 10
    val constantv1 = v1
    v1 = 15
    println(constantv1)
    // value didn't change. So when assigned, the value is copied in memory, not referenced
    var v2 = v1
    v1 = 20
    println(v2) // suspicion confirmed as before, value is copied over, not referenced.

    // Exercises on page 55 to follow :
    val miles = {
      val feetPerMile = 5280
      val yardsPerMile = feetPerMile / 3.0
      val milesForSwimming2000yards = 2000 / yardsPerMile
      milesForSwimming2000yards
    }
    println(miles)

    // Exercises on page 58 to follow :
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

    // Exercises on page 62 to follow :
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

    // Exercises on page 66 to follow :
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

    // Exercises on page 72 to follow :
    val thisIsANum: Int = 50
    println(thisIsANum)

    //thisIsANum = 5 // Reassignment to a val (error)


  }
}
