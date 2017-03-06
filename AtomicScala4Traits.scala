/**
  * Created by johann on 2017/03/06.
  */
import com.atomicscala.AtomicTest._

object AtomicScala4Traits {

  trait Color
  trait Texture
  trait Hardness

  class Fabric

  class Cloth extends Fabric
    with Color
    with Texture
    with Hardness

  class Paint extends Color
    with Texture
    with Hardness

  trait AllAbstract {
    def f(n: Int): Int
    val d: Double
  }

  trait PartialAbstract{
    def f(n: Int): Int
    val d: Double
    def g(s: String) = s"($s)"
    val j = 42
  }

  trait Concrete {
    def f(n: Int) = n * 11
    val d = 1.61803
  }

  abstract class Klass1 extends AllAbstract
    with PartialAbstract

  class Klass2 extends AllAbstract {
    def f(n: Int) = n * 12
    val d = 3.14159
  }

  class Klass3 extends AllAbstract
    with Concrete

  class Klass4 extends PartialAbstract
    with Concrete

  class Klass5 extends AllAbstract
    with PartialAbstract
    with Concrete

  trait FromAbstract extends Klass1
  trait FromConcrete extends Klass2

  trait Construction{
    println("Constructor body")
  }

  class Constructable extends Construction

  trait Base {
    def f = "f"
  }

  trait Derived1 extends Base {
    def g = "17"
  }

  trait Derived2 extends Derived1 {
    def h = "1.11"
  }

  class Derived3 extends Derived2

  trait A {
    def f = 1.1
    def g = "A.g"
    def n = 7
  }

  trait B {
    def f = 7.7
    def g = "B.g"
    def n = 17
  }

  object C extends A
    with B{
    override def f = 9.9
    override val n = 27
    override def g = super[A].g + super[B].g
  }

  trait Framework {
    val part1: Int
    def part2: Double
    def templateMethod = part1 + part2
  }

  def operation(impl: Framework) = impl.templateMethod

  class Implementation extends Framework {
    val part1 = 42
    val part2 = 2.71828
  }

  class EnergySource

  trait BatteryPower {
    val charge: Int
  }

  def main(args: Array[String]): Unit  ={
    // new Klass1 // Can't do this. d and f are undefined
    new Klass2
    new Klass3
    new Klass4
    new Klass5

    new Constructable

    val x = new AllAbstract with PartialAbstract with Concrete

    val d = new Derived3
    d.f
    d.g
    d.h

    C.f is 9.9
    C.g is "A.gB.g"
    C.n is 27

    operation(new Implementation) is 44.71828
  }
}
