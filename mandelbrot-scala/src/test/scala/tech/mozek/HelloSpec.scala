package tech.mozek

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFunSuiteLike with Matchers {
  test("say hello") {
    "hello" shouldBe "hello"
  }
}
