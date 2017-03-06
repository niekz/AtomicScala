/**
  * Created by johann on 2017/03/06.
  */
package com.atomicscala
import reflect.runtime.currentMirror
import com.atomicscala.AtomicTest._

object Name{
  def className(o: Any) =
    currentMirror.reflect(o).symbol.toString./*replace('$', ' ').*/split(' ').last
}

trait Name {
  override def toString = Name.className(this)
}

import com.atomicscala.Name


object AtomicScala4ALittleReflection {
  def main(args: Array[String]): Unit = {
    class Solid extends Name
    val s = new Solid
    s is "Solid"

    class Solid2(val size: Int) extends Name {
      override def toString = s"${super.toString}($size)"
    }

    val s2 = new Solid2(47)
    s2 is "Solid2(47)"

    case class test(i: Int)

    val i = test(5)

    println(i)

    case class test2(i: Int) extends Name

    val i2 = test2(5)

    println(i2)

    class test3(i: Int) extends Name

    val i3 = new test3(5)

    println(i3)


  }
}