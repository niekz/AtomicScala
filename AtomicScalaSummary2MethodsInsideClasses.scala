/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary2MethodsInsideClasses {
  def main(args: Array[String]): Unit = {
    val sailboat = new Sailboat
    val r1 = sailboat.raise
    assert(r1 == "Sails raised", "Expected Sails raised. Got : " + r1)
    println(r1)
    val r2 = sailboat.lower()
    assert(r2 == "Sails lowered", "Exoected sails lowered. Got : " + r2)
    val motorboat = new Motorboat()
    val sss1 = motorboat.signal()
    assert(sss1 == "Motor on", "Expected Motor on. Got : " + sss1)
    println(sss1)
    val sss2 = motorboat.signal()
    assert(sss2 == "Motor off", "Expected Motor off. Got " + sss2)

    val flare = new Flare
    val f1 = flare.light()
    assert(f1 == "Flare user!", "Expected Flare used!. Got : " + f1)
    println(f1)

    val sailboat2 = new Sailboat()
    val signal = sailboat.signal()
    assert(signal == "Flare used!", "Expected Flare used! Got : " + signal)
    val motorboat2 = new Motorboat()
    val flare2 = motorboat2.signal()
    assert(flare2 == "Flare used!", "Expected Flare used! Got : " + flare2)

  }
  class Sailboat{
    def raise(): String =
      "Sails raised"
    def lower(): String =
      "Sails lowered"
    def signal(): String =
      "Firefly"
  }

  class Motorboat{
    def on(): String =
      "Motor on"
    def off(): String =
      "Motor off"
    def signal(): String = {
      val firefly = new Flare()
      firefly.light
    }
  }

  class Flare{
    def light(): String =
      "Flare used!"
  }
}
