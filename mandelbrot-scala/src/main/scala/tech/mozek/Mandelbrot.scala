package tech.mozek

import spire.*
import spire.math.*
import spire.implicits.*

import scala.util.{ Failure, Success, Try }
object Mandelbrot {

  private val Threshold  = 255
  private val UpperBound = 4
  def compute(x: Complex[Double]): Int = {

    @tailrec
    def compute(xx: Complex[Double], iter: Int): Int = {
      if (iter >= Threshold) Threshold
      else {
        val maybeN            = Try(xx * xx).map(_ + x)
        val isAboveUpperBound = Try(xx.absSquare >= UpperBound).getOrElse(true)
        maybeN match {
          case Failure(_) => iter
          case Success(_) if isAboveUpperBound =>
            iter
          case Success(n) => compute(n, iter + 1)
        }
      }
    }
    compute(x, 1)
  }

}
