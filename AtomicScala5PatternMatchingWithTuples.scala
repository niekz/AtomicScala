/**
  * Created by johann on 2017/03/07.
  */
// PaintColors.scala
package paintcolors

import com.atomicscala.AtomicTest._


object AtomicScala5PatternMatchingWithTuples {
  import paintcolors.Color._
  import paintcolors.Color.Color

  def main(args: Array[String]): Unit = {
    def blend(a:Color, b:Color) =
      (a, b) match {
        case _ if a == b => a
        case (`red`, `blue`) |
             (`blue`, `red`) => purple
        case (`red`, `yellow`) |
             (`yellow`, `red`) => orange
        case (`blue`, `yellow`) |
             (`yellow`, `blue`) => green
        case (`brown`, _) |
             (_, `brown`) => brown
      }

    blend(red, yellow) is orange
    blend(red, red) is red
    blend(yellow,blue) is green

    def blend2(a:Color, b:Color) =
      (a, b) match {
        case _ if a == b => a
        case (`red`, `blue`) |
             (`blue`, `red`) => purple
        case (`red`, `yellow`) |
             (`yellow`, `red`) => orange
        case (`blue`, `yellow`) |
             (`yellow`, `blue`) => green
        case (`magenta`, `yellow`) |
             (`yellow`, `magenta`) => purple
        case (`magenta`, `red`) |
             (`red`, `magenta`) => purple
        case (`brown`, _) |
             (_, `brown`) => brown
        case _ => // Interesting, not accurate:
          Color((a.id + b.id) % Color.maxId)
      }

    blend2(red, yellow) is orange
    blend2(red, red) is red
    blend2(yellow,blue) is green
    blend2(yellow, magenta) is purple
    blend2(red, magenta) is purple

    def blend3(a:Color, b:Color) =
      (a, b) match {
        case _ if a == b => a
        case _ if a == `white` => b
        case _ if b == `white` => a
        case (`red`, `blue`) | (`blue`, `red`) => purple
        case (`red`, `yellow`) | (`yellow`, `red`) => orange
        case (`blue`, `yellow`) | (`yellow`, `blue`) => green
        case (`magenta`, `yellow`) | (`yellow`, `magenta`) => purple
        case (`magenta`, `red`) | (`red`, `magenta`) => purple
        case (`brown`, _) | (_, `brown`) => brown
        case _ => // Interesting, not accurate:
          Color((a.id + b.id) % Color.maxId)
      }


    blend3(red, yellow) is orange
    blend3(red, red) is red
    blend3(yellow,blue) is green
    blend3(yellow, magenta) is purple
    blend3(red, magenta) is purple
    blend3(purple, white) is purple
    blend3(white, red) is red
  }
}
  object Color extends Enumeration {
    type Color = Value
    val red, blue, yellow, purple,
    green, orange, brown, magenta, white = Value
  }
