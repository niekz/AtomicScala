/**
  * Created by johann on 2017/03/06.
  */

import java.text.SimpleDateFormat

import com.atomicscala.AtomicTest._
import org.apache.commons.math._
import stat.regression.SimpleRegression
import org.apache.commons.math.stat.Frequency
import org.apache.commons.math.stat.descriptive.SummaryStatistics

object AtomicScala4ReachingIntoJava {
  def main(args: Array[String]): Unit = {
    val r = new SimpleRegression
    r.addData(1, 1)
    r.addData(2, 1.1)
    r.addData(3, 0.9)
    r.addData(4, 1.2)
    r.getN is 4
    r.predict(6) is 1.19

    val datePattern: SimpleDateFormat = new SimpleDateFormat("MM/dd/yy") // gives 0 when using mm. wonder why
    val mayDay = datePattern.parse("05/01/12")
    mayDay.getDate is 1
    mayDay.getMonth is 4

    //mayDay.getDay is 4

    val f = new Frequency()
    //f.addValue("cat", "dog", "cat", "bird", "cat", "cat", "kitten", "mouse")
    // f.addValue(List("cat", "dog", "cat", "bird", "cat", "cat", "kitten", "mouse"))
    f.addValue("cat")
    f.addValue("cat")
    f.addValue("cat")
    f.addValue("cat")
    f.getCount("cat") is 4

    val s = new SummaryStatistics
    s.addValue(10.0)
    s.addValue(20.0)
    s.addValue(30.0)
    s.addValue(80.0)
    s.addValue(90.0)
    s.addValue(100.0)

    s.getMean is 55
    s.getStandardDeviation is 39.370039370059054
  }


}
