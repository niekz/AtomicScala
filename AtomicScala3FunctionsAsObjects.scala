/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3FunctionsAsObjects {
  def main(args: Array[String]): Unit = {
    val v = Vector(1, 2, 3, 4)
    v.foreach(show)
    v.foreach((n: Int) => println("> " + n))

    //n: Int => println("> " + n)

    val duck = "Duck".toVector
    duck.foreach((n: Char) => println("> " + n))

    var s = ""
    val duck2 = "Duck".toVector
    duck2.foreach((n: Char) => s = s + n + ":")
    s is "D:u:c:k:"

    val v2 = Vector(19, 1, 7, 3, 2, 14)
    v2.sorted is Vector(1, 2, 3, 7, 14, 19)
    v2.sortWith((i, j) => j < i) is Vector(19, 14, 7, 3, 2, 1)

    var s2 = ""
    val str = "1234".toVector
    str.foreach((n: Char) => s2 += n + ",")

    s2 is "1,2,3,4,"

    val dogYears = (n: Int) => n * 7
    dogYears(10) is 70

    var dogString = ""
    val dogVector = Vector(1, 5, 7, 8)
    dogVector.foreach((n: Int) => dogString += n * 7 + " ")

    dogString is "7 35 49 56 "

    def temp = (temp: Int, low: Int, high: Int) => if(temp > low && temp < high) true else false
    temp(70, 80, 90) is false
    temp(70, 60, 90) is true

    var numberString = ""
    val numbers = Vector(1, 2, 5, 3, 7)
    numbers.foreach((n: Int) => numberString += n*n + " ")
    numberString is "1 4 25 9 49 "

    def pluralize = (word: String) => word + "s"
    pluralize("cat") is "cats"
    pluralize("dog") is "dogs"
    pluralize("silly") is "sillys"

    var wordsString = ""
    val words = Vector("word", "cat", "animal")
    words.foreach((word: String) => wordsString += pluralize(word) + " ")
    wordsString is "words cats animals "


  }

  def show(n: Int): Unit = {
    println("> " + n)
  }



}
