/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3MapAndReduce {
  def main(args: Array[String]): Unit = {
    val v = Vector(1, 2, 3, 4)
    v.map(n => (n * 11) + 10) is Vector(21, 32, 43, 54)

    var vList:List[Int] = Nil
    for(n <- v){
      vList = (n*11)+10 :: vList
    }
    vList.reverse.toVector is Vector(21, 32, 43, 54)


    /*
    val v2 = Vector(1, 10, 100, 1000)
    var sum = 0
    v2.foreach(x => sum *= 11 + 10)
    sum is 1111
    */
    //v.reduce((sum, n) => sum + n) is 1111

    val v2 = Vector(1, 10, 100, 1000)
    var sum = 0
    for(n <- v2){
      sum = sum + n
    }
    sum is 1111

    def sumIt(n: Int*): Int = n.reduce(_ + _)
    sumIt(1, 2, 3) is 6
    sumIt(45, 45, 45, 60) is 195

  }
}
