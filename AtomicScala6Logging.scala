/**
  * Created by johann on 2017/03/13.
  */

import com.atomicscala.AtomicTest._
import java.util.logging._

object AtomicScala6Logging {
  def main(args: Array[String]): Unit = {

    val lt = new LoggingTest
    lt.f
    lt.g(0)
    lt.g(-1)
    lt.g(101)
  }

  trait Logging {
    val log = Logger.getLogger("")
    log.setUseParentHandlers(false)
    val fileH: FileHandler = new FileHandler("AtomicLog.txt")
    log.addHandler(fileH)
    val consoleH: ConsoleHandler = new ConsoleHandler
    log.addHandler(consoleH)
    val fileH2: FileHandler = new FileHandler("AtomicLog.txt")
    log.addHandler(fileH2)
    val consoleH2: ConsoleHandler = new ConsoleHandler
    log.addHandler(consoleH2)

    consoleH.setLevel(Level.CONFIG)
    consoleH2.setLevel(Level.FINEST)
    fileH.setLevel(Level.INFO)
    fileH2.setLevel(Level.ALL)
    //log.setLevel(Level.ALL)
    //log.getHandlers.foreach(
    //  _.setLevel(Level.ALL))
    //println(log.getHandlers.toVector)
    def error(msg: String) =
      log.severe(msg)
    def warn(msg: String) =
      log.warning(msg)
    def info(msg: String) =
      log.info(msg)
    def debug(msg: String) =
      log.fine(msg)
    def trace(msg: String) =
      log.finer(msg)
  }

  class LoggingTest extends Logging {
    info("Constructing a LoggingTest")
    def f = {
      trace("entering f")
      trace("leaving f")
    }
    def g(i: Int) = {
      debug(s"inside g with i: $i")
      if(i < 0)
        error("i less than 0")
      if(i > 100)
        warn(s"i getting high: $i")
    }
  }

  object LoggingTest extends App with Logging {
    def f = {
      trace("entering f")
      // ...
      trace("leaving f")
    }
    def g(i:Int) = {
      debug(s"inside g with i: $i")
      if(i < 0)
        error("i less than 0")
      if(i > 100)
        warn(s"i getting high: $i")
    }
    def addHandlers(levels:Level*) =
      for(level <- levels) {
        val fh = new FileHandler("AtomicLog-" + level.getName + ".txt")
        val ch = new ConsoleHandler
        fh.setLevel(level)
        ch.setLevel(level)
        log.addHandler(fh)
        log.addHandler(ch)
      }
    def argcvt(arg:String) =
      arg match {
        case "ALL" => Level.ALL
        case "SEVERE" => Level.SEVERE
        case "WARNING" => Level.WARNING
        case "INFO" => Level.INFO
        case "CONFIG" => Level.CONFIG
        case "FINE" => Level.FINE
        case "FINER" => Level.FINER
        case _ => throw new IllegalArgumentException(arg + " not an option")
      }
    for(arg <- args) {
      println("Logging level: " + argcvt(arg))
      addHandlers(argcvt(arg))
    }
    f
    g(0)
    g(-1)
    g(101)
  }
}
