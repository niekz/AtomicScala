/**
  * Created by johann on 2017/03/13.
  */
import com.atomicscala.AtomicTest._

object AtomicScala6ExtensionMethods {
  def main(args: Array[String]): Unit = {

  }

  object Quoting {

    implicit class AnyName(s: String) {
      def singleQuote = s"'$s'"
      def doubleQuote = s""""$s""""
    }

    implicit class AnyNameValue(val s: String) extends AnyVal {
      def singleQuote = s"'$s'"
      def doubleQuote = s""""$s""""
    }

    case class Book(title: String)
/*
    object BookExtension {
      implicit class Ops(book: Book) {
        def categorize(category: String) = s"$book, category: $category"
      }
    }
    //import BookExtension._
    */
    //Book("Dracula") categorize "Vampire" is "Book(Dracula), category: Vampire"

    object BookExtensionWithoutExtension {
      class Ops(book: Book) {
        def categorize(category: String) = s"$book, category: $category"
      }
    }

  }


}
