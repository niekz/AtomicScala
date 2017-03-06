/**
  * Created by johann on 2017/03/03.
  */

import AtomicScala4Enumerations.MonthName.MonthName
import AtomicScala4Enumerations.MonthName2.MonthName2
import com.atomicscala.AtomicTest._
import AtomicScala4Enumerations.TickTackToe

object AtomicScala4Enumerations {


  def main(args: Array[String]): Unit = {
    import Level._

    Level.Medium is "Medium"
    Medium is "Medium"

    {
      for (n <- Range(0, Level.maxId))
        yield (n, Level(n))
    } is Vector((0, Overflow), (1, High), (2, Medium),
      (3, Low), (4, Empty))

    {
      for (lev <- Level.values)
        yield lev
    }.toIndexedSeq is Vector(Overflow, High, Medium, Low, Empty)

    Level.checkLevel(Level.Empty) is "Alert: Empty"
    Level.checkLevel(Level.Overflow) is ">>> Overflow!"

    MonthName.February is "February"
    MonthName.February.id is 1

    MonthName2.February is "February"
    MonthName2.February.id is 2
    MonthName2.December.id is 12
    MonthName2.July.id is 7

    MonthName2.July is "July"
    monthNumber(MonthName2.July) is 7

    season(MonthName.January) is "Winter"

    season(MonthName.January) is "Winter"
    season(MonthName.April) is "Spring"
    season(MonthName.August) is "Summer"
    season(MonthName.November) is "Autumn"

    Level.Draining is Draining
    Level.Draining.id is 5
    checkLevel(Low) is "Level Low OK"
    checkLevel(Empty) is "Alert"
    checkLevel(Draining) is "Level Draining OK"
    checkLevel(Pooling) is "Warning!"
    checkLevel(Dry) is "Alert"
  }

  object MonthName extends Enumeration {
    type MonthName = Value
    val January, February, March, April, May, June, July, August, September, October, November, December = Value

  }

  object MonthName2 extends Enumeration {
    type MonthName2 = Value
    val January = Value(1)
    val February, March, April, May, June, July, August, September, October, November, December = Value


  }

  def season(enumeration: MonthName): String = {
    enumeration match {
      case winter: MonthName if (winter.toString == "Decembner"
        || winter.toString == "January"
        || winter.toString == "February") => "Winter"
      case spring: MonthName if (spring.toString == "March"
        || spring.toString == "April"
        || spring.toString == "May") => "Spring"
      case summer: MonthName if (summer.toString == "June"
        || summer.toString == "July"
        || summer.toString == "August") => "Summer"
      case autumn: MonthName if (autumn.toString == "September"
        || autumn.toString == "October"
        || autumn.toString == "November") => "Autumn"
      case _ => "How did you manage something other than a month?"
    }
  }

  def monthNumber(enumeration: MonthName2): Int = {
    enumeration.id
  }

  object Level extends Enumeration {
    type Level = Value
    val Overflow, High, Medium, Low, Empty, Draining, Pooling, Dry = Value


    def checkLevel(level: Level) = {
      level match {
        case Pooling => "Warning!"
        case Draining => "Level Draining OK"
        case Dry => "Alert"
        case Overflow => ">>> Overflow!"
        case Empty => "Alert"
        case other => s"Level $level OK"
      }
    }
  }

  class TickTackToe {

    class Cell {
      var entry = ' '

      def set(e: Char): String = {
        if (entry == ' ' && (e == 'X' || e == 'O')) {
          entry = e
          "successful move"
        } else
          "invalid move"
      }
    }

    class Grid {
      val cells = Vector(
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell)
      )

      def play(e: Char, x: Int, y: Int): String = {
        if (x < 0 || x > 2 || y < 0 || y > 2)
          "invalid move"
        else
          cells(x)(y).set(e)
      }
    }

    val grid = new Grid
    grid.play('X', 1, 1) is "successful move"
    grid.play('X', 1, 1) is "invalid move"
    grid.play('O', 1, 3) is "invalid move"


  }

}
