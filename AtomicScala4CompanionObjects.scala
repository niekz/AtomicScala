/**
  * Created by johann on 2017/03/02.
  */

import com.atomicscala.AtomicTest._

object AtomicScala4CompanionObjects {
  def main(args: Array[String]) = {
    val x1 = new X(1)
    val x2 = new X(2)

    x1.f is 10
    x2.f is 20

    X.n is 2
    X.f is 20
    X.g is 40

    WalkActivity.start("TestName")

    val sally = new WalkActivity
    sally.calories(150, 30) is 82

    val suzie = new WalkActivity
    val john = new WalkActivity

    suzie.calories2(150, 30) is 117
    john.calories2(150, 30, 1.5) is 82


  }

  class X(val n: Int) {
    def f = this.n * 10
  }

  object X{
    val n = 2
    def f = n * 10
    def g = this.n * 20
  }

  class WalkActivity{
    var MET = 2.3

    def calories(lbs: Int, mins: Int, mph: Double = 3): Long = math.round(
      (MET * 3.5 * lbs * 0.45)/200.0 * mins
    )

    def calories2(lbs: Int, mins: Int, mph: Double = 3): Long = math.round(
      (MET(mph) * 3.5 * lbs * 0.45)/200.0 * mins
    )
    def MET(mph: Double) =
      mph match {
        case x: Double if(x < 1.7) => 2.3
        case x: Double if(x < 2.5) => 2.9
        case x: Double if(x < 3) => 3.3
        case x: Double if(x >= 3) => 3.3
        case _ => 2.3
      }
  }

  object WalkActivity{
    var log = ""

    def start(name: String): Unit = {
      log += s"[$name] Activity started."
    }
    def stop(name: String): Unit = {
      log += s"[$name] Activity stopped."
    }
  }
}
