/**
  * Created by johann on 2017/03/07.
  */
import com.atomicscala.AtomicTest._

object AtomicScala5Sequences {
  def main(args: Array[String]): Unit = {
    class Person(val first:String, val last:String) {
      override def toString = s"$first $last"
    }
    /*
    val p = Person("John", "Smith", "john@smith.com")
    p.fullName is "John Smith"
    p.first is "John"
    p.email is "john@smith.com"
  */
    //val people = Vector(new Person("John", "Snow", "johnsnow@got.com"), new Person("John", "Wane", "johnwane@awesomemovies.com"), new Person("William", "Shakespeak", "willy@lovershut.com"))
    //people.size is 3
/*
    val people = Vector(
      Person("Zach","Smith","zach@smith.com"),
      Person("Mary", "Add", "mary@add.com"),
      Person("Sally", "Taylor",
        "sally@taylor.com"))
    val sorted = people.sortBy(_.last)
      sorted is "Vector(" +
        "Person(Mary,Add,mary@add.com)," +
        " Person(Zach,Smith,zach@smith.com)," +
        " Person(Sally,Taylor,sally@taylor.com))"
        */


    class Friend(first: String, last: String, val email: String) extends Person(first: String, last: String) with Contact

    trait Contact {
      val email: String
    }

    val friends = Vector(
      new Friend(
        "Zach", "Smith", "zach@smith.com"),
      new Friend(
        "Mary", "Add", "mary@add.com"),
      new Friend(
        "Sally","Taylor","sally@taylor.com"))
    val sorted = friends.sortBy(_.email)
      sorted is "Vector(Mary Add, Sally Taylor, Zach Smith)"

    val friends2 = Vector(
      new Friend(
        "Zach", "Smith", "zach@smith.com"),
      new Friend(
        "Mary", "Add", "mary@add.com"),
      new Friend(
        "Sally","Taylor","sally@taylor.com"),
      new Friend(
        "Mary", "Smith", "mary@smith.com"))
    val s1 = friends2.sortBy(_.first)
    val s2 = s1.sortBy(_.last)
      s2 is "Vector(Mary Add, Mary Smith, Zach Smith, Sally Taylor)"
  }

  def testSeq(s: Seq[Int]) = {
    s.isEmpty is false
    s.length is 5

    // Append at end
    s :+ 99 is Seq(1, 7, 22, 11, 17, 99)
    // Prepend at start
    47 +: s is Seq(47, 1, 7, 22, 11, 17)

    // First item
    s.head is 1
    // All but first item
    s.tail is Seq(7, 22, 11, 17)
    // Last item
    s.last is 17
    // drops 3 items and returns rest
    s.drop(3) is Seq(11, 17)
    // drops 3 items from the right and returns rest
    s.dropRight(3) is Seq(1, 7)
    // takes 3 items from the left
    s.take(3) is Seq(1, 7, 22)
    // takes 3 items from the right
    s.takeRight(3) is Seq(1, 7, 22)
    // slices from 2 to 5 (returns all items from 2 to 5
    s.slice(2, 5) is Seq(22, 11, 17)

    // third value
    s(3) is 11
    // contains 22
    s.contains(22) is true
    // where is 22
    s.indexOf(22) is 2
    // updates 3rd item with 16
    s.updated(3, 16) is Seq(1, 7, 22, 16, 17)
    // remove index 3
    s.patch(3, Nil, 1) is Seq(1, 7, 22, 17)

    // new sequence from previous
    val seq2 = s ++ Seq(99, 88)
    seq2 is Seq(1, 7, 22, 11, 17, 99, 88)
    // distinct values, sorted
    s.distinct.sorted is Seq(1, 7, 11, 17, 22)
    // reverse
    s.reverse is Seq(17, 11, 22, 7, 1)
    // intersection of two sequences
    s.intersect(seq2) is Seq(1, 7, 22, 11, 17)
    // min value
    s.min is 1
    // max value
    s.max is 22

    // if it starts with 1, 7
    s.startsWith(Seq(1, 7)) is true
    // if it ends with 11, 17
    s.endsWith(Seq(11, 17)) is true

    // sum of elements is 58
    s.sum is 58

    // product of elements is 28798
    s.product is 28798

    //set of sequence is :
    s.toSet is Set(1, 17, 22, 7, 11)



  }

}
