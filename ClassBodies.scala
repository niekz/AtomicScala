/**
  * Created by johann on 2017/02/23.
  */
package mine.scala.bodies

class ClassBodies {
  class NoBody
  val nb = new NoBody

  class SomeBody {
    val name = "Janet Doe"
    //println(name + " is SomeBody")
    def getName(): String = {
      name
    }
  }
  val sb = new SomeBody

  class EveryBody {
    val all = Vector(new SomeBody, new SomeBody, new SomeBody)
    def getAll(): Vector[SomeBody] = {
      all
    }
  }
  val eb = new EveryBody
}
