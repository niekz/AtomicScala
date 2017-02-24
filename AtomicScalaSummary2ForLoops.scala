/**
  * Created by johann on 2017/02/23.
  */

import com.atomicscala.AtomicTest._

object AtomicScalaSummary2ForLoops {
  def main(args: Array[String]): Unit = {
    var result = ""
    for(i <- 0 to 9){
      result += i + " "
    }
    result is "0 1 2 3 4 5 6 7 8 9 "

    result = ""
    for(i <- 0 until 10){
      result += i + " "
    }
    result is "0 1 2 3 4 5 6 7 8 9 "

    result = ""
    for(i <- Range(0, 10)){
      result += i + " "
    }
    result is "0 1 2 3 4 5 6 7 8 9 "

    result = ""
    for(i <- Range(0, 20, 2)){
      result += i + " "
    }
    result is "0 2 4 6 8 10 12 14 16 18 "

    var sum = 0
    for(i <- Range(0, 20, 2)){
      println("Adding " + i + " to " + sum)
      sum += i
    }
    sum is 90

    val r1 = Range(0, 10)
    r1 is Range(0, 10)

    val r2 = Range(0, 9).inclusive
    r2 is Range(0, 9).inclusive

    var total = 0
    for(i <- Range(0, 10).inclusive){
      total += i
    }
    total is 55

    var totalEvens = 0
    for(i <- Range(0, 10).inclusive){
      if(i%2 == 0)
        totalEvens += i
    }
    totalEvens is 30

    var odds = 0
    var evens = 0
    for(i <- Range(0, 10).inclusive){
      if(i%2 == 0)
        evens += i
      else
        odds += i
    }
    evens is 30
    odds is 25
    (evens + odds) is 55

    var odds2 = 0
    var evens2 = 0
    for(i <- 1 until 11){
      if(i%2 == 0)
        evens2 += i
      else
        odds2 += i
    }
    evens2 is 30
    odds2 is 25
    (evens2 + odds2) is 55
  }
}
