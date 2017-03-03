/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4Inheritance {
  def main(args: Array[String]): Unit = {
    display(new GreatApe) is "weight: 100.0 age: 12"
    display(new Bonobo) is "weight: 100.0 age: 12"
    display(new Chimpanzee) is "weight: 100.0 age: 12"
    display(new BonoboB) is "weight: 100.0 age: 12"

    val ape1 = new GreatApe()
    val ape2 = new Bonobo()
    val ape3 = new Chimpanzee()

    ape1.vocalize() is "Grrr!"
    ape2.vocalize() is "Grrr!"
    ape3.vocalize() is "Grrr!"

    says(new GreatApe) is "says Grrr!"
    says(new Bonobo) is "says Grrr!"
    says(new Chimpanzee) is "says Grrr!"
    says(new BonoboB) is "says Grrr!"

    val c = new Cycle()
    c.ride() is "Riding"
    val b = new Bicycle()
    b.ride() is "Riding"
    b.wheels is 2



  }

  class GreatApe{
    val weight = 100.0
    val age = 12

    def vocalize(): String = {
      "Grrr!"
    }
  }

  def says(x: GreatApe): String = {
    "says Grrr!"
  }

  class Bonobo extends GreatApe
  class Chimpanzee extends GreatApe
  class BonoboB extends Bonobo

  def display(ape: GreatApe) =
    s"weight: ${ape.weight} age: ${ape.age}"

  class Cycle(val wheels: Int = 2){
    def ride(): String = {
      "Riding"
    }
  }

  class Bicycle extends Cycle {

  }

}
