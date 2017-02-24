/**
  * Created by johann on 2017/02/23.
  */
object AtomicScalaSummary1Variables {
  def main(args: Array[String]): Unit = {
    val someNumber = 5
    // someNumber = 10 // Gives error : Reassignment to val
    var v1 = 5
    v1 = 10
    val constantv1 = v1
    v1 = 15
    println(constantv1)
    // value didn't change. So when assigned, the value is copied in memory, not referenced
    var v2 = v1
    v1 = 20
    println(v2) // suspicion confirmed as before, value is copied over, not referenced.
  }
}
