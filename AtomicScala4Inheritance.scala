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
  }

  class GreatApe{
    val weight = 100.0
    val age = 12
  }

  class Bonobo extends GreatApe
  class Chimpanzee extends GreatApe
  class BonoboB extends Bonobo

  def display(ape: GreatApe) =
    s"weight: ${ape.weight} age: ${ape.age}"


}
