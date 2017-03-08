/**
  * Created by johann on 2017/03/08.
  */

package codelisting
import java.io.FileNotFoundException
import com.atomicscala.AtomicTest._

class ExtensionException(name: String) extends Exception(s"$name doesn't end with a '.scala'")

class CodeListing(val fileName: String) extends collection.IndexedSeq[String] {
  if(!fileName.endsWith(".scala"))
    throw new ExtensionException(fileName)
  val vec = io.Source.fromFile(fileName)
}

object AtomicScala6ConstructorsAndException {
  def main(args: Array[String]): Unit = {

  }
}
