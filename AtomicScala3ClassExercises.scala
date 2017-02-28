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

    val anotherT1 = new SimpleTimeDefault(10, 30)
    val anotherT2 = new SimpleTimeDefault(9)
    val anotherST = anotherT1.subtract(anotherT2)

    anotherST.hours is 1
    anotherST.minutes is 30

    val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
    anotherST2.hours is 0
    anotherST2.minutes is 15

    val auxT1 = new SimpleTimeAux(10, 5)
    val auxT2 = new SimpleTimeAux(6)
    val auxST = auxT1.subtract(auxT2)

    auxST.hours is 4
    auxST.minutes is 5
    val auxST2 = new SimpleTimeAux(12).subtract(new SimpleTimeAux(9, 45))
    auxST2.hours is 2
    auxST2.minutes is 15


  }

  class Dimension(var height: Int, var width: Int)

  class Info(var name: String, var description: String)   //name was a val in q2, and changed to a var in q3

  class SimpleTime(val hours: Int = 0, val minutes: Int){
    def subtract(time: SimpleTime): SimpleTime = {
      if(this.minutes - time.minutes > 0)
        new SimpleTime(minutes = this.minutes - time.minutes, hours = this.hours - time.hours)
      else
        new SimpleTime(minutes = 60 + this.minutes - time.minutes, hours = this.hours - time.hours)
    }
  }

  class SimpleTimeDefault(val hours: Int = 0, val minutes: Int = 0){
    def subtract(time: SimpleTimeDefault): SimpleTimeDefault = {
      if(this.minutes - time.minutes > 0)
        new SimpleTimeDefault(minutes = this.minutes - time.minutes, hours = this.hours - time.hours)
      else
        new SimpleTimeDefault(minutes = 60 + this.minutes - time.minutes, hours = this.hours - time.hours)
    }
  }

  class SimpleTimeAux(val hours: Int, val minutes: Int = 0){
    def this(hours: Int) {
      this(hours, 0)
    }

    def subtract(time: SimpleTimeAux): SimpleTimeAux = {
      if(this.minutes - time.minutes > -1)
        new SimpleTimeAux(minutes = this.minutes - time.minutes, hours = this.hours - time.hours)
      else
        new SimpleTimeAux(minutes = 60 + this.minutes - time.minutes, hours = this.hours - time.hours)
    }
  }



}
