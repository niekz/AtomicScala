/**
  * Created by johann on 2017/02/27.
  */
import com.atomicscala.AtomicTest._
import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor2

object AtomicScala3Constructors {
  def main(args: Array[String]): Unit = {
    val usual = new Coffee
    //usual.result is "HereCup shot shot "
    val mocha = new Coffee(decaf = true, toGo = true, syrup = "Chocolate")
    //mocha.result is "ToGoCup decaf shot decaf shot Chocolate"

    val doubleHalfCaf = new Coffee(shots=2, caf=1)
    val tripleHalfCaf = new Coffee(shots=3, caf=2)
    doubleHalfCaf.caf is 1
    doubleHalfCaf.caf is 1
    doubleHalfCaf.shots is 2
    tripleHalfCaf.caf is 2
    //tripleHalfCaf.caf is 1
    tripleHalfCaf.shots is 3

    val tea = new Tea2
    tea.describe is "Earl Grey"
    tea.calories is 0
    tea.name is "Earl Grey"

    val lemonZinger = new Tea2(
      decaf = true, name = "Lemon Zinger")
    lemonZinger.describe is "Lemon Zinger decaf"
    lemonZinger.calories is 0
    lemonZinger.decaf is true

    val sweetGreen = new Tea2(
      name = "Jasmine Green", sugar = true)
    sweetGreen.describe is "Jasmine Green + sugar"
    sweetGreen.calories is 16
    sweetGreen.sugar is true

    val teaLatte = new Tea2(
      sugar = true, milk = true)
    teaLatte.describe is "Earl Grey + milk + sugar"
    teaLatte.calories is 116
    teaLatte.milk is true



  }

  class Coffee(val shots: Int = 2,
               val decaf: Boolean = false,
               val caf: Int = 0,
               val milk: Boolean = false,
               val toGo: Boolean = false,
               val syrup: String = "") {
    var result = ""
    println(shots, decaf, milk, toGo, syrup)

    def getCup(): Unit = {
      if(toGo)
        result += "ToGoCup "
      else
        result += "HereCup "
    }

    def pourShots(): Unit = {
      var count = 0
      for(s <- 0 until caf)
        if(count < caf) {
          result += "decaf shot "
          count += 1
        }
        else{
          count = 0
          for(s <- 0 until caf)
            if(count < caf) {
              result += "shot "
              count += 1
            }
        }
    }

    def addMilk(): Unit = {
      if(milk)
        result += "milk "
    }

    def addSyrup(): Unit = {
      result += syrup
    }

    getCup()
    pourShots()
    addMilk()
    addSyrup()
  }

  class Tea(milk: Boolean = false, sugar: Boolean = false, decaf: Boolean = false, var name: String = "Earl Grey", var cals: Int = 0){
    def describe(): String = {
      if(milk)
        name += " + milk"
      if(sugar)
        name += " + sugar"
      if(decaf)
        name += " decaf"
      name
    }

    def calories(): Int = {
      if(milk)
        cals += 100
      if(sugar)
        cals += 16
      cals
    }

  }

  class Tea2(var milk: Boolean = false, var sugar: Boolean = false, var decaf: Boolean = false, var name: String = "Earl Grey", var cals: Int = 0){
    def describe(): String = {
      if(milk)
        name += " + milk"
      if(sugar)
        name += " + sugar"
      if(decaf)
        name += " decaf"
      name
    }

    def calories(): Int = {
      if(milk)
        cals += 100
      if(sugar)
        cals += 16
      cals
    }

  }
}
