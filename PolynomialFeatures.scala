object PolynomialFeatures {

  def main(args: Array[String]): Unit = {

    // Input dataset
    val numbers = List(1, 2, 3)

    // Generate polynomial features up to degree 3
    val polynomialFeatures = numbers.flatMap { x =>
      List(
        x,
        x * x,
        x * x * x
      )
    }

    // Display input
    println("Input:")
    println(numbers)

    // Display output
    println("Polynomial Features:")
    println(polynomialFeatures)
  }
}
