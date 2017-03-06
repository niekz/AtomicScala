/**
  * Created by johann on 2017/03/06.
  */

import com.atomicscala.AtomicTest._

import com.atomicscala.Name



object AtomicScala5Polymorphism {
  def main(args: Array[String]): Unit = {
    val d = new Dragon("Puff")

    d.interact(new Wall) is "Dragon interact Wall"

    battle(new Viking("Puff")) is "Viking, Fight!"
    battle(new Dwarf("Puff")) is "Dwarf, Fight!"
    battle(new Fairy("Puff") with Fighting) is "$anon, Fight!" // Name : $anon$1

    fly(d, new Fairy("Twink")) is "Dragon, Fly!, Fairy interact Dragon"

    val tiger = new A with mobile
    val mazda = new A with mobile

    println(tiger.move(5))
    println(mazda.move(500))

    val e = new Element
    e.draw is "Drawing the element"
    val in = new Inert
    in.draw is "Inert drawing!"
    val wall = new Wall
    wall.draw is "Inert drawing!"

    val d3 = new NoMagicNoFlyingDragon("Puffy")
    d3.player is "Puffy"
  }

  class NoMagicNoFlyingDragon(name: String) extends Character(name) with Name

  def battle(fighter: Fighting) = s"$fighter, ${fighter.fight}"

  def fly(flyer: Element with Flight, opponent: Element) =
    s"$flyer, ${flyer.fly}, ${opponent.interact(flyer)}"




  class A extends B
    with C {
  }

  trait B { //Animal
    val animal = "Animal"
  }

  trait C { //Vehicle
    val vehicle = "Vehicle"
  }

  trait mobile {
    def move(n: Int): String = {
      s"$this Moved $n!"
    }
  }
  class Element extends Name {
    def interact(other: Element) = s"$this interact $other"
    def draw() = s"Drawing the element"
  }

  class Inert extends Element {
    override def draw() = s"$this drawing!"
  }
  class Wall extends Inert {
    override def draw() = s"Don't draw on the $this!"
  }

  trait Material {
    def resilience: String
  }

  trait Wood extends Material {
    def resilience = "Breakable"
  }

  trait Rock extends Material {
    def resilience = "Hard"
  }

  class RockWall extends Wall
    with Rock

  class WoodWall extends Wall
    with Wood

  trait Skill
  trait Fighting extends Skill {
    def fight = "Fight!"
  }

  trait Digging extends Skill {
    def dig = "Dig!"
  }

  trait Magic extends Skill {
    def castSpell = "Spell!"
  }

  trait Flight extends Skill {
    def fly = "Fly!"
  }

  class Character(val player: String = "None")
    extends Element

  class Fairy(name: String) extends Character(name)
    with Magic

  class Viking(name: String) extends Character(name)
    with Fighting

  class Dwarf(name: String) extends Character(name)
    with Digging
    with Fighting

  class Wizard(name: String) extends Character(name)
    with Magic

  class Dragon(name: String) extends Character(name)
    with Magic
    with Flight
}
