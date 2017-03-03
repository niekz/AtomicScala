/**
  * Created by johann on 2017/03/03.
  */

import Level.Level
import com.atomicscala.AtomicTest._

object AtomicScala4Enumerations {
  import Level._
  import MonthName._

  def main(args: Array[String]): Unit  = {
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
    }

    Level.checkLevel(Empty) is "Alert: Empty"
    Level.checkLevel(Overflow) is ">>> Overflow!"

    MonthName.February is "February"
    MonthName.February.id is 1
  }

  object MonthName extends Enumeration {
    type MonthName = Value
    val January, February, March, April, May, June, July, August, September, October, November, December = Value

  }

  object Level extends Enumeration {
    type Level = Value
    val Overflow, High, Medium, Low, Empty = Value

    def checkLevel(level: Level) = {
      level match {
        case Overflow => ">>> Overflow!"
        case Empty => "Alert: Empty"
        case other => "sLevel $level OK"
      }
    }
  }

