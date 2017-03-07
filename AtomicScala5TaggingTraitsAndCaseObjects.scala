/**
  * Created by johann on 2017/03/07.
  */
import com.atomicscala.AtomicTest._

object AtomicScala5TaggingTraitsAndCaseObjects {
  def main(args: Array[String]): Unit = {
    Color.values.map(display) is "Vector(It's Red, It's Green, It's Blue)"

    EnumColor.Red is "Red"
    EnumColor.Blue is "Blue"
    EnumColor.Green is "Green"
  }

  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color
  case object Purple extends Color
  object Color {
    val values = Vector(Red, Green, Blue, Purple, Red) //Adding another Red works. Is just another element in the vector
  }

  object EnumColor extends Enumeration {
    type EnumColor = Value
    val Red, Green, Blue = Value //Can't add another Red. Already defined.
  }

  def display(c: Color) = {
    c match {
      case Red => s"It's $c"
      case Blue => s"It's $c"
      case Green => s"It's $c"
      case Purple => s"It's $c" // Fails without this. Could also do case _
    }
  }
}


