/**
  * Created by johann on 2017/03/07.
  */

//import AtomicScala5TypeParameterConstraints.Bounciness._
//import AtomicScala5TypeParameterConstraints.Flexibility._
import com.atomicscala.AtomicTest._


object AtomicScala5TypeParameterConstraints {
  def main(args: Array[String]): Unit = {
    import AtomicScala5TypeParameterConstraints.Bounciness._
    import AtomicScala5TypeParameterConstraints.Flexibility._

    //case class BouncingBall(res: Resilience) extends Spring[Bounciness]
    //BouncingBall(level2) is "BouncingBall(level2)"

    case class FlexingWall(res: Flexibility) extends Spring[Flexibility]

    FlexingWall(type3) is "FlexingWall(type3)"

    new CallF(new WithF).g(2) is 22

    new CallF(new WithF {
      override def f(n: Int) = n * 7
    }).g(2) is 14
  }

  trait Resilience

  object Bounciness extends Enumeration {
    case class _Val() extends Val
      with Resilience
    type Bounciness = _Val
    val level1, level2, level3 = _Val()
  }

  object Flexibility extends Enumeration {
    case class _Val() extends Val
      with Resilience
    type Flexibility = _Val
    val type1, type2, type3 = _Val()
  }

  trait Spring[R <: Resilience] {
    val res: R
  }

  class WithF {
    def f(n: Int) = n * 11
  }

  class CallF[T <: WithF](t: T) {
    def g(n: Int) = t.f(n)
  }

  def CallF[T <: WithF](n: Int, t: T) = {
    t.f(n)
  }

  trait Building
  trait Room
  trait Storage
  trait Sink
  trait Storable
  trait Cleanable
  trait Store[T <: Storable]
  trait Cook[T]
  trait Clean[T <: Cleanable]
  trait Food extends Store[Food] with Storable
    with Clean[Food] with Cleanable
    with Cook[Food]
  trait Utensils extends Store[Utensils] with Storable
    with Clean[Utensils] with Cleanable
    with Cook[Utensils]

  trait Kitchen extends Room {
    val storage: Storage
    val sinks: Vector[Sink]
    val food: Food
    val utensils: Utensils
  }

  trait House extends Building {
    val kitchens: Vector[Kitchen]
  }

  object EnumUtensils extends Enumeration {
    case class _Val() extends Val
      with Utensils
    type EnumUtensils = _Val
    val utensils1, utensils2, utensils3 = _Val()
  }

  object EnumFood extends Enumeration {
    case class _Val() extends Val
      with Utensils
    type EnumFood = _Val
    val food1, food2, food3 = _Val()
  }



}
