/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3ClassExercises {
  def main(args: Array[String]): Unit = {
    val c = new Dimension(5, 7)
    c.height is 5
    c.height = 10
    c.height is 10
    c.width = 19
    c.width is 19
  }

  class Dimension(var height: Int, var width: Int)
}
