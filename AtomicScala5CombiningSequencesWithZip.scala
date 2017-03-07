/**
  * Created by johann on 2017/03/07.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5CombiningSequencesWithZip {
  def main(args: Array[String]): Unit = {
    val left = Vector("a", "b", "c", "d")
    val right = Vector("q", "r", "s", "t")

    left.zip(right) is "Vector((a,q), (b,r), (c,s), (d,t))"

    left.zip(0 to 4) is "Vector((a,0), (b,1), (c,2), (d,3))"

    number("Howdy") is Vector((0, 'H'), (1, 'o'), (2, 'w'), (3, 'd'), (4, 'y'))

    case class Person(name: String, ID: Int)
    val names = Vector("Bob", "Jill", "Jim")
    val IDs = Vector(1731, 9274, 8378)

    names.zip(IDs).map {
      case (n, id) => Person(n, id)
    } is "Vector(Person(Bob,1731), Person(Jill,9274), Person(Jim,8378))"

    val people = List("Sally Smith",
      "Dan Jones", "Tom Brown", "Betsy Blanc",
      "Stormy Morgan", "Hal Goodsen")
    val group1 = people.slice(0, people.length/2)
    val group2 = people.slice(people.length/2, people.length)
    val pairs = group1.zip(group2)
      pairs is List(
        ("Sally Smith","Betsy Blanc"),
        ("Dan Jones","Stormy Morgan"),
        ("Tom Brown","Hal Goodsen"))


  }

  def number(s: String) = Range(0, s.length).zip(s)


}
