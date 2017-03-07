/**
  * Created by johann on 2017/03/06.
  */

import com.atomicscala.AtomicTest._

object AtomicScala5Composition {
  def main(args: Array[String]): Unit = {
    val serving = new ServingKitchen
    serving.serveFood is true
    serving.prepFood is false
    serving.utensils is "Vector(ServeUtensils)"
    val prep = new PrepKitchen
    prep.prepFood is true
    prep.serveFood is false
    prep.utensils is "Vector(PrepUtensils)"
    val simple = new SimpleKitchen
    simple.serveFood is true
    simple.prepFood is true
    simple.utensils is "Vector(ServeUtensils, PrepUtensils)"

  }

  trait Building
  trait Room
  trait Storage
  trait Sink
  trait Store[T]
  trait Cook[T]
  trait Clean[T]
  trait Serve {
    //val serveFood = true
  }
  trait Prep {
    //val prepFood = true
  }
  trait Food extends Store[Food]
    with Clean[Food]
    with Cook[Food]
  trait Utensils extends Store[Utensils]
    with Clean[Utensils] with Cook[Utensils]

  class ServeUtensils extends Utensils {
    override def toString(): String = {
      "ServeUtensils"
    }
  }
  class PrepUtensils extends Utensils {
    override def toString(): String = {
      "PrepUtensils"
    }
  }



  abstract trait Kitchen /*extends Room*/ {
    def serveFood(): Boolean
    def prepFood(): Boolean
    //val storage: Storage
    //val sinks: Vector[Sink]
    //val food: Food
    //val utensils: Utensils
  }

  trait House extends Building {
    val kitchens: Vector[Kitchen]
  }

  class ServingKitchen extends Kitchen with Serve{
    val utensils: Vector[Utensils] = Vector(new ServeUtensils)
    override def serveFood(): Boolean = true
    override def prepFood(): Boolean = false
  }

  class PrepKitchen extends Kitchen with Prep{
    val utensils: Vector[Utensils] = Vector(new PrepUtensils)
    override def serveFood(): Boolean = false
    override def prepFood(): Boolean = true
  }

  class SimpleKitchen extends Kitchen with Prep with Serve {
    val utensils: Vector[Utensils] = Vector(new ServeUtensils, new PrepUtensils)
    override def serveFood() : Boolean = true
    override def prepFood(): Boolean = true
  }



}
