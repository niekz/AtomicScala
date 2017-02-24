import sun.security.krb5.internal.PAData.SaltAndParams

/**
  * Created by johann on 2017/02/22.
  */

import mine.scala.summary2._
import mine.scala.bodies._

object AtomicSummary2 {
  def main(args: Array[String]): Unit = {
    val chars = Vector('a', 'b', 'c', 'd', 'e')
    val ints = Vector(1,2,3,4,5)

    println(chars.min)
    println(ints.min)
    println(chars.max)
    println(ints.max)

    var char = ""
    var int = ""
    for(i <- chars.sorted)
      char += i.toString + " "

    for(i <- ints.sorted)
      int += i.toString + " "

    val charsAndInts = Vector(Vector('a','b','c','d','e'), Vector(1,2,3,4,5))
    var string = ""

    for (i <- charsAndInts){
      println(i)
      for (j <- i){
        string += j
      }
    }

    println(string)

    val x = new BasicMethods()
    println(x.cube(3))

    val temp = new Temperature
    //temp.setCelcius()
    temp.setKelvin(303.15)
    println(temp.getCelcius())
    println(temp.getFahrenheit())
    println(temp.getKelvin())

    val z = new TickTackToe
    val z1 = new z.Grid
    z1.displayBoard()
    z1.play('X', 0, 0)
    z1.play('X', 1, 1)
    z1.play('X', 2, 2)
  }

  class Temperature{
    var current = 0.0
    var scale = "f"
    def setFahrenheit(now: Double): Unit = {
      current = now
      scale = "f"
    }
    def setCelcius(now: Double): Unit = {
      current = now
      scale = "c"
    }
    def setKelvin(now: Double): Unit = {
      current = now
      scale = "k"
    }
    def getFahrenheit(): Double = {
      if(scale == "f")
        current
      else if(scale == "c")
        current * 9.0/5.0 + 32.0
      else
        (current- 273.15) * (9.0/5.0) + (32)
    }
    def getCelcius(): Double = {
      if(scale == "c")
        current
      else if (scale == "f")
        (current-32) * (5.0/9.0)
      else
        (current-273.15)
    }
    def getKelvin(): Double = {
      if(scale == "k")
        current
      else if (scale == "c")
        current + 273.15
      else
        (current-32) * (5.0/9.0) + 273.15
    }

  }

  class TickTackToe {
    class Cell {
      var entry = ' '
      def set(e: Char): String = {
        if(entry == ' ' && (e == 'X' || e == 'O')){
          entry = e
          "successful move"
        } else
          "invalid move"
      }
      def get(): Char = {
        entry
      }
    }

    class Grid {
      val cells = Vector(
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell),
        Vector(new Cell, new Cell, new Cell)
      )

      def displayBoard(): Unit = {
        println("=====")
        for(i <- cells) {
          print("|")
          for (j <- i)
            print(j.get())
          print("|")
          println()
        }
        println("=====")

      }

      def play(e: Char, x: Int, y: Int): String = {
        if(hasWinner._1){
          hasWinner._2 + " has Won!"
        } else {
          if (x < 0 || x > 2 || y < 0 || y > 2) {
            displayBoard()
            "invalid"
          }
          else {
            cells(x)(y).set(e)
            displayBoard()
            cells(x)(y).set(e)
          }
        }
      }

      def hasWinner(): (Boolean, Char) = {
        var rows = ((0,0), (0,0), (0,0))
        var cols = ((0,0), (0,0), (0,0))
        var diag = (0,0)
        var anti = (0,0)
        val z = cells.flatten
        //println(z)
        var count = 0

        for(i <- z) {
          if(i.get() == 'X'){
            if (count == 0) {
              rows = ((rows._1._1, rows._1._2+1), rows._2, rows._3)
              cols = ((cols._1._1, cols._1._2+1), cols._2, cols._3)
              diag = (diag._1, diag._2+1)
            }
            else if (count == 1)     {
              rows = ((rows._1._1, rows._1._2+1), rows._2, rows._3)
              cols = (cols._1, (cols._2._1, cols._2._1+1), cols._3)
            }
            else if (count == 2){
              rows = ((rows._1._1, rows._1._2+1), rows._2, rows._3)
              cols = (cols._1, cols._2, (cols._3._1, cols._3._2+1))
              anti = (anti._1, anti._2+1)
            }
            else if (count == 3){
              rows = (rows._1, (rows._2._1, rows._2._2+1), rows._3)
              cols = ((cols._1._1, cols._1._2+1), cols._2, cols._3)
            }
            else if (count == 4) {
              rows = (rows._1, (rows._2._1, rows._2._2+1), rows._3)
              cols = (cols._1, (cols._2._1, cols._2._1+1), cols._3)
              diag = (diag._1, diag._2+1)
              anti = (anti._1, anti._2+1)
            }
            else if (count == 5){
              rows = (rows._1, (rows._2._1, rows._2._2+1), rows._3)
              cols = (cols._1, cols._2, (cols._3._1, cols._3._2+1))
            }
            else if (count == 6){
              rows = (rows._1, rows._2, (rows._3._1, rows._3._2+1))
              cols = ((cols._1._1, cols._1._2+1), cols._2, cols._3)
              anti = (anti._1, anti._2+1)
            }
            else if (count == 7){
              rows = (rows._1, rows._2, (rows._3._1, rows._3._2+1))
              cols = (cols._1, (cols._2._1, cols._2._1+1), cols._3)
            }
            else if (count == 8){
              rows = (rows._1, rows._2, (rows._3._1, rows._3._2+1))
              cols = (cols._1, cols._2, (cols._3._1, cols._3._2+1))
              diag = (diag._1, diag._2+1)
            }
          } else if(i.get() == 'O'){
            if (count == 0) {
              rows = ((rows._1._1+1, rows._1._2), rows._2, rows._3)
              cols = ((cols._1._1+1, cols._1._2), cols._2, cols._3)
              diag = (diag._1+1, diag._2)
            }
            else if (count == 1)     {
              rows = ((rows._1._1+1, rows._1._2), rows._2, rows._3)
              cols = (cols._1, (cols._2._1+1, cols._2._1), cols._3)
            }
            else if (count == 2){
              rows = ((rows._1._1+1, rows._1._2), rows._2, rows._3)
              cols = (cols._1, cols._2, (cols._3._1+1, cols._3._2))
              anti = (anti._1+1, anti._2)
            }
            else if (count == 3){
              rows = (rows._1, (rows._2._1+1, rows._2._2), rows._3)
              cols = ((cols._1._1+1, cols._1._2), cols._2, cols._3)
            }
            else if (count == 4) {
              rows = (rows._1, (rows._2._1+1, rows._2._2), rows._3)
              cols = (cols._1, (cols._2._1+1, cols._2._1), cols._3)
              anti = (anti._1 + 1, anti._2)
              diag = (diag._1 + 1, diag._2)
            }
            else if (count == 5){
              rows = (rows._1, (rows._2._1+1, rows._2._2), rows._3)
              cols = (cols._1, cols._2, (cols._3._1+1, cols._3._2))
            }
            else if (count == 6){
              rows = (rows._1, rows._2, (rows._3._1+1, rows._3._2))
              cols = ((cols._1._1+1, cols._1._2), cols._2, cols._3)
              anti = (anti._1+1, anti._2)
            }
            else if (count == 7){
              rows = (rows._1, rows._2, (rows._3._1+1, rows._3._2))
              cols = (cols._1, (cols._2._1+1, cols._2._1), cols._3)
            }
            else if (count == 8){
              rows = (rows._1, rows._2, (rows._3._1+1, rows._3._2))
              cols = (cols._1, cols._2, (cols._3._1+1, cols._3._2))
              diag = (diag._1+1, diag._2)
            }
          }

          count += 1
        }
        if(rows._1._1 == 3 || rows._2._1 == 3 || rows._3._1 == 3 ||
            cols._1._1 == 3 || rows._2._1 == 3 || rows._3._1 == 3 ||
            diag._1 == 3 || anti._1 == 3) {
          (true, 'O')
        }
        else if(rows._1._2 == 3 || rows._2._2 == 3 || rows._3._2 == 3 ||
            cols._1._2 == 3 || rows._2._2 == 3 || rows._3._2 == 3 ||
            diag._2 == 3 || anti._2 == 3) {
          (true, 'X')
        } else
          (false, ' ')
      }
    }
  }

}
