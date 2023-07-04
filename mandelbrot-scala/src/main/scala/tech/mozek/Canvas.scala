package tech.mozek

import javafx.scene.Scene
import javafx.scene.canvas.Canvas as JavaFxCanvas
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.stage.Stage
import spire.math.Complex

import scala.collection.mutable

class Canvas(width: Int, height: Int, min: Complex[Double], max: Complex[Double]) {
  require(
    max.real > min.real && max.imag > min.imag,
    "for the canvas to work, both max real and imaginary components have to be larger")

  require(
    width >= 100 && height >= 100 && width <= 1000 && height <= 1000,
    "width and height must be between 200px-1000px")

  private val Offset = 0
  private val realStep =
    (max.real - min.real) / width
  private val imagStep =
    (max.imag - min.imag) / height

  private val fractalRootPane = new Pane()
  private val canvas          = new JavaFxCanvas()
  fractalRootPane.getChildren.add(canvas)
  private val graphicsContext = canvas.getGraphicsContext2D

  private def paintSet(): Unit = {
    canvas.setHeight(height.toDouble)
    canvas.setWidth(width.toDouble)
    canvas.setLayoutX(Offset.toDouble)
    canvas.setLayoutY(Offset.toDouble)

    val map = mutable.Map.empty[Int, Int] // This map is to show the distribution of the iterations
    (0 to 255).foreach(map.addOne(_, 0))

    for (x <- Range.inclusive(0, width)) {
      val r = min.real + (realStep * x)
      for (y <- Range.inclusive(0, height)) {
        val imag             = min.imag + (imagStep * y)
        val convergenceValue = Mandelbrot.compute(Complex[Double](r, imag))
        map.addOne((convergenceValue, map(convergenceValue) + 1))
        val greyScale =
          1.0 - math.min(
            convergenceValue / 40.0,
            1.0
          ) // the number divide by should be smaller than 256, making it smaller reduces resolution
        graphicsContext.setFill(Color.color(greyScale, greyScale, greyScale))
        graphicsContext.fillRect(x.toDouble, y.toDouble, 1.0, 1.0)
      }
    }

    println(map.mkString(", \n"))
  }

  def displayScene(primaryStage: Stage): Unit = {
    paintSet()
    val scene = new Scene(fractalRootPane, (width + 2 * Offset).toDouble, (height + 2 * Offset).toDouble)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}
