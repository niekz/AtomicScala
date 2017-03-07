/**
  * Created by johann on 2017/03/07.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5ReferencesAndMutability {
  def main(args: Array[String]): Unit = {
    var q1 = Map("Key" -> "Value")
    // q1 ++ asdasd // + is not defined and ++  returns a new map, leaves old map in place
    // Most have mutable equivs, cept vector


  }
}
