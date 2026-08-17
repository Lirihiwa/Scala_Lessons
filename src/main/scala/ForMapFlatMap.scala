@main def main4(): Unit =
  val numbers = List(1, 2)
  val letters = List("A", "B")

  val resultFor = for
    n <- numbers
    l <- letters
  yield s"$n-$l"

  val resultMapFlatMap = numbers.flatMap(n =>
    letters.map(l =>
      s"$n-$l"
    ))

  println(resultFor)
  println(resultMapFlatMap)