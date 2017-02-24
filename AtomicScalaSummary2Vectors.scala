/**
  * Created by johann on 2017/02/23.
  */

import com.atomicscala.AtomicTest._

object AtomicScalaSummary2Vectors {
  def main(args: Array[String]): Unit = {
    val words = Vector("The", "dog", "visited", "the", "firehouse")

    words is Vector("The", "dog", "visited", "the", "firehouse")
    for(i <- words)
      println(i)

    var sentence = ""
    for(i <- words)
      sentence += i + " "
    sentence is "The dog visited the firehouse "

    sentence = sentence.replace("firehouse ", "firehouse!")
    sentence is "The dog visited the firehouse!"

    for(i <- words)
      println(i.reverse)

    for(i <- words.reverse)
      println(i)

    val x = Vector(1,2,3,4,5)
    val y = Vector(1.0, 2.0, 3.0, 4.0, 5.0)

    println(x.sum)
    println(y.sum)
    println(x.min)
    println(y.min)
    println(x.max)
    println(y.max)

    val stringVector = Vector("This", "is", "a", "test", "string")
    //println(stringVector.sum) //addition is not defined on a the reference type string
    println(stringVector.min)
    println(stringVector.max)

    val z = Range(0, 10).inclusive.sum
    println(z)

    val listTest = List("This", "is", "a", "test", "list")
    val setTest = Set("Sets", "do", "not", "contain", "duplicate", "duplicate", "values")
    println(listTest)
    println(setTest)
    println(listTest.reverse)
    //println(setTest.reverse) //Can't reverse. Sets are unordered
    println(listTest.sorted)
    //println(setTest.sorted) //Can't Sort. Sets are unordered, and therefor can't be sorted.

    val myVector1 = Vector(1,2,3,4,5,6)
    val myVector2 = Vector(1,2,3,4,5,6)

    myVector1 is myVector2 // They are equivalent. This was expected.

  }
}
