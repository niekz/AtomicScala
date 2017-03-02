/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4AutomaticStringConversion {
  def main(args: Array[String]): Unit  ={
    val forTwo = Bicycle(2)
    forTwo is "Bicycle built for 2" // Nice ?

    val fancy = new Surrey("fringe on top")
    println(fancy)

    val fancy2 = new Surrey2("fringe on top")
    fancy2 is "Surrey with the fringe on top"

    val c1 = Cycle(1)
    val c2 = Cycle(2)
    val c3 = Cycle(5)
    c1 is "Unicycle"
    c2 is "Bicycle"
    c3 is "Cycle with 5 wheels"
    Cycle(-2) is "That's not a cycle!"
  }

  case class Bicycle(riders: Int){
    override def toString = s"Bicycle built for $riders"
  }

  case class Cycle(wheels: Int){
    override def toString = {
      wheels match {
        case i: Int if(i == 1) => "Unicycle"
        case i: Int if(i == 2) => "Bicycle"
        case i: Int if(i == 3) => "Tricycle"
        case i: Int if(i == 4) => "Quadricycle"
        case i: Int if(i > 4) => s"Cycle with $i wheels"
        case i: Int if(i < 0) => "That's not a cycle!"
      }
    }
  }

  class Surrey(val adornment: String)


  class Surrey2(val adornment: String){
    override def toString = s"Surrey with the $adornment"
  }


}
