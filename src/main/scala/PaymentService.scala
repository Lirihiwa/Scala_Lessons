case class User(id: String, name: String, balance: Double)

def getUserFromDb(id: String): Either[String, User] =
  if id == "123" then Right(User(id, "Alex", 500.0))
  else Left("Пользователь не найден")

def chargeFee(user: User, fee: Double): Either[String, User] =
  if user.balance >= fee then Right(user.copy(balance = user.balance - fee))
  else Left("Недостаточно средств для списания.")

def processPayment(id: String, fee: Double) =
  for
    user <- getUserFromDb(id)
    res <- chargeFee(user, fee)
  yield res

@main def main3(): Unit =
  processPayment("123", 10) match
    case Right(user) => println(user.balance)
    case Left(error) => println(error)

// Страрый код с использованием match
//@main def main3(): Unit =
//  getUserFromDb("123") match
//    case Some(user) => chargeFee(user, 1000) match
//      case Right(updatedUser) => println(updatedUser.balance)
//      case Left(error) => println(error)
//    case None => println(s"Пользователь не найден")