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

    val info = new Info("stuff", "Something")
    info.name is "stuff"
    info.description is "Something"
    info.description = "Something else"
    info.description is "Something else"

    val t1 = new SimpleTime(10, 30)
    val t2 = new SimpleTime(9, 30)
    val st = t1.subtract(t2)
    st.hours is 1
    st.minutes is 0
  }

  class Dimension(var height: Int, var width: Int)

  class Info(var name: String, var description: String)   //name was a val in q2, and changed to a var in q3

  class SimpleTime(val hours: Int = 0, val minutes: Int = 0){
    def subtract(time: SimpleTime): SimpleTime = {
      new SimpleTime(minutes = this.minutes - time.minutes, hours = this.hours - time.hours)
    }
  }

}
