/**
  * Created by johann on 2017/02/28.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3Comprehensions {
  def main(args: Array[String]): Unit = {
    val v = Vector(1,2,3,5,6,7,8,10,13,14,17)
    val l = v.toList
    evenGT5(v) is Vector(6, 8, 10, 14)
    yielding(v) is Vector(1, 3, 5, 7)
    yielding2(l) is List(1, 3, 5, 7)
    yielding3(v) is Vector(12, 32, 52, 72)
    yielding4(v) is Vector(Vector(0), Vector(0, 1, 2), Vector(0, 1, 2, 3, 4), Vector(0, 1, 2, 3, 4, 5, 6))

    val activities = Vector(
      Activity("01-01", "Run"),
      Activity("01-03", "Ski"),
      Activity("01-04", "Run"),
      Activity("01-10", "Ski"),
      Activity("01-03", "Run"))
    getDates("Ski", activities) is Vector("01-03", "01-10")
    getDates("Run", activities) is Vector("01-01", "01-04", "01-03")
    getDates("Bike", activities) is Vector()

    getActivities("01-01", activities) is Vector("Run")
    getActivities("01-02", activities) is Vector()
    getActivities("01-03", activities) is Vector("Ski", "Run")
    getActivities("01-04", activities) is Vector("Run")
    getActivities("01-10", activities) is Vector("Ski")
  }

  case class Activity(date: String, activity: String)

  def getDates(activity: String, activities: Vector[Activity]): Vector[String] = {
    for{
      n <- activities
      if n.activity == activity
    } yield n.date
  }

  def getActivities(date: String, activities: Vector[Activity]): Vector[String] = {
    for{
      n <- activities
      if n.date == date
    } yield n.activity
  }

  def evenGT5(v: Vector[Int]): Vector[Int] = {
    var result = Vector[Int]()
    for {
      n <- v
      if n > 5
      if n % 2 == 0
    } result = result :+ n
    result
  }

  def yielding(v: Vector[Int]): Vector[Int] = {
    val result = for {
      n <- v
      if n < 10
      if n % 2 != 0
    } yield n
    result
  }

  def yielding2(v: List[Int]): List[Int] = {
    for {
      n <- v
      if n < 10
      isOdd = (n % 2 != 0)
      if(isOdd)
    } yield n
  }

  def yielding3(v: Vector[Int]): Vector[Int] = {
    for{
      n: Int <- v
      if n < 10
      isOdd = (n % 2 != 0)
      if(isOdd)
    } yield {
      val u = n * 10
      u + 2
    }
  }

  def yielding4(v: Vector[Int]) = {
    for{
      n <- v
      if n < 10
      isOdd = (n % 2 != 0)
      if(isOdd)
    } yield {
      for(u <- Range(0, n))
        yield u
    }
  }






}
