

/**
  * Created by johann on 2017/03/07.
  */
//package sodafountain
/*
import sodafountain.AtomicScala5BuildingSystemsWithTraits.Holder.Holder
import sodafountain.AtomicScala5BuildingSystemsWithTraits.IceCream.IceCream
import sodafountain.AtomicScala5BuildingSystemsWithTraits.Quantity.Quantity
import sodafountain.AtomicScala5BuildingSystemsWithTraits.Sprinkle.Sprinkle
import sodafountain.AtomicScala5BuildingSystemsWithTraits.Syrup.Syrup
*/

import com.atomicscala.AtomicTest._

object AtomicScala5BuildingSystemsWithTraits {
  def main(args: Array[String]): Unit = {
    object Shots extends Enumeration {
      type Shots = Value
      val Single, Double, Triple = Value
    }

    object Cup extends Enumeration {
      type Cup = Value
      val ToGo, Here = Value
    }

    object Caffeine extends Enumeration {
      type Caffeine = Value
      val Caf, HalfCaf, Decaf = Value
    }

    object Milk extends Enumeration {
      type Milk = Value
      val NoMilk, Skim, Lowfat = Value
    }

    trait Flavor

    object Syrup extends Enumeration {

      case class _Val() extends Val
        with Flavor

      type Syrup = _Val
      val NoFlavor, Vanilla, Hazelnut,
      Raspberry, Choc = _Val()
    }

    trait Amount {
      val pumps: Int
    }

    trait Taste[F <: Flavor] extends Amount {
      val flavor: F
    }

    import Shots._
    import Caffeine._
    import Cup._
    import Milk._
    import Syrup._

    case class Coffee(shots: Shots, caffeine: Caffeine, cup: Cup, milk: Milk, syrup: Syrup)


    Coffee(Single, Caf, Here, Skim, Choc) is "Coffee(Single,Caf,Here,Skim,Choc)"
    Coffee(Double, Caf, Here, NoMilk, NoFlavor) is "Coffee(Double,Caf,Here,NoMilk,NoFlavor)"
    Coffee(Double, HalfCaf, ToGo, Skim, Choc) is "Coffee(Double,HalfCaf,ToGo,Skim,Choc)"
  }

  /*
    def main(args: Array[String]): Unit = {
      import sodafountain.AtomicScala5BuildingSystemsWithTraits.Holder._
      import sodafountain.AtomicScala5BuildingSystemsWithTraits.IceCream._
      import sodafountain.AtomicScala5BuildingSystemsWithTraits.Quantity._
      import sodafountain.AtomicScala5BuildingSystemsWithTraits.Syrup._

      val iceCreamCone = Scoops(WaffleCone,
        Scoop(Extra, MochaFudge),
        Scoop(Extra, ButterPecan),
        Scoop(Extra, IceCream.Chocolate))

      iceCreamCone is "Scoops(WaffleCone,WrappedArray(Scoop(Extra,MochaFudge), Scoop(Extra,ButterPecan), Scoop(Extra,Chocolate)))"

      case class MadeToOrder(holder: Holder, scoops: Seq[Scoop], toppings: Seq[Topping])

      val iceCreamDish = MadeToOrder(Bowl, Seq(Scoop(Regular, Strawberry), Scoop(Regular, ButterPecan)), Seq[Topping]())

      iceCreamDish is "MadeToOrder(Bowl,List(Scoop(Regular,Strawberry), Scoop(Regular,ButterPecan)),List())"

      case class Sundae(sauce: Sauce, sprinkles: Sprinkles, whipped: WhippedCream, nuts: Nuts, scoops: Scoop*) {
        val holder: Holder = Bowl
      }

      val hotFudgeSundae = Sundae(Sauce(Regular, HotFudge), Sprinkles(Regular, Sprinkle.Chocolate), WhippedCream(Regular), Nuts(Regular), Scoop(Regular, Coffee), Scoop(Regular, RumRaisin))

      new CoffeeWithTraits()

    }

    object Quantity extends Enumeration {
      type Quantity = Value
      val None, Small, Regular, Extra, Super = Value
    }

    object Holder extends Enumeration {
      type Holder = Value
      val Bowl, Cup, Cone, WaffleCone = Value
    }

    trait Flavor

    object Syrup extends Enumeration {

      case class _Val() extends Val with Flavor

      type Syrup = _Val
      val Chocolate, HotFudge, Butterscotch, Caramel = _Val()
    }

    object IceCream extends Enumeration {

      case class _Val() extends Val with Flavor

      type IceCream = _Val
      val Chocolate, Vanilla, Strawberry, Coffee, MochaFudge, RumRaisin, ButterPecan = _Val()
    }

    object Sprinkle extends Enumeration {

      case class _Val() extends Val with Flavor

      type Sprinkle = _Val
      val None, Chocolate, Rainbow = _Val()
    }

    trait Amount {
      val quant: Quantity
    }

    trait Taste[F <: Flavor] extends Amount {
      val flavor: F
    }

    case class Scoop(quant: Quantity, flavor: IceCream) extends Taste[IceCream]

    trait Topping

    case class Sprinkles(quant: Quantity, flavor: Sprinkle) extends Taste[Sprinkle] with Topping

    case class Sauce(quant: Quantity, flavor: Syrup) extends Taste[Syrup] with Topping

    case class WhippedCream(quant: Quantity) extends Amount with Topping

    case class Nuts(quant: Quantity) extends Amount with Topping

    class Cherry extends Topping

    case class Scoops(holder: Holder, scoops: Scoop*)
  */
  // Solution-1.scala
  // Solution to Exercise 1 in "Building Systems with Traits"


}
