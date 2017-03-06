/**
  * Created by johann on 2017/03/06.
  */
import java.util

import com.atomicscala.AtomicTest._

object AtomicScala4Applications {
  def main(args: Array[String]): Unit = {

  }

  object WhenAmI extends App {
    hi
    println(new java.util.Date())
    def hi = println("Hello! It's:")
  }

  object EchoArgs extends App{
    for(arg <- args)
      println(arg)
  }

  object EchoArgs2{
    def main(args: Array[String]) =
      for(arg <- args)
        println(arg)
  }

  //class Battery extends BatteryPower

  class Battery extends BatteryPower
  object Battery extends App
    with BatteryPower{
    def init(args: Array[String]): Unit = {
      for(arg <- args)
        println(this.monitor(arg.toInt))
    }
  }


  trait BatteryPower {
    def monitor(i: Int): String = {
      i match {
        case n: Int if(n < 20) => "red"
        case n: Int if(n >= 20 && n < 40) => "yellow"
        case n: Int if(n >= 40) => "green"
      }
    }
  }
}

