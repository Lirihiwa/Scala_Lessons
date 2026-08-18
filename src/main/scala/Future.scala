import scala.concurrent.{Future, Await}
import scala.concurrent.duration.*
import scala.concurrent.ExecutionContext.Implicits.global

def fetchOrderId(): Future[Int] =
  Future {
    Thread.sleep(2000)
    123
  }

def fetchPaymentStatus(orderId: Int): Future[String] =
  Future {
    Thread.sleep(2000)
    s"Order $orderId is PAID"
  }

def processIntegrations(): Future[String] =
  for
    orderId <- fetchOrderId()
    status <- fetchPaymentStatus(orderId)
  yield status

@main def main9(): Unit =
  val result = Await.result(processIntegrations(), 4.seconds)
  println(result)