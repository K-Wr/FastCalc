package test.complexnumber

import fastcalc.ComplexNumber

class ComplexOneSpec extends ComplexNumberSpec {
  val TEST_COUNT = 100
  val complexOne = new ComplexNumber(1.0, 0.0)
  val complexMinusOne = new ComplexNumber(-1.0, 0.0)

  "A one ComplexNumber" should "return b if it is multiplied by b" in {
    assertEqualComplexResult(TEST_COUNT, () => complexOne, (a, b) => b, generateNonZeroComplex, (a, b) => a * b)
  }

  it should "have radix of one" in {
    complexSelfRadixTest(1, () => complexOne, (a) => 1)
  }

  it should "have zero exponent" in {
    complexSelfExponentTest(1, () => complexOne, (a) => .0)
  }

  "A ComplexNumber (-1, 0)" should "have radix of one" in {
    complexSelfRadixTest(1, () => complexMinusOne, (a) => 1)
  }

  it should "have zero exponent" in {
    complexSelfExponentTest(1, () => complexMinusOne, (a) => .0)
  }

  "A ComplexNumber" should "return (-real, -imag) when multiplied by -1" in {
    assertEqualComplexResult(TEST_COUNT, () => complexMinusOne, (a, b) => new ComplexNumber(-b.getReal, -b.getImaginary),
      generateNonZeroComplex, (a, b) => a * b)
  }

  it should "return (-getReal, -getImag) when divided by -1" in {
    assertEqualComplexResult(TEST_COUNT, generateNonZeroComplex, (a, b) => new ComplexNumber(-a.getReal, -a.getImaginary),
      () => complexMinusOne, (a, b) => a / b)
  }

  it should "return itself when divided by one" in {
    assertEqualComplexResult(TEST_COUNT, generateNonZeroComplex, (a, b) => a, () => complexOne, (a, b) => a / b)
  }
}
