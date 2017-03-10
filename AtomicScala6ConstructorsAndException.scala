/**
  * Created by johann on 2017/03/08.
  */

package codelisting
import java.io.FileNotFoundException
import com.atomicscala.AtomicTest._
import scala._

class ExtensionException(name: String) extends Exception(s"$name doesn't end with a '.scala'")

class CodeListing(val fileName: String) extends collection.IndexedSeq[String] {
  if(!fileName.endsWith(".scala"))
    throw new ExtensionException(fileName)
  val vec = io.Source.fromFile(fileName).getLines.toVector

  def apply(idx: Int) = vec(idx)
  def length = vec.length
}

object CodeListing {
  def apply(name: String) = {
    try{
      new CodeListing(name)
    } catch {
      case _: FileNotFoundException => Vector(s"File Not Found: $name")
      case _: NullPointerException => Vector("Error: Null file name")
      case e: ExtensionException => Vector(e.getMessage())
    }
  }
}

class CodeListingTester(
  makeList: String => IndexedSeq[String]) {
  makeList("CodeListingTester.scala")(4) is "class CodeListingTester("
  makeList("NotAFile.scala")(0) is "File Not Found: NotAFile.scala"
  makeList("NotAScalaFile.txt")(0) is "NotAScalaFile.txt doesn't end with '.scala'"
  makeList(null)(0) is "Error: Null file name"
}

class CodeListingTester1(makeList: String => IndexedSeq[String]) {
  val l = makeList("/home/johann/IdeaProjects/AtomicScala/src/AtomicScala6ConstructorsAndException.scala")
  var count = 1
  for(i <- l) {
    println(count + "\t: " + i)
    count += 1
  }
}

object AtomicScala6ConstructorsAndException {
  def main(args: Array[String]): Unit = {
    new CodeListingTester1(CodeListing.apply)

  }
}
