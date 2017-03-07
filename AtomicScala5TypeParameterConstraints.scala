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

    case class BouncingBall(res: Resilience) extends Spring[Bounciness]
    BouncingBall(level2) is "BouncingBall(level2)"

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
}
