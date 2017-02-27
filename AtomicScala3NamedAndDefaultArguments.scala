/**
  * Created by johann on 2017/02/27.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3NamedAndDefaultArguments {
  def main(args: Array[String]): Unit = {
    new Color(red = 80, blue = 9, green = 100)

    val t = new SimpleTime(hours = 5, minutes=30)
    //t.hours is 5
    //t.minutes is 30

    val t2 = new SimpleTime(hours = 10)
    //t2.hours is 10
    //t2.minutes is 0

    val p = new Planet(name = "Mercury", description = "small and hot planet", moons = 0)
    p.hasMoon is false

    val earth = new Planet(moons = 1, name = "Earth", description = "a hospitable planet")
    earth.hasMoon is true

    // Cant have default params with param listings (flexible family)

    val flour = new item(name = "flour", 4)

    flour.cost(grocery = true) is 4
    val sunscreen = new item(name = "sunscreen", 3)
    sunscreen.cost() is 3.3
    val tv = new item(name = "television", 500)
    tv.cost(taxRate = 0.06) is 530

  }
  class Color(red: Int, blue: Int, green: Int)
  class Color2(red: Int = 100, blue: Int = 100, green: Int = 100)

  class SimpleTime(minutes: Int = 0, hours: Int)

  class Planet(name: String, description: String, moons: Int = 0){
    def hasMoon: Boolean = {
      if(moons > 0)
        true
      false
    }
  }

  class FlexibleFamily(mom: String /*= "Testing default argument values with param list"*/, dad: String, children: String*){
    def familySize(): Int = {
      var i = 2
      for(x <- children)
        i += 1
      i
    }
  }

  class item(name: String, price: Double){
    def cost(grocery: Boolean = false, medication: Boolean = false, taxRate: Double = 0.10): Double = {
      if(grocery || medication)
        price
      else
        price+(price*taxRate)
    }
  }

}
