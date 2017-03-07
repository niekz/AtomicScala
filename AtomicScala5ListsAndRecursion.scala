/**
  * Created by johann on 2017/03/07.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5ListsAndRecursion {
  def main(args: Array[String]): Unit = {
    rPrint("Recursion")
    println()
    sumIt(List(10, 20, 30, 40, 50)) is 150

    List(10, 20, 30, 40, 50).sum is 150
    Vector(10, 20, 30, 40, 50).sum is 150
    Seq(10, 20, 30, 40, 50).sum is 150
    Set(10, 20, 30, 40, 50, 50, 50).sum is 150
    (10 to 50 by 10).sum is 150

    val aList = List(10, 20, 45, 15, 30)
    max(aList) is 45

    sumItRecursive(List(1, 2, 3)) is 6
    sumItRecursive(List(45, 45, 45, 60)) is 195

    val animalList = List("cat", "dog",
      "cat", "bird", "cat", "cat", "kitten", "mouse")
    calcFreq(animalList, "cat", 0) is 4
    calcFreq(animalList, "dog", 0) is 1

  }

  def rPrint(s: Seq[Char]): Unit = {
    print(s.head)
    if(s.tail.nonEmpty)
      rPrint(s.tail)
  }

  def sumIt(toSum: List[Int], sum: Int = 0): Int =
    if(toSum.isEmpty) {
      println("Its empty, so return the value now")
      sum
    }
    else {
      println(s"Call sumIt with : [${toSum.tail}] : [${toSum.head}]")
      sumIt(toSum.tail, sum + toSum.head)
    }

  def max(l: List[Int]): Int = {
    def getMax(l: List[Int], maxElem: Int): Int = {
      if(l.tail.nonEmpty)
        if(l.head >= maxElem)
          getMax(l.tail, l.head)
        else
          getMax(l.tail, maxElem)
      else
        maxElem
    }
    getMax(l, 0)
  }

  def sumItRecursive(l: List[Int]): Int = {
    def loop(l: List[Int], acc: Int): Int = {
      if(l.tail.nonEmpty)
        loop(l.tail, acc + l.head)
      else
        acc + l.head
    }
    loop(l, 0)
  }

  def sumIt(n: Int*): Int = n.reduce(_ + _)

  def calcFreq(animalList: List[String], toSearch: String, i: Int): Int = {
    if(animalList.nonEmpty)
      if(animalList.head == toSearch)
        calcFreq(animalList.tail, toSearch, i+1)
      else
        calcFreq(animalList.tail, toSearch, i)
    else
      i
  }

}
