/**
  * Created by johann on 2017/03/01.
  */
import com.atomicscala.AtomicTest._

object AtomicScala4ABitOfStyle {
  def main(args: Array[String]): Unit = {
    val simple = new Simple("Hi")
    simple.getA() is "Hi"
    simple.getA is "Hi"
    simple.getB is "Hi"
    // simple.getB() is "Hi" // Rejected

    val e  = new Exclaim("yes")
    e.noParens is "yes!"
    e.parens is "yes!"

    val e2 = new Exclaim("yes")
    e2.noParens is "yes!"
    e2.parens is "yes!"

    val e4 = new Exclaim4("yes")
    e4.noParens is "yes!"
    e4.noParens is "yes!"
    e4.count() is 2
  }

  class Simple(val s: String){
    def getA() = s
    def getB = s
  }

  class Exclaim(var s: String){
    def parens() = s + "!"
    def noParens = s + "!"
  }

  class Exclaim2(var s: String){
    def parens() = s + "!"
    val noParens = s + "!"
  }

  class Exclaim3(var s: String){
    def parens() = s + "!"
    def noParens = s + "!"
  }

  class Exclaim4(var s: String){
    var counter = 0
    def parens() = s + "!"; counter += 1
    def noParens = s + "!"; counter += 1
    def count() = counter
  }



}
