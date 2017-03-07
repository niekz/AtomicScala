/**
  * Created by johann on 2017/03/07.
  */
import com.atomicscala.AtomicTest._

object AtomicScala5Sets {
  def main(args: Array[String]): Unit = {

    val fruits = Set("apple", "orange",
      "banana", "kiwi")
    val vegetables = Set("beans", "peas",
      "carrots", "sweet potatoes",
      "asparagus", "spinach")
    val meats = Set("beef", "chicken")
    val groceryCart = Set("apple",
      "pretzels", "bread", "orange", "beef",
      "beans", "asparagus", "sweet potatoes",
      "spinach", "carrots")

    val vegetarian = Set("kidney beans",
      "black beans", "tofu")
    val groceryCart2 = Set("apple",
      "pretzels", "bread", "orange", "beef",
      "beans", "asparagus", "sweet potatoes",
      "kidney beans", "black beans")

    val box1 = Set("shoes", "clothes")
    val box2 = Set("toys", "dishes")
    val box3 = Set("toys", "games", "books")
    val attic = Set(box1, box2)
    val basement = Set(box3)
    val house = Set(attic, basement)
    Set("shoes", "clothes", "toys",
      "dishes") is attic.flatten
    Set("toys", "games", "books") is
      basement.flatten
    Set("shoes", "clothes", "toys",
      "dishes", "games", "books") is house.flatten.flatten

    percentVegetarian(groceryCart2) is 20.0
    percentProtein(groceryCart2) is 30.0

    percentMeat(groceryCart) is 10.0
    percentFruit(groceryCart) is 20.0
    percentVeggies(groceryCart) is 50.0
    percentOther(groceryCart) is 20.0


    def percentVegetarian(cart: Set[String]): Double = {
      ((cart & vegetarian).size.toDouble / cart.size.toDouble) * 100.0
    }

    def percentProtein(cart: Set[String]): Double = {
      ((cart & (meats ++ vegetarian)).size.toDouble / cart.size.toDouble) * 100.0
    }

    def percentMeat(cart: Set[String]): Double = {
      ((cart & meats).size.toDouble / cart.size.toDouble) * 100.0
    }

    def percentFruit(cart: Set[String]): Double = {
      ((cart & fruits).size.toDouble / cart.size.toDouble) * 100.0
    }

    def percentVeggies(cart: Set[String]): Double = {
      ((cart & vegetables).size.toDouble / cart.size.toDouble) * 100.0
    }

    def percentOther(cart: Set[String]): Double = {
      (cart -- (meats | fruits | vegetables)).size.toDouble / cart.size.toDouble * 100.0
    }


  }




}
