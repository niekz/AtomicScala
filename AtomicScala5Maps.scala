/**
  * Created by johann on 2017/03/07.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5Maps {
  def main(args: Array[String]): Unit = {
    val constants = Map("Pi" -> 3.141,
      "e" -> 2.718, "phi" -> 1.618)
    Map(("Pi", 3.141), ("e", 2.718),
      ("phi", 1.618)) is constants

    Vector(("Pi", 3.141), ("e", 2.718), ("phi", 1.618)).toMap is constants

    constants("e") is 2.718

    constants.keys is "Set(Pi, e, phi)"

    constants.values is "MapLike(3.141, 2.718, 1.618)"

    (for(pair <- constants)
      yield pair.toString) is "List((Pi,3.141), (e,2.718), (phi,1.618))"

    (for((k, v) <- constants)
      yield k + ": " + v) is "List(Pi: 3.141, e: 2.718, phi: 1.618)"

    Vector((3.141, "Pi"), (2.718, "e"), (1.618, "phi")).toMap

    case class Name(firstName: String, lastName: String)

    val m = Map("sally@taylor.com"
      -> Name("Sally","Taylor"))
    m("sally@taylor.com") is
      Name("Sally", "Taylor")

    val m2 = m ++ Map("jiminy@cricket.com" -> Name("Jiminy", "Cricket"))
    m2("jiminy@cricket.com") is Name("Jiminy", "Cricket")

    m2("sally@taylor.com") is
      Name("Sally", "Taylor")

    val set3 = Set[String]("English", "French", "Spanish", "German", "Chinese") -- Set[String]("Spanish")
    set3.size is 4
    val map3 = Map("sally@taylor.com" -> Name("Sally", "Taylor"), "mary@smith.com" -> Name("Mary", "Smith"), "jiminy@cricket.com" -> Name("Jiminy", "Cricket")).-("jiminy@cricket.com")
    map3.size is 2
  }


}
