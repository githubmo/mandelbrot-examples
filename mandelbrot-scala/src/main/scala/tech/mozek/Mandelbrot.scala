package tech.mozek

import spire.*
import spire.math.*
import spire.implicits.*

import scala.util.{ Failure, Success, Try }
object Mandelbrot {

  val Threshold  = 255
  val UpperBound = 4
  def compute(x: Complex[Double]): Int = {

    @tailrec
    def compute(xx: Complex[Double], iter: Int): Int = {
      if (iter >= Threshold) Threshold
      else {
        val maybeN            = Try(xx * xx).map(_ + x)
        val isAboveUpperBound = Try(xx.absSquare >= UpperBound).getOrElse(true)
        maybeN match {
          case Failure(_)                      => iter
          case Success(_) if isAboveUpperBound =>
//            if (t > 1) println(s"got my T ${t}")
            iter
          case Success(n) => compute(n, iter + 1)
        }
      }
    }
    compute(x, 1)
  }

  def invert(i: Int): Int = {
    require(i >= 0 && i <= 255, "Supplied number must be between 0 and 255")
    255 - i
  }

}
