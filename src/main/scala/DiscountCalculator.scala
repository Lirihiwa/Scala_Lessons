def calculateDiscount(price: Double): Double =
  if price > 1000 then
    price * 0.1
  else if price >= 500 then
    price * 0.05
  else 0.0


@main def main1(): Unit =
  println(calculateDiscount(1200))
