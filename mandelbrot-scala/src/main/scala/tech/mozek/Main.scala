package tech.mozek

import javafx.application.Application as JavaFxApplication
import javafx.stage.Stage
import spire.math.Complex

object Main extends App {
  JavaFxApplication.launch(classOf[Main], args: _*)
}

class Main extends JavaFxApplication {

  override def start(stage: Stage): Unit = {
    val width = 740
    val height = 605
    val min = Complex[Double](-2, -1.2)
    val max = Complex[Double](1, 1.2)
    val canvas = new Canvas(width, height, min, max)
    canvas.displayScene(stage)
  }


}

