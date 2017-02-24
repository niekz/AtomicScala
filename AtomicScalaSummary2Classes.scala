/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary2Classes {

  def main(args: Array[String]): Unit = {
    val hippo = new Hippo()
    val lion = new Lion()
    val tiger = new Tiger()
    val monkey = new Monkey()
    val giraffe = new Giraffe()
    val lion2 = new Lion()
    val giraffe2 = new Giraffe()
    val giraffe3 = new Giraffe()

    val test = new Zebra()
  }
  class Hippo{
    println("This is a hippo")
  }

  class Lion{
    println("This is a Lion")
  }

  class Tiger{
    println("This is a Tiger")
  }

  class Monkey{
    println("This is a Monkey")
  }

  class Giraffe{
    println("This is a giraffe")
  }

  class Zebra{
    println("I have stripes!.")
  }
}
