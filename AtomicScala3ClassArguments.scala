/**
  * Created by johann on 2017/02/24.
  */

import com.atomicscala.AtomicTest._

object AtomicScala3ClassArguments {
  def main(args: Array[String]) = {
    val ca = new ClassArg(19)
    ca.f() is 190

    val ca2 = new ClassArg2(20)
    val ca3 = new ClassArg3(21)

    ca2.a is 20
    ca3.a is 21
    ca2.a = 24
    ca2.a is 24

    new Sum3(13, 27, 44).result() is 84

    new Sum(13, 27, 44).result() is 84
    new Sum(1, 3, 5, 7, 9, 11).result() is  36

    val family1 = new Family("Mom", "Dad", "Sally", "Dick")
    family1.familySize() is 4

    val family2 = new Family("Mom", "Dad", "Bob")
    family2.familySize() is 3

    val family3 = new Family("Mom", "Dad", "child")
    family3.familySize() is 3

    val family4 = new Family("Mom", "Dad", "child1", "child2")
    family4.familySize() is 4

    val familyWithNoKids = new Family("Mom", "Dad")
    familyWithNoKids.familySize() is 2


  }

  class ClassArg(a: Int) {
    println(f)
    def f(): Int = { a * 10 }
  }

  class ClassArg2(var a: Int)
  class ClassArg3(val a: Int)



  class Sum3(a1: Int, a2: Int, a3: Int) {
    def result(): Int = {
      a1 + a2 + a3
    }
  }



  class Sum(args: Int*) {
    def result(): Int = {
      var total = 0
      for(n <- args){
        total += n
      }
      total
    }
  }


  class Family(names: String*){
    def familySize(): Int = {
      var i = 0
      for(x <- names)
        i += 1
      i
    }
  }

  class FlexibleFamily(mom: String, dad: String, children: String*){
    def familySize(): Int = {
      var i = 2
      for(x <- children)
        i += 1
      i
    }
  }

  //class FlexibleFamilyTwo(parents: String*, children: String*) // Cant. How would it know where the one list ends and the other begins?

  // Other way around wont work either. Same reason.






}

//class Family()


