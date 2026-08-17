import Currency.*

enum Currency:
  case USD, EUR, RUB

case class Account(id: String, currency: Currency)

def getRoutingCode(account: Account): Int =
  account.currency match
    case USD => 100
    case EUR => 200
    case RUB => 810

@main def main2(): Unit =
  val account = Account("UUID:123", EUR)
  println(getRoutingCode(account))
