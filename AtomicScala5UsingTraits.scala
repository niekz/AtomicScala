/**
  * Created by johann on 2017/03/07.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5UsingTraits {
  def main(args: Array[String]): Unit = {
    val bob = new Exerciser(44)
    bob.isAerobic(180) is true
    bob.isAerobic(80) is false
    bob.minAerobic is 88.0

    val webcam = new WIFICamera
    webcam.showImage is "Showing video"
    webcam.address is "192.168.0.200"
    webcam.reportStatus is "working"

    val c = new Object with Connections
    c.maxConnections is 5
    c.connect(true) is true
    c.connected is 1
    for (i <- 0 to 3)
      c.connect(true) is true
    c.connect(true) is false
    c.connect(false) is true
    c.connected is 4
    for (i <- 0 to 3)
      c.connect(false) is true
    c.connected is 0
    c.connect(false) is false

    val c2 = new WifiCamera with Connections
    c2.maxConnections is 5
    c2.connect(true) is true
    c2.connected is 1
    c2.connect(false) is true
    c2.connected is 0
    c2.connect(false) is false

    val period = new ArtPeriod {} // Not sure if this is right. :/
    period.show(1400) is "Renaissance"
    period.show(1650) is "Baroque"
    period.show(1279) is "Pre-Renaissance"

    val painting = new Painting(64, 80, "Starry", 111, 1889)
    painting.show is "Modern"
    painting.show(1889) is "Modern"
  }

  trait Aerobic {
    val age: Int

    def minAerobic =.5 * (220 - age)

    def isAerobic(heartRate: Int) =
      heartRate >= minAerobic
  }

  trait Activity {
    val action: String

    def go: String
  }

  class Person(val age: Int)

  class Exerciser(age: Int,
                  val action: String = "Running",
                  val go: String = "Run!") extends Person(age)
    with Activity
    with Aerobic

  trait WIFI {
    val reportStatus: String
    val address: String
  }

  class Camera {
    def showImage(): String = {
      "Showing video"
    }
  }

  class WIFICamera extends Camera with WIFI {
    override val address: String = "192.168.0.200"
    override val reportStatus: String = "working"
  }

  trait Connections {
    val maxConnections: Int = 5
    var connected: Int = 0

    def connect(action: Boolean): Boolean = {
      if (action)
        if (connected < maxConnections) {
          connected += 1
          true
        } else
          false
      else if (connected > 0) {
        connected -= 1
        true
      }
      else
        false
    }
  }

  class WifiCamera extends Camera with WIFI {
    override val address: String = "192.168.0.200"
    override val reportStatus: String = "working"
  }

  trait ArtPeriod {
    def show(year: Int): String = {
      year match {
        case i: Int if(year < 1300) => "Pre-Renaissance"
        case i: Int if(year >= 1300 && year < 1600) => "Renaissance"
        case i: Int if(year >= 1600 && year < 1700) => "Baroque"
        case i: Int if(year >= 1700 && year < 1789) => "Late Baroque"
        case i: Int if(year >= 1789 && year < 1880) => "Romanticism"
        case i: Int if(year >= 1881 && year < 1970) => "Modern"
        case i: Int if(year > 1970) => "Contemporary"
      }
    }
  }

  class Painting(x: Int, y: Int, name: String, z: Int, year: Int) extends ArtPeriod {
    def show(): String = {
      show(year)
    }
  }


}
