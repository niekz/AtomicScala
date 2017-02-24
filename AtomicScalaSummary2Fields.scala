/**
  * Created by johann on 2017/02/23.
  */
import com.atomicscala.AtomicTest._

object AtomicScalaSummary2Fields {
  def main(args: Array[String]): Unit = {
    val c1 = new Cup
    c1.percentFull = 50
    val c2 = new Cup
    c2.percentFull = 100
    c1.percentFull is 50
    c2.percentFull is 100

    val cup = new Cup2
    cup.add(50) is 50
    cup.add(50) is 100

    // Test values
    val cup2 = new Cup2
    cup2.add(45) is 45
    cup2.add(-15) is 30
    cup2.add(-50) is -20
    // All test cases pass, no need to add code to add

    val cup3 = new Cup3
    cup3.add(45) is 45
    cup3.add(-55) is 0
    cup3.add(10) is 10
    cup3.add(-9) is 1
    cup3.add(-2) is 0

    cup3.percentFull = 56 //Can be set outside the class. Would have thought default function declarations are private like in java... guess not..
    cup3.percentFull is 56

    val cup4 = new Cup4
    cup4.set(56)
    cup4.get() is 56
  }

  class Cup {
    var percentFull = 0
  }

  class Cup2 {
    var percentFull = 0
    val max = 100

    def add(increase: Int): Int = {
      percentFull += increase
      if(percentFull > max){
        percentFull = max
      }
      percentFull
    }
  }

  class Cup3 {
    var percentFull = 0
    val max = 100

    def add(increase: Int): Int = {
      percentFull += increase
      if(percentFull > max){
        percentFull = max
      }
      if(percentFull < 0){
        percentFull = 0
      }
      percentFull
    }
  }

  class Cup4 {
    var percentFull = 0
    val max = 100

    def get(): Int = percentFull
    def set(percentFull: Int): Unit = this.percentFull = percentFull

    def add(increase: Int): Int = {
      percentFull += increase
      if(percentFull > max){
        percentFull = max
      }
      if(percentFull < 0){
        percentFull = 0
      }
      percentFull
    }
  }
}
