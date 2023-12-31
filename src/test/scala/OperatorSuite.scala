import org.scalatest.funsuite.AnyFunSuite

class OperatorSuite extends AnyFunSuite{
  val calc = new Operator

  test("addition") {
    assert(calc.add(5, 2) == 7)
    assert(calc.add(5, 0) == 5)
  }

  test("subtraction") {
    assert(calc.subtract(5, 2) == 3)
  }

  test("multiplication") {
    assert(calc.multiply(5, 0) == 0)
    assert(calc.multiply(3, 4) == 12)
  }

  test("dividing") {
    assertThrows[ArithmeticException](calc.divide(5, 0))
    assert(calc.divide(5, 2) == 2)
  }

}
