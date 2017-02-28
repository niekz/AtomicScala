/**
  * Created by johann on 2017/02/28.
  */
import com.atomicscala.AtomicTest._

object AtomicScala3AuxiliaryConstructors {
  def main(args: Array[String]): Unit = {
    new GardenGnome(20.0, 110.0, false).show() is "20.0 110.0 false true"
    new GardenGnome("Bob").show() is "15.0 100.0 true true"

    val washer = new ClothesWasher3("LG 100", 3.6)
    washer.wash(2, 1) is "Wash used 2 bleach and 1 fabric softener"
    washer.wash() is "Simple wash"
  }

  class GardenGnome(val height: Double, val weight: Double, val happy: Boolean){
    println("Inside primary constructor")
    var painted = true
    def magic(level: Int): String = {
      "Poof! " + level
    }
    def this(height: Double){
      this(height, 100.0, true)
    }
    def this(name: String){
      this(15.0)
      painted is true
    }
    def show(): String = {
      height + " " + weight + " " + happy + " " + painted
    }
  }

  class ClothesWasher(modelName: String, capacity: Double){
    def this(modelName: String) {
      this(modelName, 0.0)
    }

    def this(capacity: Double) {
      this(modelName = "", capacity)
    }
  }

  class ClothesWasher2(modelName: String = "", capacity: Double = 0.0){
    def this(modelName: String) {
      //println("Testing primary constructor call") // uncomment to see error
      this(modelName, 0.0)
    }

    def this(capacity: Double) {
      this(modelName = "", capacity)
    }
  }

  class ClothesWasher3(modelName: String = "", capacity: Double = 0.0){
    def wash(): String = {
      "Simple wash"
    }

    def wash(bleach: Int, softener: Int): String = {
      "Wash used " + bleach + " bleach and " + softener + " fabric softener"
    }
  }



}
