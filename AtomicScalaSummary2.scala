/**
  * Created by johann on 2017/02/22.
  */

class AtomicScalaSummary2 {
  def getSquare(n: Int): Int = {
    n * n
  }
  val a = getSquare(3)
  val expectedA = 9
  assert(a == expectedA, "Failed to obtain square. Expected : " + expectedA + ". Got : " + a + " instead.")
  val b = getSquare(6)
  val expectedB = 36
  assert(b == expectedB, "Failed to obtain square. Expected : " + expectedB + ". Got : " + b + " instead.")
  val c = getSquare(5)
  val expectedC = 25
  assert(a == expectedC, "Failed to obtain square. Expected : " + expectedC + ". Got : " + c + " instead.")
}