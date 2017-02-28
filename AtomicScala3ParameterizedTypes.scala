/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3ParameterizedTypes {
  def main(args: Array[String]): Unit = {
    val v1 = Vector(1, 2, 3)
    val v2 = Vector("one", "two", "three")

    val p1:Vector[Int] = Vector(1, 2, 3)
    val p2:Vector[String] = Vector("one", "two", "three")

    v1 is p1
    v2 is p2
  }
}
